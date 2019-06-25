package gtrevolution.jei;

import java.util.List;

import com.google.common.collect.Lists;

import gregtech.api.GTValues;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.common.blocks.BlockBoilerCasing.BoilerCasingType;
import gregtech.common.blocks.BlockWireCoil.CoilType;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.integration.jei.multiblock.MultiblockInfoPage;
import gregtech.integration.jei.multiblock.MultiblockShapeInfo;
import gtrevolution.block.MetaBlocks;
import gtrevolution.block.MultiblockCasing;
import gtrevolution.machines.TileEntities;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.EnumFacing;

public class IndustrialChemicalReactorInfo extends MultiblockInfoPage {

    @Override
    public MultiblockControllerBase getController() {
        return TileEntities.INDUSTRIAL_CHEMICALREACTOR;
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        MultiblockShapeInfo shapeInfo = MultiblockShapeInfo.builder()
            .aisle("XXX", "XBX", "XXX")
            .aisle("XHX", "CPE", "XXX")
            .aisle("XXX", "XIX", "XXX")
            .where('C', TileEntities.INDUSTRIAL_CHEMICALREACTOR, EnumFacing.WEST)
            .where('X', MetaBlocks.MULTIBLOCK_CASING.getState(MultiblockCasing.CasingType.CHEMICAL_CASING))
            .where('I', MetaTileEntities.ITEM_IMPORT_BUS[GTValues.HV], EnumFacing.SOUTH)
            .where('E', MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.HV], EnumFacing.EAST)
            .where('B', MetaTileEntities.ITEM_EXPORT_BUS[GTValues.HV], EnumFacing.NORTH)
            .where('P', gregtech.common.blocks.MetaBlocks.BOILER_CASING.getState(BoilerCasingType.STEEL_PIPE))
            .where('H', gregtech.common.blocks.MetaBlocks.WIRE_COIL.getState(CoilType.CUPRONICKEL))
            .build();
        return Lists.newArrayList(shapeInfo);
    }

    @Override
    public String[] getDescription() {
        return new String[] {I18n.format("gregtech.multiblock.industrial_chemicalreactor.description")};
    }

}
