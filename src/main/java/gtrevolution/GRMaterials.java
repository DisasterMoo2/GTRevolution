package gtrevolution;

import com.google.common.collect.ImmutableList;

import gregtech.api.GTValues;
import gregtech.api.unification.material.IMaterialHandler;
import gregtech.api.unification.material.MaterialIconSet;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.type.*;
import gregtech.api.unification.stack.MaterialStack;
import net.minecraftforge.fml.common.Loader;

@IMaterialHandler.RegisterMaterialHandler
public class GRMaterials implements IMaterialHandler {
	public static DustMaterial EglinBase;
	
    public static IngotMaterial Talonite,
    							Stellite,
    							Tantalloy60,
    							Tantalloy61,
    							Staballoy,
    							Inconel690,
    							Inconel792,
    							Potin,
    							EglinSteel,
    							Draconium,
    							AwkDraconium,
    							MeteoricIron,
    							Desh,
    							SuperConductor[];

    static {
    	long INGOT_FLAGS = DustMaterial.MatFlags.GENERATE_PLATE|
    			           SolidMaterial.MatFlags.GENERATE_ROD| 
    			           IngotMaterial.MatFlags.GENERATE_FOIL|
    			           SolidMaterial.MatFlags.GENERATE_GEAR|
    			           IngotMaterial.MatFlags.GENERATE_BOLT_SCREW|
    			           IngotMaterial.MatFlags.GENERATE_RING|
    			           SolidMaterial.MatFlags.GENERATE_FRAME|
    			           IngotMaterial.MatFlags.GENERATE_ROTOR;
        long ALLOY_FLAGS = INGOT_FLAGS |
        		Material.MatFlags.DECOMPOSITION_BY_CENTRIFUGING |  
                IngotMaterial.MatFlags.GENERATE_FINE_WIRE;
        
        Talonite =  new IngotMaterial(698, "talonite", 0xC54066, MaterialIconSet.METALLIC, 1, ImmutableList.of(new MaterialStack(Materials.Cobalt, 4), new MaterialStack(Materials.Chrome, 4), new MaterialStack(Materials.Phosphor, 2), new MaterialStack(Materials.Molybdenum, 1)), ALLOY_FLAGS);
        Stellite =  new IngotMaterial(697, "stellite", 0x663B5F, MaterialIconSet.METALLIC, 1, ImmutableList.of(new MaterialStack(Materials.Cobalt, 7), new MaterialStack(Materials.Chrome, 7), new MaterialStack(Materials.Manganese, 2), new MaterialStack(Materials.Titanium, 2)), ALLOY_FLAGS, null, 700);
        Tantalloy60 =  new IngotMaterial(696, "tantalloy60", 0xA8B2B7, MaterialIconSet.METALLIC, 1, ImmutableList.of(new MaterialStack(Materials.Tungsten, 2), new MaterialStack(Materials.Tantalum, 23)), ALLOY_FLAGS, null, 1400);
        Tantalloy61 =  new IngotMaterial(695, "tantalloy61", 0x99A4A8, MaterialIconSet.METALLIC, 1, ImmutableList.of(new MaterialStack(GRMaterials.Tantalloy60, 1), new MaterialStack(Materials.Titanium, 6), new MaterialStack(Materials.Yttrium, 4)), ALLOY_FLAGS, null, 1400);
        Staballoy =  new IngotMaterial(694, "staballoy", 0x373C34, MaterialIconSet.DULL, 1, ImmutableList.of(new MaterialStack(Materials.Uranium, 9), new MaterialStack(Materials.Titanium, 1)), ALLOY_FLAGS, null, 1400);
        Inconel690 =  new IngotMaterial(693, "inconel690", 0x56BD5D, MaterialIconSet.METALLIC, 1, ImmutableList.of(new MaterialStack(Materials.Chrome, 1), new MaterialStack(Materials.Niobium, 2), new MaterialStack(Materials.Molybdenum, 2), new MaterialStack(Materials.Nichrome, 3)), ALLOY_FLAGS, null, 700);
        Inconel792 =  new IngotMaterial(692, "inconel792", 0x489F4E, MaterialIconSet.METALLIC, 1, ImmutableList.of(new MaterialStack(Materials.Nickel, 2), new MaterialStack(Materials.Niobium, 1), new MaterialStack(Materials.Aluminium, 2), new MaterialStack(Materials.Nichrome, 1)), ALLOY_FLAGS, null, 700);
        Potin =  new IngotMaterial(691, "potin", 0x916D2A, MaterialIconSet.DULL, 1, ImmutableList.of(new MaterialStack(Materials.Lead, 2), new MaterialStack(Materials.Bronze, 2), new MaterialStack(Materials.Tin, 1)), ALLOY_FLAGS);
        EglinBase = new DustMaterial(690, "eglin_base", 0x763A10, MaterialIconSet.DULL, 1, ImmutableList.of(new MaterialStack(Materials.Iron, 4), new MaterialStack(Materials.Kanthal, 1), new MaterialStack(Materials.Invar, 5)), Material.MatFlags.DECOMPOSITION_BY_CENTRIFUGING);
        EglinSteel =  new IngotMaterial(689, "eglin_steel", 0x763A10, MaterialIconSet.DULL, 1, ImmutableList.of(new MaterialStack(GRMaterials.EglinBase, 10), new MaterialStack(Materials.Sulfur, 1), new MaterialStack(Materials.Silicon, 4), new MaterialStack(Materials.Carbon, 1)), ALLOY_FLAGS);
        
        //ALL NORMAL PIPE VALUES!!!
        Tantalloy60.setFluidPipeProperties(750, 4250, true);
        Tantalloy61.setFluidPipeProperties(900, 5800, true);
        Staballoy.setFluidPipeProperties(937, 7500, true);
        Inconel690.setFluidPipeProperties(1125, 4800, true);
        Inconel792.setFluidPipeProperties(1200, 5500, true);
        Potin.setFluidPipeProperties(72, 2000, true);
        
        if(GRConfig.misc.Superconductors) {
        	SuperConductor = new IngotMaterial[7];
        	SuperConductor[0] = new IngotMaterial(688, "superconductor_lv", 0xAC0000, MaterialIconSet.DULL, 1, ImmutableList.of(new MaterialStack(Materials.Redstone, 1), new MaterialStack(Materials.Silicon, 1), new MaterialStack(Materials.Tin, 1)), ALLOY_FLAGS, null, 1, 64, 1200);
        	SuperConductor[1] = new IngotMaterial(687, "superconductor_mv", 0x4C4C4C, MaterialIconSet.DULL, 1, ImmutableList.of(new MaterialStack(Materials.Cadmium, 5), new MaterialStack(Materials.Magnesium, 1)), ALLOY_FLAGS, null, 1, 128, 2500);
        	SuperConductor[2] = new IngotMaterial(686, "superconductor_hv", 0x2B1500, MaterialIconSet.DULL, 1, ImmutableList.of(new MaterialStack(Materials.Titanium, 1), new MaterialStack(Materials.Barium, 9), new MaterialStack(Materials.Copper, 10), new MaterialStack(Materials.Oxygen, 20)), INGOT_FLAGS | Material.MatFlags.DECOMPOSITION_BY_ELECTROLYZING, null, 1, 512, 3300);
        	SuperConductor[3] = new IngotMaterial(685, "superconductor_ev", 0x24FF24, MaterialIconSet.DULL, 1, ImmutableList.of(new MaterialStack(Materials.Platinum, 3), new MaterialStack(Materials.Uranium, 1)), ALLOY_FLAGS, null, 1, 512, 4400);
        	SuperConductor[4] = new IngotMaterial(684, "superconductor_iv", 0x2E002E, MaterialIconSet.DULL, 1, ImmutableList.of(new MaterialStack(Materials.Vanadium, 1), new MaterialStack(Materials.Indium, 3)), ALLOY_FLAGS, null, 1, 1024, 5200);
        	SuperConductor[5] = new IngotMaterial(683, "superconductor_luv", 0x820040, MaterialIconSet.DULL, 1, ImmutableList.of(new MaterialStack(Materials.Titanium, 1), new MaterialStack(Materials.Barium, 2), new MaterialStack(Materials.Copper, 7), new MaterialStack(Materials.Indium, 4)), ALLOY_FLAGS, null, 1, 1024, 6000);
        	SuperConductor[6] = new IngotMaterial(682, "superconductor_zpm", 0x111111, MaterialIconSet.DULL, 1, ImmutableList.of(new MaterialStack(Materials.Naquadah, 4), new MaterialStack(Materials.Indium, 2), new MaterialStack(Materials.Palladium, 6), new MaterialStack(Materials.Osmium, 1)), ALLOY_FLAGS, null, 1, 2048, 9000);
        	SuperConductor[0].setCableProperties(GTValues.V[GTValues.LV], 1, 0);
        	SuperConductor[1].setCableProperties(GTValues.V[GTValues.MV], 2, 0);
        	SuperConductor[2].setCableProperties(GTValues.V[GTValues.HV], 2, 0);
        	SuperConductor[3].setCableProperties(GTValues.V[GTValues.EV], 4, 0);
        	SuperConductor[4].setCableProperties(GTValues.V[GTValues.IV], 4, 0);
        	SuperConductor[5].setCableProperties(GTValues.V[GTValues.LuV], 8, 0);
        	SuperConductor[6].setCableProperties(GTValues.V[GTValues.ZPM], 8, 0);
        }
        
        if (Loader.isModLoaded("draconicevolution")){
        	Draconium = new IngotMaterial(681, "draconium", 0x68369A, MaterialIconSet.DULL, 6, ImmutableList.of(), INGOT_FLAGS, null, 6, 10240, 8500);
        	AwkDraconium = new IngotMaterial(680, "awkdraconium", 0xFFC400, MaterialIconSet.DULL, 7, ImmutableList.of(), INGOT_FLAGS, null, 6, 10240, 9200);
        	Draconium.setCableProperties(GTValues.ZPM, 4, 2);
        	Draconium.setFluidPipeProperties(1000, 1000000, true);
        	AwkDraconium.setCableProperties(GTValues.UV, 2, 1);
        	AwkDraconium.setFluidPipeProperties(2000, 1000000, true);
        }
        
        if (Loader.isModLoaded("GalacticraftCore")){
        	MeteoricIron = new IngotMaterial(679, "meteoriciron", 0x7D7165, MaterialIconSet.ROUGH, 4, ImmutableList.of(), INGOT_FLAGS, null, 3, 620, 2500);
        	Desh = new IngotMaterial(678, "desh", 0x313131, MaterialIconSet.ROUGH, 4, ImmutableList.of(), INGOT_FLAGS, null, 4, 2560, 3500);
        	Desh.setFluidPipeProperties(600, 3300, true);
        	Desh.setCableProperties(GTValues.IV, 2, 4);
        }
    }

	@Override
	public void onMaterialsInit()
	{

	}
}