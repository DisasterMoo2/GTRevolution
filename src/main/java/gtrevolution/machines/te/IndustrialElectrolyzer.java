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

public class IndustrialElectrolyzer extends IndustrialMachine
{

    private static final MultiblockAbility<?>[] ALLOWED_ABILITIES = {
        MultiblockAbility.IMPORT_ITEMS, MultiblockAbility.EXPORT_ITEMS, MultiblockAbility.INPUT_ENERGY, MultiblockAbility.IMPORT_FLUIDS, MultiblockAbility.EXPORT_FLUIDS
    };

    public IndustrialElectrolyzer(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.ELECTROLYZER_RECIPES, IndustrialType.EFFICIENCY);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder holder) {
        return new IndustrialElectrolyzer(metaTileEntityId);
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
            .aisle("XXX", "XXX", "XXX")
            .aisle("XXX", "X#X", "XXX")
            .aisle("XXX", "XSX", "XXX")
            .setAmountAtLeast('X', 2)
            .where('S', selfPredicate())
            .where('X', statePredicate(getCasingState()).or(abilityPartPredicate(ALLOWED_ABILITIES)))
            .where('#', isAirPredicate())
            .build();
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return GRTextures.ELECTROLYZER_CASING;
    }

    protected IBlockState getCasingState() {
        return MetaBlocks.MULTIBLOCK_CASING.getState(MultiblockCasing.CasingType.ELECTROLYZER_CASING);
    }
}