package gtrevolution.recipes;

import java.util.Arrays;

import gregtech.api.GTValues;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.blocks.BlockMetalCasing.MetalCasingType;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import gtrevolution.GRConfig;
import gtrevolution.GRMaterials;
import gtrevolution.block.MetaBlocks;
import gtrevolution.block.MultiblockCasing;
import gtrevolution.machines.TileEntities;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class RecipeAdditions {

    public static void init() {     	
    	//Casing Recipes
    	ModHandler.addShapedRecipe("maceration_casing", MetaBlocks.MULTIBLOCK_CASING.getItemVariant(MultiblockCasing.CasingType.MACERATION_CASING), "PhP", "PHP", "PwP", 'P', "platePalladium", 'H', "frameGtBlueSteel");
    	ModHandler.addShapedRecipe("washplant_casing", MetaBlocks.MULTIBLOCK_CASING.getItemVariant(MultiblockCasing.CasingType.WASHPLANT_CASING), "PhP", "PHP", "PwP", 'P', "plateBlueSteel", 'H', "frameGtBlueSteel");
    	ModHandler.addShapedRecipe("thermal_casing", MetaBlocks.MULTIBLOCK_CASING.getItemVariant(MultiblockCasing.CasingType.THERMAL_CASING), "PhP", "PHP", "PwP", 'P', "plateRedSteel", 'H', "frameGtBlueSteel");
    	ModHandler.addShapedRecipe("chemical_casing", MetaBlocks.MULTIBLOCK_CASING.getItemVariant(MultiblockCasing.CasingType.CHEMICAL_CASING), "PhP", "PHP", "PwP", 'P', "platePolytetrafluoroethylene", 'H', gregtech.common.blocks.MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.STEEL_SOLID, 1));
    	ModHandler.addShapedRecipe("fisher_casing", MetaBlocks.MULTIBLOCK_CASING.getItemVariant(MultiblockCasing.CasingType.FISHER_CASING), "PhP", "PHP", "PwP", 'P', "plateInconel792", 'H', "frameGtStaballoy");
    	ModHandler.addShapedRecipe("electrolyzer_casing", MetaBlocks.MULTIBLOCK_CASING.getItemVariant(MultiblockCasing.CasingType.ELECTROLYZER_CASING), "PhP", "PHP", "PwP", 'P', "platePotin", 'H', "frameGtStaballoy");
    	ModHandler.addShapedRecipe("centrifuge_casing", MetaBlocks.MULTIBLOCK_CASING.getItemVariant(MultiblockCasing.CasingType.CENTRIFUGE_CASING), "PhP", "PHP", "PwP", 'P', "plateInconel690", 'H', "frameGtStaballoy");
    	ModHandler.addShapedRecipe("wire_casing", MetaBlocks.MULTIBLOCK_CASING.getItemVariant(MultiblockCasing.CasingType.WIRE_CASING), "PhP", "PHP", "PwP", 'P', "plateTalonite", 'H', "frameGtStaballoy");
    	ModHandler.addShapedRecipe("sieve_casing", MetaBlocks.MULTIBLOCK_CASING.getItemVariant(MultiblockCasing.CasingType.SIEVE_CASING), "PhP", "PHP", "PwP", 'P', "plateEglinSteel", 'H', "frameGtBlueSteel");
    	ModHandler.addShapedRecipe("sieve_grate", MetaBlocks.MULTIBLOCK_CASING.getItemVariant(MultiblockCasing.CasingType.SIEVE_GRATE), "TPT", "WHW", "TWT", 'P', MetaItems.ITEM_FILTER.getStackForm(), 'T', "plateBlackSteel", 'W', "wireFineSteel", 'H', "frameGtSteel");
        
		if(GRConfig.multiblocks.EBF) {
			ModHandler.removeRecipeByName(new ResourceLocation("gregtech:electric_blast_furnace"));
			ModHandler.addShapedRecipe("improved_blast_furnace", TileEntities.BLAST_FURNACE.getStackForm(), "FFF", "CHC", "WCW", 'F', new ItemStack(Blocks.FURNACE, 1), 'C', "circuitBasic", 'H', gregtech.common.blocks.MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.INVAR_HEATPROOF, 1), 'W', "cableGtSingleTin");
		}
		
		//Industrial Machine Controllers recipes
		if(GRConfig.multiblocks.Macerator)ModHandler.addShapedRecipe("multiblock_industrial_macerator", TileEntities.INDUSTRIAL_MACERATOR.getStackForm(), "TWT", "MCM", "TIT", 'M', MetaTileEntities.MACERATOR[GTValues.HV].getStackForm(), 'C', "circuitMaster", 'W', MetaItems.COMPONENT_GRINDER_TUNGSTEN.getStackForm(), 'I', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'T', "plateTungstenCarbide");
		if(GRConfig.multiblocks.Thermal)ModHandler.addShapedRecipe("multiblock_industrial_thermalcentrifuge", TileEntities.INDUSTRIAL_THERMALCENTRIFUGE.getStackForm(), "TWT", "MCM", "TIT", 'M', "stickTalonite", 'W', "circuitMaster", 'C', MetaTileEntities.THERMAL_CENTRIFUGE[GTValues.HV].getStackForm(), 'I', "gearTalonite", 'T', "plateRedSteel");
		if(GRConfig.multiblocks.Orewash)ModHandler.addShapedRecipe("multiblock_industrial_orewasher", TileEntities.INDUSTRIAL_OREWASHER.getStackForm(), "TWT", "MCM", "TIT", 'M', "plateTalonite", 'I', "circuitMaster", 'C', MetaTileEntities.ORE_WASHER[GTValues.HV].getStackForm(), 'W', MetaItems.ELECTRIC_PUMP_EV, 'T', "plateBlueSteel");
		if(GRConfig.multiblocks.Electrolyzer)ModHandler.addShapedRecipe("multiblock_industrial_electrolyzer", TileEntities.INDUSTRIAL_ELECTROLYZER.getStackForm(), "TWT", "MCM", "TIT", 'M', MetaTileEntities.ELECTROLYZER[GTValues.HV].getStackForm(), 'W', "circuitMaster", 'C', "rotorStellite", 'I', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'T', "platePotin");
		if(GRConfig.multiblocks.Centrifuge)ModHandler.addShapedRecipe("multiblock_industrial_centrifuge", TileEntities.INDUSTRIAL_CENTRIFUGE.getStackForm(), "TWT", "MCM", "TIT", 'M', MetaTileEntities.CENTRIFUGE[GTValues.HV].getStackForm(), 'W', "circuitMaster", 'C', "rotorStellite", 'I', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'T', "plateInconel690");
		if(GRConfig.multiblocks.Reactor)ModHandler.addShapedRecipe("multiblock_industrial_chemicalreactor", TileEntities.INDUSTRIAL_CHEMICALREACTOR.getStackForm(), "TWT", "MCM", "TIT", 'M', MetaTileEntities.CHEMICAL_REACTOR[GTValues.HV].getStackForm(), 'W', "circuitElite", 'C', "rotorStellite", 'I', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'T', "platePolytetrafluorethylene");
		if(GRConfig.multiblocks.Fisher)ModHandler.addShapedRecipe("multiblock_industrial_fisher", TileEntities.INDUSTRIAL_FISHER.getStackForm(), "TWT", "MCM", "TWT", 'M', "wireFineElectrum", 'W', "circuitAdvanced", 'C', "rotorStellite", 'T', "plateInconel792");
		if(GRConfig.multiblocks.Wiremill)ModHandler.addShapedRecipe("multiblock_industrial_wiremill", TileEntities.INDUSTRIAL_WIREMILL.getStackForm(), "TCT", "MSM", "TCT", 'S', MetaTileEntities.WIREMILL[GTValues.HV].getStackForm(), 'M', "circuitMaster", 'C', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'T', "plateTalonite");
		if(GRConfig.multiblocks.Sifter)ModHandler.addShapedRecipe("multiblock_industrial_sifter", TileEntities.INDUSTRIAL_SIFTER.getStackForm(), "TCT", "WSW", "TCT", 'W', "cableGtQuadrupleCopper", 'C', "circuitMaster", 'S', MetaTileEntities.SIFTER[GTValues.HV].getStackForm(), 'T', "plateEglinSteel");

		if(GRConfig.multiblocks.OilRig)ModHandler.addShapedRecipe("multiblock_oil_rig", TileEntities.OIL_RIG.getStackForm(), "FFF", "ACA", "MMM", 'F', "frameGtSteel", 'A', "circuitGood", 'C', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'M', MetaItems.ELECTRIC_MOTOR_MV.getStackForm());

		//Disassembler recipes
		ModHandler.addShapedRecipe("disassembler.lv", TileEntities.DISASSEMBLER[0].getStackForm(), "RCR", "RHR", "GCG", 'H', MetaTileEntities.HULL[GTValues.LV].getStackForm(), 'C', "circuitBasic", 'R', MetaItems.ROBOT_ARM_LV.getStackForm(), 'G', "cableGtSingleTin");
		ModHandler.addShapedRecipe("disassembler.mv", TileEntities.DISASSEMBLER[1].getStackForm(), "RCR", "RHR", "GCG", 'H', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'C', "circuitGood", 'R', MetaItems.ROBOT_ARM_MV.getStackForm(), 'G', "cableGtSingleCopper");
		ModHandler.addShapedRecipe("disassembler.hv", TileEntities.DISASSEMBLER[2].getStackForm(), "RCR", "RHR", "GCG", 'H', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'C', "circuitAdvanced", 'R', MetaItems.ROBOT_ARM_HV.getStackForm(), 'G', "cableGtSingleGold");
		ModHandler.addShapedRecipe("disassembler.ev", TileEntities.DISASSEMBLER[3].getStackForm(), "RCR", "RHR", "GCG", 'H', MetaTileEntities.HULL[GTValues.EV].getStackForm(), 'C', "circuitElite", 'R', MetaItems.ROBOT_ARM_EV.getStackForm(), 'G', "cableGtSingleAluminium");
		ModHandler.addShapedRecipe("disassembler.iv", TileEntities.DISASSEMBLER[4].getStackForm(), "RCR", "RHR", "GCG", 'H', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'C', "circuitMaster", 'R', MetaItems.ROBOT_ARM_IV.getStackForm(), 'G', "cableGtSinglePlatinum");

    	
    	
    	RecipeMaps.INDUSTRIALFISHER.recipeBuilder()
											        .circuitMeta(1)
											        .outputs(new ItemStack(Items.FISH, 14, 0), new ItemStack(Items.FISH, 10, 1), new ItemStack(Items.FISH, 7, 2),  new ItemStack(Items.FISH, 4, 3))
											        .EUt(10)
											        .duration(6000)
											        .buildAndRegister();
    	
    	
    	//Machine Recipes
    	if(GRConfig.misc.Superconductors) {
    		for (OrePrefix Prefix : Arrays.asList(OrePrefix.dust, OrePrefix.dustSmall, OrePrefix.dustTiny)) {
    			
    			gregtech.api.recipes.RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (500L * Prefix.materialAmount / 3628800L)).EUt(30).input(Prefix, Materials.Lead, 2).input(Prefix, Materials.Bronze, 2).input(Prefix, Materials.Tin, 1).outputs(OreDictUnifier.getDust(GRMaterials.Potin, 5L * Prefix.materialAmount)).buildAndRegister();
    	    	gregtech.api.recipes.RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (600L * Prefix.materialAmount / 3628800L)).EUt(30).input(Prefix, Materials.Nickel, 2).input(Prefix, Materials.Niobium, 1).input(Prefix, Materials.Aluminium, 2).input(Prefix, Materials.Nichrome, 1).outputs(OreDictUnifier.getDust(GRMaterials.Inconel792, 6L * Prefix.materialAmount)).buildAndRegister();
    	    	gregtech.api.recipes.RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (800L * Prefix.materialAmount / 3628800L)).EUt(30).input(Prefix, Materials.Chrome, 1).input(Prefix, Materials.Niobium, 2).input(Prefix, Materials.Molybdenum, 2).input(Prefix, Materials.Nichrome, 3).outputs(OreDictUnifier.getDust(GRMaterials.Inconel690, 8L * Prefix.materialAmount)).buildAndRegister();
    	    	gregtech.api.recipes.RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (1000L * Prefix.materialAmount / 3628800L)).EUt(120).input(Prefix, Materials.Uranium, 9).input(Prefix, Materials.Titanium, 1).outputs(OreDictUnifier.getDust(GRMaterials.Staballoy, 10L * Prefix.materialAmount)).buildAndRegister();
    	    	gregtech.api.recipes.RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (1100L * Prefix.materialAmount / 3628800L)).EUt(120).input(Prefix, GRMaterials.Tantalloy60, 1).input(Prefix, Materials.Titanium, 6).input(Prefix, Materials.Yttrium, 4).outputs(OreDictUnifier.getDust(GRMaterials.Tantalloy61, 11L * Prefix.materialAmount)).buildAndRegister();
    	    	gregtech.api.recipes.RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (2500L * Prefix.materialAmount / 3628800L)).EUt(120).input(Prefix, Materials.Tungsten, 2).input(Prefix, Materials.Tantalum, 23).outputs(OreDictUnifier.getDust(GRMaterials.Tantalloy60, 25L * Prefix.materialAmount)).buildAndRegister();
    	    	gregtech.api.recipes.RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (1800L * Prefix.materialAmount / 3628800L)).EUt(30).input(Prefix, Materials.Cobalt, 7).input(Prefix, Materials.Chrome, 7).input(Prefix, Materials.Manganese, 2).input(Prefix, Materials.Titanium, 2).outputs(OreDictUnifier.getDust(GRMaterials.Stellite, 18L * Prefix.materialAmount)).buildAndRegister();
    	    	gregtech.api.recipes.RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (1100L * Prefix.materialAmount / 3628800L)).EUt(30).input(Prefix, Materials.Cobalt, 4).input(Prefix, Materials.Chrome, 4).input(Prefix, Materials.Phosphor, 2).input(Prefix, Materials.Molybdenum, 1).outputs(OreDictUnifier.getDust(GRMaterials.Talonite, 11L * Prefix.materialAmount)).buildAndRegister();
    	    	gregtech.api.recipes.RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (1000L * Prefix.materialAmount / 3628800L)).EUt(30).input(Prefix, Materials.Iron, 4).input(Prefix, Materials.Kanthal, 1).input(Prefix, Materials.Invar, 5).outputs(OreDictUnifier.getDust(GRMaterials.EglinBase, 10L * Prefix.materialAmount)).buildAndRegister();
    	    	gregtech.api.recipes.RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (1600L * Prefix.materialAmount / 3628800L)).EUt(30).input(Prefix, GRMaterials.EglinBase, 10).input(Prefix, Materials.Sulfur, 1).input(Prefix, Materials.Silicon, 4).input(Prefix, Materials.Carbon, 1).outputs(OreDictUnifier.getDust(GRMaterials.EglinSteel, 16L * Prefix.materialAmount)).buildAndRegister();
    	    	
    	    	if(GRConfig.misc.Superconductors) {
    	    		gregtech.api.recipes.RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (300L * Prefix.materialAmount / 3628800L)).EUt(8).input(Prefix, Materials.Redstone, 1).input(Prefix, Materials.Silicon, 1).input(Prefix, Materials.Tin, 1).outputs(OreDictUnifier.getDust(GRMaterials.SuperConductor[0], 3L * Prefix.materialAmount)).buildAndRegister();
    	    		gregtech.api.recipes.RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (600L * Prefix.materialAmount / 3628800L)).EUt(24).input(Prefix, Materials.Cadmium, 5).input(Prefix, Materials.Magnesium, 1).outputs(OreDictUnifier.getDust(GRMaterials.SuperConductor[1], 6L * Prefix.materialAmount)).buildAndRegister();
    	    		gregtech.api.recipes.RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (4000L * Prefix.materialAmount / 3628800L)).EUt(120).input(Prefix, Materials.Titanium, 1).input(Prefix, Materials.Barium, 9).input(Prefix, Materials.Copper, 10).fluidInputs(Materials.Oxygen.getFluid(20000)).outputs(OreDictUnifier.getDust(GRMaterials.SuperConductor[2], 40L * Prefix.materialAmount)).buildAndRegister();
    	    		gregtech.api.recipes.RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (400L * Prefix.materialAmount / 3628800L)).EUt(480).input(Prefix, Materials.Platinum, 3).input(Prefix, Materials.Uranium, 1).outputs(OreDictUnifier.getDust(GRMaterials.SuperConductor[3], 4L * Prefix.materialAmount)).buildAndRegister();
    	    		gregtech.api.recipes.RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (400L * Prefix.materialAmount / 3628800L)).EUt(1920).input(Prefix, Materials.Vanadium, 1).input(Prefix, Materials.Indium, 3).outputs(OreDictUnifier.getDust(GRMaterials.SuperConductor[4], 4L * Prefix.materialAmount)).buildAndRegister();
    	    		gregtech.api.recipes.RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (1400L * Prefix.materialAmount / 3628800L)).EUt(7680).input(Prefix, Materials.Titanium, 1).input(Prefix, Materials.Barium, 2).input(Prefix, Materials.Copper, 7).input(Prefix, Materials.Indium, 4).outputs(OreDictUnifier.getDust(GRMaterials.SuperConductor[5], 14L * Prefix.materialAmount)).buildAndRegister();
    	        }
    	    	
    		}
    	}
    }
}
