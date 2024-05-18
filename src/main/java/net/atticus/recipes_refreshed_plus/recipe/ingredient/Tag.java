package net.atticus.recipes_refreshed_plus.recipe.ingredient;

import net.minecraft.util.Identifier;

public class Tag implements Ingredient {
    private Identifier id;
    private String type = "tag";

    public Tag(Identifier identifier) {
        id = identifier;
    }

    public Tag(String path) {
        this(new Identifier(path));
    }

    public Tag(String namespace, String path) {
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
