package gtrevolution.jei;

import java.util.List;

import com.google.common.collect.Lists;

import gregtech.api.GTValues;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.api.unification.material.Materials;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.integration.jei.multiblock.MultiblockInfoPage;
import gregtech.integration.jei.multiblock.MultiblockShapeInfo;
import gtrevolution.machines.TileEntities;

import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;

public class OilRigInfo extends MultiblockInfoPage {

    @Override
    public MultiblockControllerBase getController() {
        return TileEntities.OIL_RIG;
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        MultiblockShapeInfo shapeInfo = MultiblockShapeInfo.builder()
                .aisle("XEX", "#F#", "#F#", "#F#", "###", "###", "###")
                .aisle("XXX", "FXF", "FXF", "FXF", "#X#", "#X#", "#X#")
                .aisle("ICO", "#F#", "#F#", "#F#", "###", "###", "###")
                .where('C', TileEntities.OIL_RIG, EnumFacing.SOUTH)
                .where('X', MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID))
                .where('#', Blocks.AIR.getDefaultState())
                .where('F', MetaBlocks.FRAMES.get(Materials.Steel).getDefaultState())
                .where('I', MetaTileEntities.FLUID_IMPORT_HATCH[GTValues.MV], EnumFacing.SOUTH)
                .where('E', MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.MV], EnumFacing.NORTH)
                .where('O', MetaTileEntities.FLUID_IMPORT_HATCH[GTValues.MV], EnumFacing.SOUTH)
                .build();
        return Lists.newArrayList(shapeInfo);
    }

    @Override
    public String[] getDescription() {
        return new String[] {I18n.format("gregtech.multiblock.oil_rig.description")};
    }

}
