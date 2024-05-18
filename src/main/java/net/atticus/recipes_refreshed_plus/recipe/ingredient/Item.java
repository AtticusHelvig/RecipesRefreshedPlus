package net.atticus.recipes_refreshed_plus.recipe.ingredient;

import net.minecraft.util.Identifier;

public class Item implements Ingredient {
    private Identifier id;
    private String type = "item";

    public Item(Identifier identifier) {
        id = identifier;
    }

    public Item(String path) {
        this(new Identifier(path));
    }

    public Item(String namespace, String path) {
        this(new Identifier(namespace, path));
    }

    @Override
    public Identifier getIdentifier() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }
}
