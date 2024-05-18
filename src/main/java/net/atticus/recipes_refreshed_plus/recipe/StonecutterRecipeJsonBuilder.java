package net.atticus.recipes_refreshed_plus.recipe;

import net.atticus.recipes_refreshed_plus.recipe.ingredient.Ingredient;
import net.atticus.recipes_refreshed_plus.recipe.ingredient.Item;
import net.minecraft.util.Identifier;

public class StonecutterRecipeJsonBuilder {
    private Identifier identifier = null;
    private Ingredient ingredient = null;
    private Ingredient output = null;
    private int count = 1;

    public StonecutterRecipeJson build() {
        return new StonecutterRecipeJson(identifier, ingredient, output, count);
    }

    public StonecutterRecipeJsonBuilder setIdentifier(String namespace, String path) {
        identifier = new Identifier(namespace, path);
        return this;
    }

    public StonecutterRecipeJsonBuilder setIdentifier(String path) {
        identifier = new Identifier(path);
        return this;
    }

    public StonecutterRecipeJsonBuilder setIdentifier(Identifier identifier) {
        this.identifier = identifier;
        return this;
    }

    public StonecutterRecipeJsonBuilder setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
        return this;
    }

    /**
     * Sets an ingredient of type Item (default namespace)
     * 
     * @param ingredient
     * @return
     */
    public StonecutterRecipeJsonBuilder setIngredient(String ingredient) {
        return setIngredient(new Item(ingredient));
    }

    public StonecutterRecipeJsonBuilder setOutput(Ingredient output) {
        this.output = output;
        return this;
    }

    /**
     * Sets an output of type Item (default namespace)
     * 
     * @param output
     */
    public StonecutterRecipeJsonBuilder setOutput(String output) {
        this.output = new Item(output);
        return this;
    }

    public StonecutterRecipeJsonBuilder setCount(int count) {
        this.count = count;
        return this;
    }
}
