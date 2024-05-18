package net.atticus.recipes_refreshed_plus.recipe;

import com.google.gson.JsonObject;

import net.atticus.recipes_refreshed_plus.recipe.ingredient.Ingredient;
import net.minecraft.util.Identifier;

public class BlastingRecipeJson implements RecipeJson {
    private Identifier identifier;
    private JsonObject recipe;

    public BlastingRecipeJson(Identifier recipeIdentifier, String category, String group, int cookTime, float xp,
            Ingredient ingredient, Ingredient output) {
        identifier = recipeIdentifier;
        recipe = createBlastingRecipeJson(category, group, cookTime, xp, ingredient, output);
    }

    @Override
    public Identifier getIdentifier() {
        return identifier;
    }

    @Override
    public JsonObject getRecipe() {
        return recipe;
    }

    private static JsonObject createBlastingRecipeJson(String category, String group, int cookTime, float xp,
            Ingredient ingredient, Ingredient output) {
        JsonObject json = new JsonObject();

        if (ingredient == null) {
            throw new IllegalArgumentException("BlastingRecipe ingredients may not be null.");
        }
        if (output == null) {
            throw new IllegalArgumentException("BlastingRecipe output may not be null.");
        }
        if (cookTime < 1) {
            throw new IllegalArgumentException("BlastingRecipe cookTime may not be less than 1.");
        }
        if (xp < 0) {
            throw new IllegalArgumentException("BlastingRecipe xp may not be negative.");
        }

        json.addProperty("type", "minecraft:blasting");
        if (category != null) {
            json.addProperty("category", category);
        }
        if (group != null) {
            json.addProperty("group", group);
        }
        json.addProperty("cookingtime", cookTime);
        json.addProperty("experience", xp);

        JsonObject ingredientObject = new JsonObject();
        ingredientObject.addProperty(ingredient.getType(), ingredient.getIdentifier().toString());
        json.add("ingredient", ingredientObject);

        // Result
        JsonObject resultObject = new JsonObject();
        resultObject.addProperty("id", output.getIdentifier().toString());
        json.add("result", resultObject);

        return json;
    }
}
