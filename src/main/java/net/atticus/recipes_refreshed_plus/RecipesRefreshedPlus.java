package net.atticus.recipes_refreshed_plus;

import net.atticus.recipes_refreshed_plus.config.ModConfigs;
import net.atticus.recipes_refreshed_plus.recipe.ModRecipeManager;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecipesRefreshedPlus implements ModInitializer {
    public static final String MOD_ID = "recipes_refreshed_plus";
    public static final Logger LOGGER = LoggerFactory.getLogger("Recipes Refreshed Plus");

    @Override
    public void onInitialize() {
        ModConfigs.registerConfigs();
        ModRecipeManager.loadConfiguredRecipes();
    }

}
