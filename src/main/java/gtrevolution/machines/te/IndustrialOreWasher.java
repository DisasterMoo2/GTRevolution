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
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;

public class IndustrialOreWasher extends IndustrialMachine
{
	
    public IndustrialOreWasher(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.ORE_WASHER_RECIPES, IndustrialType.ITEM_PARALLEL);
    }
    
    private static final MultiblockAbility<?>[] ALLOWED_ABILITIES = {
            MultiblockAbility.IMPORT_ITEMS, MultiblockAbility.EXPORT_ITEMS, MultiblockAbility.INPUT_ENERGY
    };
    
    @Override
    public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder holder) {
        return new IndustrialOreWasher(metaTileEntityId);
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
            .aisle("XXXXX", "XXXXX", "XXXXX")
            .aisle("XXXXX", "X###X", "X###X").setRepeatable(5)
            .aisle("XXXXX", "XXSXX", "XXXXX")
            .setAmountAtLeast('X', 10)
            .where('S', selfPredicate())
            .where('X', statePredicate(getCasingState()).or(abilityPartPredicate(ALLOWED_ABILITIES)))
            .where('#', blockPredicate(Blocks.WATER))
            .build();
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return GRTextures.WASHPLANT_CASING;
    }

    protected IBlockState getCasingState() {
        return MetaBlocks.MULTIBLOCK_CASING.getState(MultiblockCasing.CasingType.WASHPLANT_CASING);
    }
}