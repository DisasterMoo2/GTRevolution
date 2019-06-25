package gtrevolution.machines;

import gtrevolution.GRConfig;
import gtrevolution.GTRevolution;
import gtrevolution.machines.te.*;
import gtrevolution.recipes.RecipeMaps;
import net.minecraft.util.ResourceLocation;
import gregtech.api.GregTechAPI;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.render.Textures;

public class TileEntities
{
    public static SimpleMachineMetaTileEntity[] DISASSEMBLER = new SimpleMachineMetaTileEntity[8];

    public static IndustrialMacerator INDUSTRIAL_MACERATOR;
    public static IndustrialThermalCentrifuge INDUSTRIAL_THERMALCENTRIFUGE;
    public static IndustrialOreWasher INDUSTRIAL_OREWASHER;
    public static IndustrialCentrifuge INDUSTRIAL_CENTRIFUGE;
    public static IndustrialElectrolyzer INDUSTRIAL_ELECTROLYZER;
    public static IndustrialChemicalReactor INDUSTRIAL_CHEMICALREACTOR;
    public static IndustrialFisher INDUSTRIAL_FISHER;
    public static IndustrialWiremill INDUSTRIAL_WIREMILL;
    public static IndustrialSifter INDUSTRIAL_SIFTER;
    public static ImprovedBlastFurnace BLAST_FURNACE;
    public static OilRig OIL_RIG;

    public static void init() {
    	DISASSEMBLER[0] = GregTechAPI.registerMetaTileEntity(3000, new SimpleMachineMetaTileEntity(location("disassembler.lv"), RecipeMaps.DISASSEMBLER_LV, Textures.ASSEMBLER_OVERLAY, 1));
    	DISASSEMBLER[1] = GregTechAPI.registerMetaTileEntity(3001, new SimpleMachineMetaTileEntity(location("disassembler.mv"), RecipeMaps.DISASSEMBLER_MV, Textures.ASSEMBLER_OVERLAY, 2));
    	DISASSEMBLER[2] = GregTechAPI.registerMetaTileEntity(3002, new SimpleMachineMetaTileEntity(location("disassembler.hv"), RecipeMaps.DISASSEMBLER_HV, Textures.ASSEMBLER_OVERLAY, 3));
    	DISASSEMBLER[3] = GregTechAPI.registerMetaTileEntity(3003, new SimpleMachineMetaTileEntity(location("disassembler.ev"), RecipeMaps.DISASSEMBLER_EV, Textures.ASSEMBLER_OVERLAY, 4));
    	DISASSEMBLER[4] = GregTechAPI.registerMetaTileEntity(3004, new SimpleMachineMetaTileEntity(location("disassembler.iv"), RecipeMaps.DISASSEMBLER_IV, Textures.ASSEMBLER_OVERLAY, 5));
    	
    	DISASSEMBLER[5] = GregTechAPI.registerMetaTileEntity(3005, new SimpleMachineMetaTileEntity(location("disassembler.luv"), RecipeMaps.DISASSEMBLER_IV, Textures.ASSEMBLER_OVERLAY, 6));
    	DISASSEMBLER[6] = GregTechAPI.registerMetaTileEntity(3006, new SimpleMachineMetaTileEntity(location("disassembler.zpm"), RecipeMaps.DISASSEMBLER_IV, Textures.ASSEMBLER_OVERLAY, 7));
    	DISASSEMBLER[7] = GregTechAPI.registerMetaTileEntity(3007, new SimpleMachineMetaTileEntity(location("disassembler.uv"), RecipeMaps.DISASSEMBLER_IV, Textures.ASSEMBLER_OVERLAY, 8));
    	
        if (GRConfig.multiblocks.Macerator) {
        	INDUSTRIAL_MACERATOR = GregTechAPI.registerMetaTileEntity(3008, new IndustrialMacerator(location("industrial_macerator")));
        }
        
        if (GRConfig.multiblocks.Thermal) {
        	INDUSTRIAL_THERMALCENTRIFUGE = GregTechAPI.registerMetaTileEntity(3009, new IndustrialThermalCentrifuge(location("industrial_thermalcentrifuge")));
        }
        
        if (GRConfig.multiblocks.Orewash) {
        	INDUSTRIAL_OREWASHER = GregTechAPI.registerMetaTileEntity(3010, new IndustrialOreWasher(location("industrial_orewasher")));
        }
        
        if (GRConfig.multiblocks.Electrolyzer) {
        	INDUSTRIAL_ELECTROLYZER = GregTechAPI.registerMetaTileEntity(3011, new IndustrialElectrolyzer(location("industrial_electrolyzer")));
        }
        
        if (GRConfig.multiblocks.Centrifuge) {
        	INDUSTRIAL_CENTRIFUGE = GregTechAPI.registerMetaTileEntity(3012, new IndustrialCentrifuge(location("industrial_centrifuge")));
        }
        
        if (GRConfig.multiblocks.Reactor) {
        	INDUSTRIAL_CHEMICALREACTOR = GregTechAPI.registerMetaTileEntity(3013, new IndustrialChemicalReactor(location("industrial_chemicalreactor")));
        }
        
        if (GRConfig.multiblocks.Fisher) {
        	INDUSTRIAL_FISHER = GregTechAPI.registerMetaTileEntity(3014, new IndustrialFisher(location("industrial_fisher")));
        }
        
        if(GRConfig.multiblocks.EBF) {
        	BLAST_FURNACE = GregTechAPI.registerMetaTileEntity(3015, new ImprovedBlastFurnace(location("improved_blast_furnace")));
        }
        
        if(GRConfig.multiblocks.Wiremill) {
        	INDUSTRIAL_WIREMILL = GregTechAPI.registerMetaTileEntity(3016, new IndustrialWiremill(location("industrial_wiremill")));
        }
        
        if(GRConfig.multiblocks.Wiremill) {
        	INDUSTRIAL_SIFTER = GregTechAPI.registerMetaTileEntity(3017, new IndustrialSifter(location("industrial_sifter")));
        }

        if(GRConfig.multiblocks.OilRig) {
            OIL_RIG = GregTechAPI.registerMetaTileEntity(3018, new OilRig(location("oil_rig")));
        }
    }
    
    private static ResourceLocation location(String name) {
		return new ResourceLocation(GTRevolution.MODID, name);
	}
}
