package net.atticus.recipes_refreshed_plus.recipe;

import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.atticus.recipes_refreshed_plus.recipe.ingredient.Ingredient;
import net.minecraft.util.Identifier;

public class ShapedRecipeJson implements RecipeJson {
    private Identifier identifier;
    private JsonObject recipe;

    public ShapedRecipeJson(Identifier recipeIdentifier, String category, String group, List<Character> keys,
            List<List<Ingredient>> ingredients, List<String> pattern, Ingredient output, int count) {
        identifier = recipeIdentifier;
        recipe = createShapedRecipeJson(category, group, keys, ingredients, pattern, output, count);
    }

    @Override
    public Identifier getIdentifier() {
        return identifier;
    }

    @Override
    public JsonObject getRecipe() {
        return recipe;
    }

    private static JsonObject createShapedRecipeJson(String category, String group, List<Character> keys,
            List<List<Ingredient>> ingredients, List<String> pattern, Ingredient output, int count) {
        JsonObject json = new JsonObject();

        if (keys == null) {
            throw new IllegalArgumentException("ShapedRecipe keys may not be null.");
        }
        if (ingredients == null) {
            throw new IllegalArgumentException("ShapedRecipe ingredients may not be null.");
        }
        if (pattern == null) {
            throw new IllegalArgumentException("ShapedRecipe pattern may not be null.");
        }
        if (output == null) {
            throw new IllegalArgumentException("ShapedRecipe output may not be null.");
        }
        if (count < 1) {
            throw new IllegalArgumentException("ShapedRecipe output count may not be less than 1.");
        }

        json.addProperty("type", "minecraft:crafting_shaped");
        if (category != null) {
            json.addProperty("category", category);
        }
        if (group != null) {
            json.addProperty("group", group);
        }

        // Don't even bother trying to decipher this.
        JsonObject key = new JsonObject();
        for (int i = 0; i < keys.size(); i++) {
            if (ingredients.get(i).size() > 1) {
                JsonArray ingredientArray = new JsonArray();
                for (Ingredient ingredient : ingredients.get(i)) {
                    JsonObject ingredientObject = new JsonObject();
                    ingredientObject.addProperty(ingredient.getType(), ingredient.getIdentifier().toString());
                    ingredientArray.add(ingredientObject);
                }
                key.add(keys.get(i).toString(), ingredientArray);
            } else {
                Ingredient ingredient = ingredients.get(i).get(0);
                JsonObject ingredientObject = new JsonObject();
                ingredientObject.addProperty(ingredient.getType(), ingredient.getIdentifier().toString());
                key.add(keys.get(i).toString(), ingredientObject);
            }
        }
        json.add("key", key);

        // Pattern
        JsonArray patternArray = new JsonArray();
        for (String line : pattern) {
            patternArray.add(line);
        }
        json.add("pattern", patternArray);

        // Result
        JsonObject resultObject = new JsonObject();
        resultObject.addProperty("count", count);
        resultObject.addProperty("id", output.getIdentifier().toString());
        json.add("result", resultObject);

        return json;
    }
}
