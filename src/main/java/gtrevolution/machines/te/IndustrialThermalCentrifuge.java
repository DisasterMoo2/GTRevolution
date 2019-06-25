package gtrevolution.machines.te;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.multiblock.BlockPattern;
import gregtech.api.multiblock.FactoryBlockPattern;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.render.ICubeRenderer;
import gtrevolution.GRTextures;
import gtrevolution.block.MetaBlocks;
import gtrevolution.block.MultiblockCasing;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;

public class IndustrialThermalCentrifuge extends IndustrialMachine
{

    public IndustrialThermalCentrifuge(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.THERMAL_CENTRIFUGE_RECIPES, IndustrialType.ITEM_PARALLEL);
    }
    
    private static final MultiblockAbility<?>[] ALLOWED_ABILITIES = {
            MultiblockAbility.IMPORT_ITEMS, MultiblockAbility.EXPORT_ITEMS, MultiblockAbility.INPUT_ENERGY
    };
    
    @Override
    public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder holder) {
        return new IndustrialThermalCentrifuge(metaTileEntityId);
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
            .aisle("XXX", "XXX")
            .aisle("XXX", "XXX")
            .aisle("XSX", "XXX")
            .setAmountAtLeast('X', 8)
            .where('S', selfPredicate())
            .where('X', statePredicate(getCasingState()).or(abilityPartPredicate(ALLOWED_ABILITIES)))
            .where('#', isAirPredicate())
            .build();
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return GRTextures.THERMAL_CASING;
    }
    
    protected IBlockState getCasingState() {
        return MetaBlocks.MULTIBLOCK_CASING.getState(MultiblockCasing.CasingType.THERMAL_CASING);
    }
    

}