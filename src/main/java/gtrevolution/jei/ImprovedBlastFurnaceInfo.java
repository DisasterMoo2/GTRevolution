package gtrevolution.jei;

import gregtech.api.GTValues;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.common.blocks.BlockMetalCasing.MetalCasingType;
import gregtech.common.blocks.BlockWireCoil.CoilType;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.integration.jei.multiblock.MultiblockInfoPage;
import gregtech.integration.jei.multiblock.MultiblockShapeInfo;
import gtrevolution.machines.TileEntities;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;

import java.util.ArrayList;
import java.util.List;

public class ImprovedBlastFurnaceInfo extends MultiblockInfoPage {

    @Override
    public MultiblockControllerBase getController() {
        return TileEntities.BLAST_FURNACE;
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        for(CoilType coilType : CoilType.values()) {
            shapeInfo.add(MultiblockShapeInfo.builder()
                .aisle("IFX", "CCC", "CCC", "XXX")
                .aisle("SXE", "C#C", "C#C", "XXX")
                .aisle("ODX", "CCC", "CCC", "XXX")
                .where('X', MetaBlocks.METAL_CASING.getState(MetalCasingType.INVAR_HEATPROOF))
                .where('C', MetaBlocks.WIRE_COIL.getState(coilType))
                .where('S', TileEntities.BLAST_FURNACE, EnumFacing.WEST)

                .where('E', MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.MV], EnumFacing.EAST)
                .where('I', MetaTileEntities.ITEM_IMPORT_BUS[GTValues.LV], EnumFacing.WEST)
                .where('O', MetaTileEntities.ITEM_EXPORT_BUS[GTValues.LV], EnumFacing.WEST)

                .where('F', MetaTileEntities.FLUID_IMPORT_HATCH[GTValues.LV], EnumFacing.NORTH)
                .where('D', MetaTileEntities.FLUID_IMPORT_HATCH[GTValues.LV], EnumFacing.SOUTH)


                .where('#', Blocks.AIR.getDefaultState())
                .build());
        }
        return shapeInfo;
    }

    @Override
    public String[] getDescription() {
        return new String[] {I18n.format("gregtech.multiblock.electric_blast_furnace.description")};
    }

}
