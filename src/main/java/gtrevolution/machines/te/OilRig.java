package gtrevolution.machines.te;

import java.util.List;
import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.items.IItemHandlerModifiable;

import gregtech.api.capability.IMultipleTankHandler;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.multiblock.BlockPattern;
import gregtech.api.multiblock.FactoryBlockPattern;
import gregtech.api.multiblock.PatternMatchContext;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.api.render.ICubeRenderer;
import gregtech.api.render.Textures;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.GTUtility;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import gtrevolution.recipes.RecipeMaps;

public class OilRig extends RecipeMapMultiblockController{

    public static class ChunkReserve
    {
        private final FluidStack output;

        public ChunkReserve(int chunkX, int chunkZ, long worldSeed)
        {
            int a = chunkX;
            int b = chunkZ;
            //Non negatives
            a = a < 0 ? -a * 2 - 1 : a * 2;
            b = b < 0 ? -b * 2 - 1 : b * 2;
            long chunkID = a >= b ? a * a + a + b : a + b * b;
            Random rd = new Random(worldSeed + chunkID);
            float chance = rd.nextInt(10000) / 10000.0f;
            if (chance >= 0.5f) //Half chunks empty
            {
                int amount = (int) (chance * chance * 1000.0F); //outputs range from 250-1000 mB/operation
                int outputType = rd.nextInt(4);
                FluidStack outputFluid;
                switch (outputType)
                {
                    case 0:
                        outputFluid = Materials.OilHeavy.getFluid(amount);
                        break;
                    case 1:
                        outputFluid = Materials.OilLight.getFluid(amount);
                        break;
                    case 2:
                        outputFluid = Materials.OilMedium.getFluid(amount);
                        break;
                    default:
                        outputFluid = Materials.NaturalGas.getFluid(amount);
                        break;
                }
                this.output = outputFluid;
            }else{
                this.output = null;
            }
        }

        public FluidStack getOutput() { return this.output; }
    }

    private int tier;

    private static final MultiblockAbility<?>[] ALLOWED_ABILITIES = {
            MultiblockAbility.IMPORT_FLUIDS, MultiblockAbility.EXPORT_FLUIDS, MultiblockAbility.INPUT_ENERGY
    };

    public OilRig(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.OILRIG);
        this.recipeMapWorkable = new OilRig.OilRigLogic(this);

    }

    @Override
    public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder holder) {
        return new OilRig(metaTileEntityId);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        this.tier = GTUtility.getTierByVoltage(this.energyContainer.getInputVoltage());
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        this.tier = 0;
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        if(isStructureFormed()) {
            textList.add(new TextComponentTranslation("gregtech.multiblock.oil_rig.speed", tier * 4));
        }
        super.addDisplayText(textList);
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("XXX", "#F#", "#F#", "#F#", "###", "###", "###")
                .aisle("XCX", "FCF", "FCF", "FCF", "#F#", "#F#", "#F#")
                .aisle("XSX", "#F#", "#F#", "#F#", "###", "###", "###")
                .setAmountAtLeast('X', 4)
                .where('S', selfPredicate())
                .where('X', statePredicate(getCasingState()).or(abilityPartPredicate(ALLOWED_ABILITIES)))
                .where('C', statePredicate(getCasingState()))
                .where('F', statePredicate(getFrameState()))
                .where('#', (tile) -> true)
                .build();
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return Textures.SOLID_STEEL_CASING;
    }

    protected IBlockState getCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID);
    }

    protected IBlockState getFrameState() {
        return MetaBlocks.FRAMES.get(Materials.Steel).getDefaultState();
    }

    protected class OilRigLogic extends MultiblockRecipeLogic
    {

        public OilRigLogic(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
        }

        @Override
        protected Recipe findRecipe(long maxVoltage, IItemHandlerModifiable inputs, IMultipleTankHandler fluidInputs) {
            Chunk chunkAt = this.getMetaTileEntity().getWorld().getChunkFromBlockCoords(this.getMetaTileEntity().getPos());
            FluidStack output = new ChunkReserve(chunkAt.x, chunkAt.z, this.getMetaTileEntity().getWorld().getSeed()).getOutput();
            RecipeMap<SimpleRecipeBuilder> rmap = (RecipeMap<SimpleRecipeBuilder>) this.recipeMap;
            return output == null ? null : rmap.recipeBuilder()
                    .fluidInputs(Materials.Lubricant.getFluid(1))
                    .fluidOutputs(output)
                    .EUt(100)
                    .duration(400)
                    .build().getResult();
        }
    }
}
