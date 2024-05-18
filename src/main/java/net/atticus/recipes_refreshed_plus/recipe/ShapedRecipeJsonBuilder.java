package net.atticus.recipes_refreshed_plus.recipe;

import net.atticus.recipes_refreshed_plus.recipe.ingredient.Ingredient;
import net.atticus.recipes_refreshed_plus.recipe.ingredient.Item;
import net.minecraft.util.Identifier;
import java.util.List;
import java.util.ArrayList;

public class ShapedRecipeJsonBuilder {
    private Identifier identifier = null;
    private String category = null;
    private String group = null;
    private List<Character> keys = null;
    private List<List<Ingredient>> ingredients = null;
    private List<String> pattern = null;
    private Ingredient output = null;
    private int count = 1;

    public ShapedRecipeJson build() {
        return new ShapedRecipeJson(identifier, category, group, keys, ingredients, pattern, output, count);
    }

    public ShapedRecipeJsonBuilder setIdentifier(String namespace, String path) {
        identifier = new Identifier(namespace, path);
        return this;
    }

    public ShapedRecipeJsonBuilder setIdentifier(String path) {
        identifier = new Identifier(path);
        return this;
    }

    public ShapedRecipeJsonBuilder setIdentifier(Identifier identifier) {
        this.identifier = identifier;
        return this;
    }

    public ShapedRecipeJsonBuilder setCategory(String category) {
        this.category = category;
        return this;
    }

    public ShapedRecipeJsonBuilder setGroup(String group) {
        this.group = group;
        return this;
    }

    public ShapedRecipeJsonBuilder setKeys(List<Character> keys) {
        this.keys = keys;
        return this;
    }

    public ShapedRecipeJsonBuilder addKey(Character key) {
        if (keys == null) {
            keys = new ArrayList<Character>();
        }
        keys.add(key);
        return this;
    }

    public ShapedRecipeJsonBuilder addKeyValuePair(Character key, Ingredient ingredient) {
        addKey(key);
        addSingleIngredient(ingredient);
        return this;
    }

    /**
     * Adds a key and matching ingredient of type Item (default namespace)
     * 
     * @param key
     * @param ingredient
     */
    public ShapedRecipeJsonBuilder addKeyValuePair(Character key, String ingredient) {
        addKey(key);
        addSingleIngredient(new Item(ingredient));
        return this;
    }

    public ShapedRecipeJsonBuilder setIngredients(List<List<Ingredient>> ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public ShapedRecipeJsonBuilder addSingleIngredient(Ingredient ingredient) {
        if (ingredients == null) {
            ingredients = new ArrayList<List<Ingredient>>();
        }
        ingredients.add(List.of(ingredient));
        return this;
    }

    /**
     * Adds an ingredient of type Item (default namespace)
     * 
     * @param ingredient
     */
    public ShapedRecipeJsonBuilder addSingleIngredient(String ingredient) {
        if (ingredients == null) {
            ingredients = new ArrayList<List<Ingredient>>();
        }
        ingredients.add(List.of(new Item(ingredient)));
        return this;
    }

    public ShapedRecipeJsonBuilder addMultiIngredient(List<Ingredient> ingredients) {
        if (this.ingredients == null) {
            this.ingredients = new ArrayList<List<Ingredient>>();
        }
        this.ingredients.add(ingredients);
        return this;
    }

    public ShapedRecipeJsonBuilder setPattern(List<String> pattern) {
        this.pattern = pattern;
        return this;
    }

    public ShapedRecipeJsonBuilder makePattern(String p1, String p2, String p3) {
        pattern = List.of(p1, p2, p3);
        return this;
    }

    public ShapedRecipeJsonBuilder makePattern(String p1, String p2) {
        pattern = List.of(p1, p2);
        return this;
    }

    public ShapedRecipeJsonBuilder makePattern(String p1) {
        pattern = List.of(p1);
        return this;
    }

    public ShapedRecipeJsonBuilder setOutput(Ingredient output) {
        this.output = output;
        return this;
    }

    /**
     * Sets an output of type Item (default namespace)
     * 
     * @param output
     */
    public ShapedRecipeJsonBuilder setOutput(String output) {
        this.output = new Item(output);
        return this;
    }

    public ShapedRecipeJsonBuilder setCount(int count) {
        this.count = count;
        return this;
    }
}
