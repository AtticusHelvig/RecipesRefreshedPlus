package net.atticus.recipes_refreshed_plus.recipe;

import java.util.ArrayList;
import java.util.List;

import net.atticus.recipes_refreshed_plus.RecipesRefreshedPlus;
import net.atticus.recipes_refreshed_plus.config.ModConfigs;
import net.atticus.recipes_refreshed_plus.recipe.ingredient.Item;
import net.atticus.recipes_refreshed_plus.recipe.ingredient.Tag;

public class ModRecipeManager {
        public static List<RecipeJson> recipes;
        private static final String[] woodVariants = { "acacia", "bamboo", "birch", "cherry", "crimson", "dark_oak",
                        "jungle", "mangrove", "oak", "spruce", "warped" };

        public static void loadConfiguredRecipes() {
                recipes = new ArrayList<RecipeJson>();

                if (ModConfigs.COBBLESTONE_FROM_STONE) {
                        recipes.add(new StonecutterRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID,
                                                        "cobblestone_from_stonecutting_stone")
                                        .setIngredient("stone")
                                        .setOutput("cobblestone")
                                        .build());
                }

                if (ModConfigs.GLASS_FROM_BLASTING) {
                        recipes.add(new BlastingRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "glass_from_blasting")
                                        .setIngredient(new Tag("smelts_to_glass"))
                                        .setOutput("glass")
                                        .setXp(0.1f)
                                        .build());
                }

                if (ModConfigs.DEEPSLATE_STONECUTTING) {
                        String[] deepslateVariants = { "cobbled_deepslate", "deepslate_brick", "deepslate_tile",
                                        "polished_deepslate" };

                        recipes.add(new StonecutterRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID,
                                                        "chiseled_deepslate_from_stonecutting_deepslate")
                                        .setIngredient("deepslate")
                                        .setOutput("chiseled_deepslate")
                                        .build());

                        recipes.add(new StonecutterRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID,
                                                        "cobbled_deepslate_from_stonecutting_deepslate")
                                        .setIngredient("deepslate")
                                        .setOutput("cobbled_deepslate")
                                        .build());

                        recipes.add(new StonecutterRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID,
                                                        "deepslate_bricks_from_stonecutting_deepslate")
                                        .setIngredient("deepslate")
                                        .setOutput("deepslate_bricks")
                                        .build());

                        recipes.add(new StonecutterRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID,
                                                        "deepslate_tiles_from_stonecutting_deepslate")
                                        .setIngredient("deepslate")
                                        .setOutput("deepslate_tiles")
                                        .build());

                        recipes.add(new StonecutterRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID,
                                                        "polished_deepslate_from_stonecutting_deepslate")
                                        .setIngredient("deepslate")
                                        .setOutput("polished_deepslate")
                                        .build());

                        for (String variant : deepslateVariants) {
                                recipes.add(new StonecutterRecipeJsonBuilder()
                                                .setIdentifier(RecipesRefreshedPlus.MOD_ID,
                                                                variant + "_stairs_from_deepslate_stonecutting")
                                                .setIngredient("deepslate")
                                                .setOutput(variant + "_stairs")
                                                .build());

                                recipes.add(new StonecutterRecipeJsonBuilder()
                                                .setIdentifier(RecipesRefreshedPlus.MOD_ID,
                                                                variant + "_slab_from_deepslate_stonecutting")
                                                .setIngredient("deepslate")
                                                .setOutput(variant + "_slab")
                                                .setCount(2)
                                                .build());

                                recipes.add(new StonecutterRecipeJsonBuilder()
                                                .setIdentifier(RecipesRefreshedPlus.MOD_ID,
                                                                variant + "_wall_from_deepslate_stonecutting")
                                                .setIngredient("deepslate")
                                                .setOutput(variant + "_wall")
                                                .build());
                        }
                }

                if (ModConfigs.HANGING_SIGN_PLANKS) {
                        for (String variant : woodVariants) {
                                recipes.add(new ShapedRecipeJsonBuilder()
                                                .setIdentifier(variant + "_hanging_sign")
                                                .setCategory("misc")
                                                .setGroup("hanging_sign")
                                                .addKeyValuePair('#', variant + "_planks")
                                                .addKeyValuePair('A', "chain")
                                                .makePattern("A A", "###", "###")
                                                .setOutput(variant + "_hanging_sign")
                                                .setCount(ModConfigs.HANGING_SIGN_COUNT)
                                                .build());
                        }
                }

                // Wood items
                for (String variant : woodVariants) {
                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(variant + "_stairs")
                                        .setCategory("building")
                                        .setGroup("wooden_stairs")
                                        .addKeyValuePair('#', variant + "_planks")
                                        .makePattern("#  ", "## ", "###")
                                        .setOutput(variant + "_stairs")
                                        .setCount(ModConfigs.STAIRS_COUNT)
                                        .build());

                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(variant + "_fence")
                                        .setCategory("misc")
                                        .setGroup("wooden_fence")
                                        .addKeyValuePair('#', variant + "_planks")
                                        .addKeyValuePair('A', "stick")
                                        .makePattern("#A#", "#A#")
                                        .setOutput(variant + "_fence")
                                        .setCount(ModConfigs.FENCE_COUNT)
                                        .build());

                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(variant + "_fence_gate")
                                        .setCategory("redstone")
                                        .setGroup("wooden_fence_gate")
                                        .addKeyValuePair('#', variant + "_planks")
                                        .addKeyValuePair('A', "stick")
                                        .makePattern("A#A", "A#A")
                                        .setOutput(variant + "_fence_gate")
                                        .setCount(ModConfigs.FENCE_GATE_COUNT)
                                        .build());

                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(variant + "_sign")
                                        .setCategory("misc")
                                        .setGroup("wooden_sign")
                                        .addKeyValuePair('#', variant + "_planks")
                                        .addKeyValuePair('A', "stick")
                                        .makePattern("###", "###", " A ")
                                        .setOutput(variant + "_sign")
                                        .setCount(ModConfigs.SIGN_COUNT)
                                        .build());

                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(variant + "_pressure_plate")
                                        .setCategory("redstone")
                                        .setGroup("wooden_pressure_plate")
                                        .addKeyValuePair('#', variant + "_planks")
                                        .makePattern("##")
                                        .setOutput(variant + "_pressure_plate")
                                        .setCount(ModConfigs.PRESSURE_PLATE_COUNT)
                                        .build());

                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(variant + "_trapdoor")
                                        .setCategory("redstone")
                                        .setGroup("wooden_trapdoor")
                                        .addKeyValuePair('#', variant + "_planks")
                                        .makePattern("###", "###")
                                        .setOutput(variant + "_trapdoor")
                                        .setCount(ModConfigs.TRAPDOOR_COUNT)
                                        .build());

                        recipes.add(new ShapelessRecipeJsonBuilder()
                                        .setIdentifier(variant + "_button")
                                        .setCategory("redstone")
                                        .setGroup("wooden_button")
                                        .addSingleIngredient(variant + "_planks")
                                        .setOutput(variant + "_button")
                                        .setCount(ModConfigs.BUTTON_COUNT)
                                        .build());
                }

                // STAIRS
                String[] normalStairs = { "bamboo_mosaic", "stone", "cobblestone", "mossy_cobblestone", "granite",
                                "polished_granite", "diorite", "polished_diorite", "andesite", "polished_andesite",
                                "cobbled_deepslate", "polished_deepslate", "sandstone", "smooth_sandstone",
                                "red_sandstone", "smooth_red_sandstone", "smooth_quartz", "prismarine",
                                "dark_prismarine", "blackstone", "polished_blackstone", "cut_copper",
                                "exposed_cut_copper", "weathered_cut_copper", "oxidized_cut_copper", "waxed_cut_copper",
                                "waxed_exposed_cut_copper", "waxed_weathered_cut_copper", "waxed_oxidized_cut_copper" };

                for (String variant : normalStairs) {
                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(variant + "_stairs")
                                        .setCategory("building")
                                        .addKeyValuePair('#', variant)
                                        .makePattern("#  ", "## ", "###")
                                        .setOutput(variant + "_stairs")
                                        .setCount(ModConfigs.STAIRS_COUNT)
                                        .build());
                }

                String[] pluralStairs = { "stone_brick", "mossy_stone_brick", "deepslate_brick", "deepslate_tile",
                                "brick", "mud_brick", "prismarine_brick", "nether_brick", "red_nether_brick",
                                "polished_blackstone_brick", "end_stone_brick" };

                for (String variant : pluralStairs) {
                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(variant + "_stairs")
                                        .setCategory("building")
                                        .addKeyValuePair('#', variant + "s")
                                        .makePattern("#  ", "## ", "###")
                                        .setOutput(variant + "_stairs")
                                        .setCount(ModConfigs.STAIRS_COUNT)
                                        .build());
                }

                recipes.add(new ShapedRecipeJsonBuilder()
                                .setIdentifier("purpur_stairs")
                                .setCategory("building")
                                .addKey('#')
                                .addMultiIngredient(List.of(
                                                new Item("purpur_block"),
                                                new Item("purpur_pillar")))
                                .makePattern("#  ", "## ", "###")
                                .setOutput("purpur_stairs")
                                .setCount(ModConfigs.STAIRS_COUNT)
                                .build());

                recipes.add(new ShapedRecipeJsonBuilder()
                                .setIdentifier("quartz_stairs")
                                .setCategory("building")
                                .addKey('#')
                                .addMultiIngredient(List.of(
                                                new Item("chiseled_quartz_block"),
                                                new Item("quartz_block"),
                                                new Item("quartz_pillar")))
                                .makePattern("#  ", "## ", "###")
                                .setOutput("quartz_stairs")
                                .setCount(ModConfigs.STAIRS_COUNT)
                                .build());

                // BUTTONS & PRESSURE PLATES
                String[] redstoneVariants = { "stone", "polished_blackstone" };

                for (String variant : redstoneVariants) {
                        recipes.add(new ShapelessRecipeJsonBuilder()
                                        .setIdentifier(variant + "_button")
                                        .setCategory("redstone")
                                        .addSingleIngredient(variant)
                                        .setOutput(variant + "_button")
                                        .setCount(ModConfigs.BUTTON_COUNT)
                                        .build());

                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(variant + "_pressure_plate")
                                        .setCategory("redstone")
                                        .addKeyValuePair('#', variant)
                                        .makePattern("##")
                                        .setOutput(variant + "_pressure_plate")
                                        .setCount(ModConfigs.PRESSURE_PLATE_COUNT)
                                        .build());
                }

                recipes.add(new ShapedRecipeJsonBuilder()
                                .setIdentifier("light_weighted_pressure_plate")
                                .setCategory("redstone")
                                .addKeyValuePair('#', "gold_ingot")
                                .makePattern("##")
                                .setOutput("light_weighted_pressure_plate")
                                .setCount(ModConfigs.PRESSURE_PLATE_COUNT)
                                .build());

                recipes.add(new ShapedRecipeJsonBuilder()
                                .setIdentifier("heavy_weighted_pressure_plate")
                                .setCategory("redstone")
                                .addKeyValuePair('#', "iron_ingot")
                                .makePattern("##")
                                .setOutput("heavy_weighted_pressure_plate")
                                .setCount(ModConfigs.PRESSURE_PLATE_COUNT)
                                .build());

                recipes.add(new ShapedRecipeJsonBuilder()
                                .setIdentifier("bamboo_pressure_plate")
                                .setCategory("redstone")
                                .setGroup("wooden_pressure_plate")
                                .addKeyValuePair('#', "bamboo_planks")
                                .makePattern("##")
                                .setOutput("bamboo_pressure_plate")
                                .setCount(ModConfigs.PRESSURE_PLATE_COUNT)
                                .build());

                // IRON TRAPDOOR
                recipes.add(new ShapedRecipeJsonBuilder()
                                .setIdentifier("iron_trapdoor")
                                .setCategory("redstone")
                                .addKeyValuePair('#', "iron_ingot")
                                .makePattern("##", "##")
                                .setOutput("iron_trapdoor")
                                .setCount(ModConfigs.IRON_TRAPDOOR_COUNT)
                                .build());

                RecipesRefreshedPlus.LOGGER.info("Recipes Loaded");
        }
}