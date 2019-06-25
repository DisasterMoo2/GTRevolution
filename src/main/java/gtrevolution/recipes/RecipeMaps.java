package gtrevolution.recipes;

import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.IntCircuitRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import stanhebben.zenscript.annotations.ZenProperty;

public class RecipeMaps
{
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> DISASSEMBLER_LV,
                                                       DISASSEMBLER_MV,
                                                       DISASSEMBLER_HV,
                                                       DISASSEMBLER_EV,
                                                       DISASSEMBLER_IV,
	                                                   OILRIG;
	public static final RecipeMap<IntCircuitRecipeBuilder> INDUSTRIALFISHER;


    static {
    	DISASSEMBLER_LV = new RecipeMapDisassembler("disassembler.lv", 1);
    	DISASSEMBLER_MV = new RecipeMapDisassembler("disassembler.mv", 2);
    	DISASSEMBLER_HV = new RecipeMapDisassembler("disassembler.hv", 3);
    	DISASSEMBLER_EV = new RecipeMapDisassembler("disassembler.ev", 4);
    	DISASSEMBLER_IV = new RecipeMapDisassembler("disassembler.iv", 5);
    	INDUSTRIALFISHER = new RecipeMap<IntCircuitRecipeBuilder>("industrialfisher", 1, 1, 1, 6, 0, 0, 0, 0, new IntCircuitRecipeBuilder());
		OILRIG = new RecipeMap<SimpleRecipeBuilder>("oilrig", 0, 0, 0, 0, 1, 1, 1, 1, new SimpleRecipeBuilder());
    }
}
