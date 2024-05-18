package net.atticus.recipes_refreshed_plus.recipe;

import net.atticus.recipes_refreshed_plus.recipe.ingredient.Ingredient;
import net.atticus.recipes_refreshed_plus.recipe.ingredient.Item;
import net.minecraft.util.Identifier;

public class BlastingRecipeJsonBuilder {
    private Identifier identifier = null;
    private String category = null;
    private String group = null;
    private Ingredient ingredient = null;
    private int cookTime = 100;
    private float xp = 0f;
    private Ingredient output = null;

    public BlastingRecipeJson build() {
        return new BlastingRecipeJson(identifier, category, group, cookTime, xp, ingredient, output);
    }

    public BlastingRecipeJsonBuilder setIdentifier(String namespace, String path) {
        identifier = new Identifier(namespace, path);
        return this;
    }

    public BlastingRecipeJsonBuilder setIdentifier(String path) {
        identifier = new Identifier(path);
        return this;
    }

    public BlastingRecipeJsonBuilder setIdentifier(Identifier identifier) {
        this.identifier = identifier;
        return this;
    }

    public BlastingRecipeJsonBuilder setCategory(String category) {
        this.category = category;
        return this;
    }

    public BlastingRecipeJsonBuilder setGroup(String group) {
        this.group = group;
        return this;
    }

    public BlastingRecipeJsonBuilder setCookTime(int cookTime) {
        this.cookTime = cookTime;
        return this;
    }

    public BlastingRecipeJsonBuilder setXp(float xp) {
        this.xp = xp;
        return this;
    }

    public BlastingRecipeJsonBuilder setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
        return this;
    }

    /**
     * Sets an ingredient of type Item (default namespace)
     * 
     * @param ingredient
     * @return
     */
    public BlastingRecipeJsonBuilder setIngredient(String ingredient) {
        return setIngredient(new Item(ingredient));
    }

    public BlastingRecipeJsonBuilder setOutput(Ingredient output) {
        this.output = output;
        return this;
    }

    /**
     * Sets an output of type Item (default namespace)
     * 
     * @param output
     */
    public BlastingRecipeJsonBuilder setOutput(String output) {
        this.output = new Item(output);
        return this;
    }
}
