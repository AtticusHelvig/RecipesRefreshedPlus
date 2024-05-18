package net.atticus.recipes_refreshed_plus.recipe;

import com.google.gson.JsonObject;

import net.minecraft.util.Identifier;

public interface RecipeJson {
    public Identifier getIdentifier();

    public JsonObject getRecipe();
}
