package gtrevolution.machines.te;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import gregtech.api.capability.IMultipleTankHandler;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.multiblock.PatternMatchContext;
import gregtech.api.recipes.CountableIngredient;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.GTUtility;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.items.IItemHandlerModifiable;

public abstract class IndustrialMachine extends RecipeMapMultiblockController {

	protected enum IndustrialType{
		ITEM_PARALLEL,
		EFFICIENCY;
	}
	
	protected IndustrialType type;
	protected int parallel;
	protected float euCostMult, durationMult;
	
	public IndustrialMachine(ResourceLocation metaTileEntityId, RecipeMap<SimpleRecipeBuilder> recipes, IndustrialType type) {
        super(metaTileEntityId, recipes);
        this.type = type;
        if(type == IndustrialType.ITEM_PARALLEL) {
        	this.recipeMapWorkable = new IndustrialParallelLogic(this);
        }else if(type == IndustrialType.EFFICIENCY){
        	this.recipeMapWorkable = new IndustrialEfficientLogic(this);
        }
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        this.parallel = Math.max(1, 4 * GTUtility.getTierByVoltage(this.energyContainer.getInputVoltage()));
        this.euCostMult = 1 - GTUtility.getTierByVoltage(this.energyContainer.getInputVoltage()) * 0.05f;
        if(this.euCostMult < 0.4f)this.euCostMult = 0.4f;
        this.durationMult = 0.7f;
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        this.parallel = 1;
        this.euCostMult = 1;
        this.durationMult = 1;
    }
    
    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        if(isStructureFormed()) {
        	if(type == IndustrialType.ITEM_PARALLEL) {
        		textList.add(new TextComponentTranslation("gtrevolution.multiblock.industrial_machine.parallel", parallel));
        	}else {
        		textList.add(new TextComponentTranslation("gtrevolution.multiblock.industrial_machine.efficient.discount", String.format("%.2f", 100 * (1 - euCostMult))));
        	}
        }
        super.addDisplayText(textList);
    }
	
	protected class IndustrialParallelLogic extends MultiblockRecipeLogic {
		
        public IndustrialParallelLogic(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
        }

        @Override
        protected Recipe findRecipe(long maxVoltage, IItemHandlerModifiable inputs, IMultipleTankHandler fluidInputs) {
        	Recipe normalRecipe = super.findRecipe(maxVoltage, inputs, fluidInputs);
            int currentItemsEngaged = 0;
            int maxItemsLimit = parallel;
            ArrayList<CountableIngredient> recipeInputs = new ArrayList<>();
            ArrayList<ItemStack> recipeOutputs = new ArrayList<>();
            FluidStack water = Materials.Water.getFluid(1000);

            for(int index = 0; index < inputs.getSlots(); index++) {
                ItemStack stackInSlot = inputs.getStackInSlot(index);
                if(stackInSlot.isEmpty())
                    continue;
                Recipe matchingRecipe = recipeMap.findRecipe(maxVoltage,
                    Collections.singletonList(stackInSlot), Collections.emptyList(), Integer.MAX_VALUE);
                //Try water
                if(matchingRecipe == null)matchingRecipe = recipeMap.findRecipe(maxVoltage,
                        Collections.singletonList(stackInSlot), Collections.singletonList(water), Integer.MAX_VALUE);
                CountableIngredient inputIngredient = matchingRecipe == null ? null : matchingRecipe.getInputs().get(0);
                

                if(inputIngredient != null && (maxItemsLimit - currentItemsEngaged) >= inputIngredient.getCount()) {
                    int overclockAmount = Math.min(stackInSlot.getCount() / inputIngredient.getCount(),
                        (maxItemsLimit - currentItemsEngaged) / inputIngredient.getCount());

                    recipeInputs.add(new CountableIngredient(inputIngredient.getIngredient(),
                        inputIngredient.getCount() * overclockAmount));
                    if(!matchingRecipe.getOutputs().isEmpty()) {
                    	for(ItemStack it : matchingRecipe.getOutputs()) {
                    		it = it.copy();
                    		it.setCount(it.getCount() * overclockAmount);
                    		recipeOutputs.add(it);
                    	}
                    }
                    if(!matchingRecipe.getChancedOutputs().isEmpty()) {
                    	for(ItemStack it : matchingRecipe.getChancedOutputs().keySet()) {
                    		it = it.copy();
                    		it.setCount(it.getCount() * overclockAmount);
                    		recipeOutputs.add(it);
                    	}
                    }
                    currentItemsEngaged += inputIngredient.getCount() * overclockAmount;
                }

                if(currentItemsEngaged >= maxItemsLimit) break;
            }
            int energyUsage, ticks;
            if (normalRecipe != null) {
            	energyUsage = normalRecipe.getEUt();
            	ticks = normalRecipe.getDuration();
            }else {
            	energyUsage = 30;
            	ticks = 256;
            }
                
            return recipeInputs.isEmpty() ? null : recipeMap.recipeBuilder()
                .inputsIngredients(recipeInputs)
                .outputs(recipeOutputs)
                .EUt(energyUsage)
                .duration(ticks)
                .build().getResult();
        }
    }
	
	protected class IndustrialEfficientLogic extends MultiblockRecipeLogic {

        public IndustrialEfficientLogic(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
        }

        @Override
        protected Recipe findRecipe(long maxVoltage, IItemHandlerModifiable inputs, IMultipleTankHandler fluidInputs) {
        	Recipe normalRecipe = super.findRecipe(maxVoltage, inputs, fluidInputs);
        	return normalRecipe == null ? null : this.recipeMap.recipeBuilder()
                    .inputsIngredients(normalRecipe.getInputs())
                    .fluidInputs(normalRecipe.getFluidInputs())
                    .outputs(normalRecipe.getOutputs())
                    .fluidOutputs(normalRecipe.getFluidOutputs())
                    .EUt((int)(normalRecipe.getEUt() * euCostMult))
                    .duration((int)(normalRecipe.getDuration() * durationMult))
                    .build().getResult();
        }
    }
}
