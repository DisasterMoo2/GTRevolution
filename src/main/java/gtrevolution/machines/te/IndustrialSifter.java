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

public class IndustrialSifter extends IndustrialMachine
{
	
	protected int parallel;

    private static final MultiblockAbility<?>[] ALLOWED_ABILITIES = {
        MultiblockAbility.IMPORT_ITEMS, MultiblockAbility.EXPORT_ITEMS, MultiblockAbility.INPUT_ENERGY
    };

    public IndustrialSifter(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.SIFTER_RECIPES, IndustrialType.ITEM_PARALLEL);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder holder) {
        return new IndustrialSifter(metaTileEntityId);
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
            .aisle("XXXXX", "YYYYY", "YYYYY")
            .aisle("XYYYX", "YYYYY", "YGGGY").setRepeatable(3)
            .aisle("XXSXX", "YYYYY", "YYYYY")
            .setAmountAtLeast('Y', 35)
            .where('S', selfPredicate())
            .where('Y', statePredicate(getCasingState()))
            .where('X', statePredicate(getCasingState()).or(abilityPartPredicate(ALLOWED_ABILITIES)))
            .where('G', statePredicate(MetaBlocks.MULTIBLOCK_CASING.getState(MultiblockCasing.CasingType.SIEVE_GRATE)))
            .build();
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return GRTextures.SIEVE_CASING;
    }

    protected IBlockState getCasingState() {
        return MetaBlocks.MULTIBLOCK_CASING.getState(MultiblockCasing.CasingType.SIEVE_CASING);
    }
}