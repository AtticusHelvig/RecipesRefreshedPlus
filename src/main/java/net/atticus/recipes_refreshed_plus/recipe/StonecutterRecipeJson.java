package net.atticus.recipes_refreshed_plus.recipe;

import com.google.gson.JsonObject;

import net.atticus.recipes_refreshed_plus.recipe.ingredient.Ingredient;
import net.minecraft.util.Identifier;

public class StonecutterRecipeJson implements RecipeJson {
    private Identifier identifier;
    private JsonObject recipe;

    public StonecutterRecipeJson(Identifier recipeIdentifier, Ingredient ingredient, Ingredient output, int count) {
        identifier = recipeIdentifier;
        recipe = createStonecutterRecipeJson(ingredient, output, count);
    }

    @Override
    public Identifier getIdentifier() {
        return identifier;
    }

    @Override
    public JsonObject getRecipe() {
        return recipe;
    }

    private static JsonObject createStonecutterRecipeJson(Ingredient ingredient, Ingredient output, int count) {
        JsonObject json = new JsonObject();

        if (ingredient == null) {
            throw new IllegalArgumentException("StonecutterRecipe ingredient may not be null.");
        }
        if (output == null) {
            throw new IllegalArgumentException("StonecutterRecipe output may not be null.");
        }
        if (count < 1) {
            throw new IllegalArgumentException("StonecutterRecipe output count may not be less than 1.");
        }
        json.addProperty("type", "minecraft:stonecutting");

        // Ingredients
        JsonObject ingredientObject = new JsonObject();
        ingredientObject.addProperty(ingredient.getType(), ingredient.getIdentifier().toString());
        json.add("ingredient", ingredientObject);

        // Result
        JsonObject resultObject = new JsonObject();
        resultObject.addProperty("count", count);
        resultObject.addProperty("id", output.getIdentifier().toString());
        json.add("result", resultObject);

        return json;
    }
}
