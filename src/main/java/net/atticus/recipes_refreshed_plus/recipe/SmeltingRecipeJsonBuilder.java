package net.atticus.recipes_refreshed_plus.recipe;

import net.atticus.recipes_refreshed_plus.recipe.ingredient.Ingredient;
import net.atticus.recipes_refreshed_plus.recipe.ingredient.Item;
import net.minecraft.util.Identifier;

public class SmeltingRecipeJsonBuilder {
    private Identifier identifier = null;
    private String category = null;
    private String group = null;
    private Ingredient ingredient = null;
    private int cookTime = 200;
    private float xp = 0f;
    private Ingredient output = null;

    public SmeltingRecipeJson build() {
        return new SmeltingRecipeJson(identifier, category, group, cookTime, xp, ingredient, output);
    }

    public SmeltingRecipeJsonBuilder setIdentifier(String namespace, String path) {
        identifier = new Identifier(namespace, path);
        return this;
    }

    public SmeltingRecipeJsonBuilder setIdentifier(String path) {
        identifier = new Identifier(path);
        return this;
    }

    public SmeltingRecipeJsonBuilder setIdentifier(Identifier identifier) {
        this.identifier = identifier;
        return this;
    }

    public SmeltingRecipeJsonBuilder setCategory(String category) {
        this.category = category;
        return this;
    }

    public SmeltingRecipeJsonBuilder setGroup(String group) {
        this.group = group;
        return this;
    }

    public SmeltingRecipeJsonBuilder setCookTime(int cookTime) {
        this.cookTime = cookTime;
        return this;
    }

    public SmeltingRecipeJsonBuilder setXp(float xp) {
        this.xp = xp;
        return this;
    }

    public SmeltingRecipeJsonBuilder setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
        return this;
    }

    /**
     * Sets an ingredient of type Item (default namespace)
     * 
     * @param ingredient
     * @return
     */
    public SmeltingRecipeJsonBuilder setIngredient(String ingredient) {
        return setIngredient(new Item(ingredient));
    }

    public SmeltingRecipeJsonBuilder setOutput(Ingredient output) {
        this.output = output;
        return this;
    }

    /**
     * Sets an output of type Item (default namespace)
     * 
     * @param output
     */
    public SmeltingRecipeJsonBuilder setOutput(String output) {
        this.output = new Item(output);
        return this;
    }
}
