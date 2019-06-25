package gtrevolution.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;

@JEIPlugin
public class JeiPlugin implements IModPlugin {

    public void registerCategories(IRecipeCategoryRegistration registry) {
        registry.addRecipeCategories(new MultiblockInfoCategory(registry.getJeiHelpers()));
    }

    @Override
    public void register(IModRegistry registry) {
        MultiblockInfoCategory.registerRecipes(registry);
    }
}
