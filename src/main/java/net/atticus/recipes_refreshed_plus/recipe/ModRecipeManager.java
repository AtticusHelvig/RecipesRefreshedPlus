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
                        recipes.add(new SmeltingRecipeJsonBuilder()
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

                // PLUS VERSION
                if (ModConfigs.BEDROCK) {
                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "bedrock")
                                        .setCategory("building")
                                        .addKeyValuePair('#', "netherite_block")
                                        .addKeyValuePair('A', "reinforced_deepslate")
                                        .addKeyValuePair('B', "obsidian")
                                        .makePattern("BAB", "A#A", "BAB")
                                        .setOutput("bedrock")
                                        .build());
                }

                if (ModConfigs.BELL) {
                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "bell")
                                        .setCategory("building")
                                        .addKeyValuePair('#', "stick")
                                        .addKeyValuePair('A', "gold_ingot")
                                        .addKeyValuePair('B', "gold_nugget")
                                        .makePattern("###", " A ", "ABA")
                                        .setOutput("bell")
                                        .build());
                }

                if (ModConfigs.MUSHROOM_BLOCKS) {
                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "brown_mushroom_block")
                                        .setCategory("building")
                                        .addKeyValuePair('#', "brown_mushroom")
                                        .makePattern("##", "##")
                                        .setOutput("brown_mushroom_block")
                                        .build());

                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "red_mushroom_block")
                                        .setCategory("building")
                                        .addKeyValuePair('#', "red_mushroom")
                                        .makePattern("##", "##")
                                        .setOutput("red_mushroom_block")
                                        .build());
                }

                if (ModConfigs.BUDDING_AMETHYST) {
                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "budding_amethyst")
                                        .setCategory("building")
                                        .addKeyValuePair('#', "amethyst_block")
                                        .addKeyValuePair('A', "amethyst_shard")
                                        .makePattern("A#A", "#A#", "A#A")
                                        .setOutput("budding_amethyst")
                                        .build());
                }

                if (ModConfigs.CHAIN_ARMOR) {
                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "chainmail_boots")
                                        .setCategory("equipment")
                                        .addKeyValuePair('#', "chain")
                                        .makePattern("# #", "# #")
                                        .setOutput("chainmail_boots")
                                        .build());

                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "chainmail_chestplate")
                                        .setCategory("equipment")
                                        .addKeyValuePair('#', "chain")
                                        .makePattern("# #", "###", "###")
                                        .setOutput("chainmail_chestplate")
                                        .build());

                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "chainmail_helmet")
                                        .setCategory("equipment")
                                        .addKeyValuePair('#', "chain")
                                        .makePattern("###", "# #")
                                        .setOutput("chainmail_helmet")
                                        .build());

                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "chainmail_leggings")
                                        .setCategory("building")
                                        .addKeyValuePair('#', "chain")
                                        .makePattern("###", "# #", "# #")
                                        .setOutput("chainmail_leggings")
                                        .build());
                }

                if (ModConfigs.COBWEB) {
                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "cobweb")
                                        .setCategory("misc")
                                        .addKeyValuePair('#', "string")
                                        .makePattern("# #", " # ", "# #")
                                        .setOutput("cobweb")
                                        .build());
                }

                if (ModConfigs.CRYING_OBSIDIAN) {
                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "crying_obsidian")
                                        .setCategory("building")
                                        .addKeyValuePair('#', "obsidian")
                                        .addKeyValuePair('A', "ghast_tear")
                                        .makePattern("###", "#A#", "###")
                                        .setOutput("crying_obsidian")
                                        .build());
                }

                if (ModConfigs.DEAD_BUSH) {
                        recipes.add(new ShapelessRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "dead_bush")
                                        .addSingleIngredient(new Tag("saplings"))
                                        .setOutput("dead_bush")
                                        .build());
                }

                if (ModConfigs.DEBUG_STICK) {
                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "debug_stick")
                                        .setCategory("misc")
                                        .addKeyValuePair('#', "stick")
                                        .addKeyValuePair('A', "netherite_ingot")
                                        .addKeyValuePair('B', "nether_star")
                                        .makePattern(" A ", "B#B", " A ")
                                        .setOutput("debug_stick")
                                        .build());
                }

                if (ModConfigs.HORSE_ARMOR) {
                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "diamond_horse_armor")
                                        .setCategory("equipment")
                                        .addKeyValuePair('#', "diamond")
                                        .addKeyValuePair('A', "leather")
                                        .makePattern("  #", "#A#", "###")
                                        .setOutput("diamond_horse_armor")
                                        .build());

                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "golden_horse_armor")
                                        .setCategory("equipment")
                                        .addKeyValuePair('#', "gold_ingot")
                                        .addKeyValuePair('A', "leather")
                                        .makePattern("  #", "#A#", "###")
                                        .setOutput("golden_horse_armor")
                                        .build());

                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "iron_horse_armor")
                                        .setCategory("equipment")
                                        .addKeyValuePair('#', "iron_ingot")
                                        .addKeyValuePair('A', "leather")
                                        .makePattern("  #", "#A#", "###")
                                        .setOutput("iron_horse_armor")
                                        .build());
                }

                if (ModConfigs.ENCHANTED_GOLDEN_APPLE) {
                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "enchanted_golden_apple")
                                        .setCategory("misc")
                                        .addKeyValuePair('#', "golden_apple")
                                        .addKeyValuePair('A', "gold_block")
                                        .addKeyValuePair('B', "nether_star")
                                        .makePattern("ABA", "A#A", "AAA")
                                        .setOutput("enchanted_golden_apple")
                                        .build());
                }

                if (ModConfigs.END_PORTAL_FRAME) {
                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "end_portal_frame")
                                        .setCategory("building")
                                        .addKeyValuePair('#', "end_stone")
                                        .addKeyValuePair('A', "ender_eye")
                                        .addKeyValuePair('B', "netherite_ingot")
                                        .makePattern(" B ", "A#A", "###")
                                        .setOutput("end_portal_frame")
                                        .build());
                }

                if (ModConfigs.GLOW_INK_SAC) {
                        recipes.add(new ShapelessRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "glow_ink_sac")
                                        .addSingleIngredient("glowstone_dust")
                                        .addSingleIngredient("ink_sac")
                                        .setOutput("glow_ink_sac")
                                        .build());
                }

                if (ModConfigs.GLOW_LICHEN) {
                        recipes.add(new ShapelessRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "glow_lichen")
                                        .addSingleIngredient("glowstone_dust")
                                        .addSingleIngredient("vine")
                                        .setOutput("glow_lichen")
                                        .build());
                }

                if (ModConfigs.GLOWSTONE_DUST) {
                        recipes.add(new ShapelessRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "glowstone_dust")
                                        .addSingleIngredient("glow_berries")
                                        .setOutput("glowstone_dust")
                                        .build());
                }

                if (ModConfigs.GRASS_BLOCK) {
                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "grass_block")
                                        .setCategory("building")
                                        .addKeyValuePair('#', "moss_carpet")
                                        .addKeyValuePair('A', "dirt")
                                        .makePattern("#", "A")
                                        .setOutput("grass_block")
                                        .build());
                }

                if (ModConfigs.LEATHER_FROM_SMELTING_ROTTEN_FLESH) {
                        recipes.add(new SmeltingRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID,
                                                        "leather_from_smelting_rotten_flesh")
                                        .setCategory("misc")
                                        .setIngredient("rotten_flesh")
                                        .setXp(0.1f)
                                        .setOutput("leather")
                                        .build());

                        recipes.add(new BlastingRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID,
                                                        "leather_from_blasting_rotten_flesh")
                                        .setCategory("misc")
                                        .setIngredient("rotten_flesh")
                                        .setXp(0.1f)
                                        .setOutput("leather")
                                        .build());
                }

                if (ModConfigs.MUSHROOM_STEM) {
                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "mushroom_stem")
                                        .setCategory("building")
                                        .addKeyValuePair('#', "red_mushroom")
                                        .addKeyValuePair('A', "brown_mushroom")
                                        .makePattern("#A", "A#")
                                        .setOutput("mushroom_stem")
                                        .build());
                }

                if (ModConfigs.NAME_TAG) {
                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "name_tag")
                                        .setCategory("misc")
                                        .addKeyValuePair('#', "string")
                                        .addKeyValuePair('A', "iron_ingot")
                                        .addKeyValuePair('B', "ink_sac")
                                        .makePattern("#", "A", "B")
                                        .setOutput("name_tag")
                                        .build());
                }

                if (ModConfigs.POINTED_DRIPSTONE_FROM_STONECUTTING) {
                        recipes.add(new StonecutterRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID,
                                                        "pointed_dripstone_from_stonecutting_dripstone_block")
                                        .setIngredient("dripstone_block")
                                        .setOutput("pointed_dripstone")
                                        .build());
                }

                if (ModConfigs.REINFORCED_DEEPSLATE) {
                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "reinforced_deepslate")
                                        .setCategory("building")
                                        .addKeyValuePair('#', "deepslate")
                                        .addKeyValuePair('A', "obsidian")
                                        .makePattern("###", "#A#", "###")
                                        .setOutput("reinforced_deepslate")
                                        .build());
                }

                if (ModConfigs.SADDLE) {
                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "saddle")
                                        .setCategory("equipment")
                                        .addKeyValuePair('#', "iron_ingot")
                                        .addKeyValuePair('A', "leather")
                                        .addKeyValuePair('B', "string")
                                        .makePattern("AAA", " B ", " # ")
                                        .setOutput("saddle")
                                        .build());
                }

                if (ModConfigs.SCULK_SENSOR) {
                        recipes.add(new ShapedRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "sculk_sensor")
                                        .setCategory("redstone")
                                        .addKeyValuePair('#', "ender_pearl")
                                        .addKeyValuePair('A', "glow_ink_sac")
                                        .addKeyValuePair('B', "repeater")
                                        .makePattern("A A", "#B#")
                                        .setOutput("sculk_sensor")
                                        .build());
                }

                if (ModConfigs.SHROOMLIGHT) {
                        recipes.add(new ShapelessRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "shroomlight")
                                        .addMultiIngredient(
                                                        List.of(
                                                                        new Item("mushroom_stem"),
                                                                        new Item("red_mushroom_block"),
                                                                        new Item("brown_mushroom_block")))
                                        .addSingleIngredient("glowstone")
                                        .setOutput("shroomlight")
                                        .build());
                }

                if (ModConfigs.STRING) {
                        recipes.add(new ShapelessRecipeJsonBuilder()
                                        .setIdentifier(RecipesRefreshedPlus.MOD_ID, "string")
                                        .addSingleIngredient(new Tag("wool"))
                                        .setOutput("string")
                                        .setCount(4)
                                        .build());
                }

                RecipesRefreshedPlus.LOGGER.info("Recipes Loaded");
        }
}