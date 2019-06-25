package gtrevolution.jei;

import com.google.common.collect.Lists;
import gregtech.api.GTValues;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.integration.jei.multiblock.MultiblockInfoPage;
import gregtech.integration.jei.multiblock.MultiblockShapeInfo;
import gtrevolution.block.MetaBlocks;
import gtrevolution.block.MultiblockCasing;
import gtrevolution.machines.TileEntities;

import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;

import java.util.List;

public class IndustrialMaceratorInfo extends MultiblockInfoPage {

    @Override
    public MultiblockControllerBase getController() {
        return TileEntities.INDUSTRIAL_MACERATOR;
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        MultiblockShapeInfo shapeInfo = MultiblockShapeInfo.builder()
            .aisle("XXX", "XBX", "XXX")
            .aisle("XXX", "C#E", "XXX")
            .aisle("XXX", "XIX", "XXX")
            .where('C', TileEntities.INDUSTRIAL_MACERATOR, EnumFacing.WEST)
            .where('X', MetaBlocks.MULTIBLOCK_CASING.getState(MultiblockCasing.CasingType.MACERATION_CASING))
            .where('#', Blocks.AIR.getDefaultState())
            .where('I', MetaTileEntities.ITEM_IMPORT_BUS[GTValues.HV], EnumFacing.SOUTH)
            .where('E', MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.HV], EnumFacing.EAST)
            .where('B', MetaTileEntities.ITEM_EXPORT_BUS[GTValues.HV], EnumFacing.NORTH)
            .build();
        return Lists.newArrayList(shapeInfo);
    }

    @Override
    public String[] getDescription() {
        return new String[] {I18n.format("gregtech.multiblock.industrial_macerator.description")};
    }

}
