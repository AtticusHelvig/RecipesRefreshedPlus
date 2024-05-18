package net.atticus.recipes_refreshed_plus.recipe;

import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.atticus.recipes_refreshed_plus.recipe.ingredient.Ingredient;
import net.minecraft.util.Identifier;

public class ShapelessRecipeJson implements RecipeJson {
    private Identifier identifier;
    private JsonObject recipe;

    public ShapelessRecipeJson(Identifier recipeIdentifier, String category, String group,
            List<List<Ingredient>> ingredients, Ingredient output, int count) {
        identifier = recipeIdentifier;
        recipe = createShapelessRecipeJson(category, group, ingredients, output, count);
    }

    @Override
    public Identifier getIdentifier() {
        return identifier;
    }

    @Override
    public JsonObject getRecipe() {
        return recipe;
    }

    private static JsonObject createShapelessRecipeJson(String category, String group,
            List<List<Ingredient>> ingredients, Ingredient output, int count) {
        JsonObject json = new JsonObject();

        if (ingredients == null) {
            throw new IllegalArgumentException("ShapelessRecipe ingredients may not be null.");
        }
        if (output == null) {
            throw new IllegalArgumentException("ShapelessRecipe output may not be null.");
        }
        if (count < 1) {
            throw new IllegalArgumentException("ShapelessRecipe output count may not be less than 1.");
        }

        json.addProperty("type", "minecraft:crafting_shapeless");
        if (category != null) {
            json.addProperty("category", category);
        }
        if (group != null) {
            json.addProperty("group", group);
        }

        // Ingredients
        JsonArray ingredientsArray = new JsonArray();
        for (List<Ingredient> value : ingredients) {
            if (value.size() > 1) {
                JsonArray allowed = new JsonArray();
                for (Ingredient ingredient : value) {
                    JsonObject ingredientObject = new JsonObject();
                    ingredientObject.addProperty(ingredient.getType(), ingredient.getIdentifier().toString());
                    allowed.add(ingredientObject);
                }
                ingredientsArray.add(allowed);
            } else {
                JsonObject ingredientObject = new JsonObject();
                Ingredient ingredient = value.get(0);
                ingredientObject.addProperty(ingredient.getType(), ingredient.getIdentifier().toString());
                ingredientsArray.add(ingredientObject);
            }
        }
        json.add("ingredients", ingredientsArray);

        // Result
        JsonObject resultObject = new JsonObject();
        resultObject.addProperty("count", count);
        resultObject.addProperty("id", output.getIdentifier().toString());
        json.add("result", resultObject);

        return json;
    }
}
