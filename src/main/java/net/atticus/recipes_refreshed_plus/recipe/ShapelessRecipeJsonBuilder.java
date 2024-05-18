package net.atticus.recipes_refreshed_plus.recipe;

import net.atticus.recipes_refreshed_plus.recipe.ingredient.Ingredient;
import net.atticus.recipes_refreshed_plus.recipe.ingredient.Item;
import net.minecraft.util.Identifier;
import java.util.List;
import java.util.ArrayList;

public class ShapelessRecipeJsonBuilder {
    private Identifier identifier = null;
    private String category = null;
    private String group = null;
    private List<List<Ingredient>> ingredients = null;
    private Ingredient output = null;
    private int count = 1;

    public ShapelessRecipeJson build() {
        return new ShapelessRecipeJson(identifier, category, group, ingredients, output, count);
    }

    public ShapelessRecipeJsonBuilder setIdentifier(String namespace, String path) {
        identifier = new Identifier(namespace, path);
        return this;
    }

    public ShapelessRecipeJsonBuilder setIdentifier(String path) {
        identifier = new Identifier(path);
        return this;
    }

    public ShapelessRecipeJsonBuilder setIdentifier(Identifier identifier) {
        this.identifier = identifier;
        return this;
    }

    public ShapelessRecipeJsonBuilder setCategory(String category) {
        this.category = category;
        return this;
    }

    public ShapelessRecipeJsonBuilder setGroup(String group) {
        this.group = group;
        return this;
    }

    public ShapelessRecipeJsonBuilder setIngredients(List<List<Ingredient>> ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public ShapelessRecipeJsonBuilder addSingleIngredient(Ingredient ingredient) {
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
    public ShapelessRecipeJsonBuilder addSingleIngredient(String ingredient) {
        if (ingredients == null) {
            ingredients = new ArrayList<List<Ingredient>>();
        }
        ingredients.add(List.of(new Item(ingredient)));
        return this;
    }

    public ShapelessRecipeJsonBuilder addMultiIngredient(List<Ingredient> ingredients) {
        if (this.ingredients == null) {
            this.ingredients = new ArrayList<List<Ingredient>>();
        }
        this.ingredients.add(ingredients);
        return this;
    }

    public ShapelessRecipeJsonBuilder setOutput(Ingredient output) {
        this.output = output;
        return this;
    }

    /**
     * Sets an output of type Item (default namespace)
     * 
     * @param output
     */
    public ShapelessRecipeJsonBuilder setOutput(String output) {
        this.output = new Item(output);
        return this;
    }

    public ShapelessRecipeJsonBuilder setCount(int count) {
        this.count = count;
        return this;
    }
}
