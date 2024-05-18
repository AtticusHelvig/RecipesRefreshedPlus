package net.atticus.recipes_refreshed_plus.recipe;

import com.google.gson.JsonObject;

import net.atticus.recipes_refreshed_plus.recipe.ingredient.Ingredient;
import net.minecraft.util.Identifier;

public class SmeltingRecipeJson implements RecipeJson {
    private Identifier identifier;
    private JsonObject recipe;

    public SmeltingRecipeJson(Identifier recipeIdentifier, String category, String group, int cookTime, float xp,
            Ingredient ingredient, Ingredient output) {
        identifier = recipeIdentifier;
        recipe = createSmeltingRecipeJson(category, group, cookTime, xp, ingredient, output);
    }

    @Override
    public Identifier getIdentifier() {
        return identifier;
    }

    @Override
    public JsonObject getRecipe() {
        return recipe;
    }

    private static JsonObject createSmeltingRecipeJson(String category, String group, int cookTime, float xp,
            Ingredient ingredient, Ingredient output) {
        JsonObject json = new JsonObject();

        if (ingredient == null) {
            throw new IllegalArgumentException("SmeltingRecipe ingredients may not be null.");
        }
        if (output == null) {
            throw new IllegalArgumentException("SmeltingRecipe output may not be null.");
        }
        if (cookTime < 1) {
            throw new IllegalArgumentException("SmeltingRecipe cookTime may not be less than 1.");
        }
        if (xp < 0) {
            throw new IllegalArgumentException("SmeltingRecipe xp may not be negative.");
        }

        json.addProperty("type", "minecraft:smelting");
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
