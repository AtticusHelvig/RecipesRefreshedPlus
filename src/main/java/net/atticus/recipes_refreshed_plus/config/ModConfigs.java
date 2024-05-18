package net.atticus.recipes_refreshed_plus.config;

import com.mojang.datafixers.util.Pair;

import net.atticus.recipes_refreshed_plus.RecipesRefreshedPlus;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static boolean DEEPSLATE_STONECUTTING;
    public static boolean COBBLESTONE_FROM_STONE;
    public static boolean GLASS_FROM_BLASTING;
    public static boolean HANGING_SIGN_PLANKS;
    public static int BUTTON_COUNT;
    public static int FENCE_GATE_COUNT;
    public static int FENCE_COUNT;
    public static int HANGING_SIGN_COUNT;
    public static int IRON_TRAPDOOR_COUNT;
    public static int PRESSURE_PLATE_COUNT;
    public static int SIGN_COUNT;
    public static int STAIRS_COUNT;
    public static int TRAPDOOR_COUNT;

    // PLUS VERSION
    public static boolean POINTED_DRIPSTONE_FROM_STONECUTTING;
    public static boolean REINFORCED_DEEPSLATE;
    public static boolean SADDLE;
    public static boolean SCULK_SENSOR;
    public static boolean SHROOMLIGHT;
    public static boolean STRING;
    public static boolean BEDROCK;
    public static boolean BELL;
    public static boolean BUDDING_AMETHYST;
    public static boolean CHAIN_ARMOR;
    public static boolean COBWEB;
    public static boolean CRYING_OBSIDIAN;
    public static boolean DEAD_BUSH;
    public static boolean DEBUG_STICK;
    public static boolean ENCHANTED_GOLDEN_APPLE;
    public static boolean END_PORTAL_FRAME;
    public static boolean GLOW_INK_SAC;
    public static boolean GLOW_LICHEN;
    public static boolean GLOWSTONE_DUST;
    public static boolean GRASS_BLOCK;
    public static boolean HORSE_ARMOR;
    public static boolean LEATHER_FROM_SMELTING_ROTTEN_FLESH;
    public static boolean MUSHROOM_STEM;
    public static boolean MUSHROOM_BLOCKS;
    public static boolean NAME_TAG;
    public static boolean ORES;
    public static boolean CONCRETE_POWDER_FROM_SMELTING_CONCRETE;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(RecipesRefreshedPlus.MOD_ID).provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("deepslate_stonecutting", true));
        configs.addKeyValuePair(new Pair<>("cobblestone_from_stone", true));
        configs.addKeyValuePair(new Pair<>("glass_from_blasting", true));
        configs.addKeyValuePair(new Pair<>("hanging_sign_planks", true));
        configs.addKeyValuePair(new Pair<>("button.count", 4));
        configs.addKeyValuePair(new Pair<>("fence_gate.count", 2));
        configs.addKeyValuePair(new Pair<>("fence.count", 4));
        configs.addKeyValuePair(new Pair<>("hanging_sign.count", 6));
        configs.addKeyValuePair(new Pair<>("iron_trapdoor.count", 2));
        configs.addKeyValuePair(new Pair<>("pressure_plate.count", 6));
        configs.addKeyValuePair(new Pair<>("sign.count", 6));
        configs.addKeyValuePair(new Pair<>("stairs.count", 6));
        configs.addKeyValuePair(new Pair<>("trapdoor.count", 6));

        // PLUS VERSION
        configs.addKeyValuePair(new Pair<>("pointed_dripstone_from_stonecutting", true));
        configs.addKeyValuePair(new Pair<>("reinforced_deepslate", true));
        configs.addKeyValuePair(new Pair<>("saddle", true));
        configs.addKeyValuePair(new Pair<>("sculk_sensor", true));
        configs.addKeyValuePair(new Pair<>("shroomlight", true));
        configs.addKeyValuePair(new Pair<>("string", true));
        configs.addKeyValuePair(new Pair<>("bedrock", true));
        configs.addKeyValuePair(new Pair<>("bell", true));
        configs.addKeyValuePair(new Pair<>("budding_amethyst", true));
        configs.addKeyValuePair(new Pair<>("chain_armor", true));
        configs.addKeyValuePair(new Pair<>("cobweb", true));
        configs.addKeyValuePair(new Pair<>("crying_obsidian", true));
        configs.addKeyValuePair(new Pair<>("dead_bush", true));
        configs.addKeyValuePair(new Pair<>("debug_stick", true));
        configs.addKeyValuePair(new Pair<>("enchanted_golden_apple", true));
        configs.addKeyValuePair(new Pair<>("end_portal_frame", true));
        configs.addKeyValuePair(new Pair<>("glow_ink_sac", true));
        configs.addKeyValuePair(new Pair<>("glow_lichen", true));
        configs.addKeyValuePair(new Pair<>("glowstone_dust", true));
        configs.addKeyValuePair(new Pair<>("grass_block", true));
        configs.addKeyValuePair(new Pair<>("horse_armor", true));
        configs.addKeyValuePair(new Pair<>("leather_from_smelting_rotten_flesh", true));
        configs.addKeyValuePair(new Pair<>("mushroom_stem", true));
        configs.addKeyValuePair(new Pair<>("mushroom_blocks", true));
        configs.addKeyValuePair(new Pair<>("name_tag", true));
        configs.addKeyValuePair(new Pair<>("ores", true));
        configs.addKeyValuePair(new Pair<>("concrete_powder_from_smelting_concrete", true));

    }

    private static void assignConfigs() {
        DEEPSLATE_STONECUTTING = CONFIG.getOrDefault("deepslate_stonecutting", false);
        COBBLESTONE_FROM_STONE = CONFIG.getOrDefault("cobblestone_from_stone", false);
        GLASS_FROM_BLASTING = CONFIG.getOrDefault("glass_from_blasting", false);
        HANGING_SIGN_PLANKS = CONFIG.getOrDefault("hanging_sign_planks", false);
        BUTTON_COUNT = CONFIG.getOrDefault("button.count", 1);
        FENCE_GATE_COUNT = CONFIG.getOrDefault("fence_gate.count", 1);
        FENCE_COUNT = CONFIG.getOrDefault("fence.count", 3);
        HANGING_SIGN_COUNT = CONFIG.getOrDefault("hanging_sign.count", 6);
        IRON_TRAPDOOR_COUNT = CONFIG.getOrDefault("iron_trapdoor.count", 1);
        PRESSURE_PLATE_COUNT = CONFIG.getOrDefault("pressure_plate.count", 6);
        SIGN_COUNT = CONFIG.getOrDefault("sign.count", 6);
        STAIRS_COUNT = CONFIG.getOrDefault("stairs.count", 4);
        TRAPDOOR_COUNT = CONFIG.getOrDefault("trapdoor.count", 6);

        // PLUS VERSION
        POINTED_DRIPSTONE_FROM_STONECUTTING = CONFIG.getOrDefault("pointed_dripstone_from_stonecutting", false);
        REINFORCED_DEEPSLATE = CONFIG.getOrDefault("reinforced_deepslate", false);
        SADDLE = CONFIG.getOrDefault("saddle", false);
        SCULK_SENSOR = CONFIG.getOrDefault("sculk_sensor", false);
        SHROOMLIGHT = CONFIG.getOrDefault("shroomlight", false);
        STRING = CONFIG.getOrDefault("string", false);
        BEDROCK = CONFIG.getOrDefault("bedrock", false);
        BELL = CONFIG.getOrDefault("bell", false);
        BUDDING_AMETHYST = CONFIG.getOrDefault("budding_amethyst", false);
        CHAIN_ARMOR = CONFIG.getOrDefault("chain_armor", false);
        COBWEB = CONFIG.getOrDefault("cobweb", false);
        CRYING_OBSIDIAN = CONFIG.getOrDefault("crying_obsidian", false);
        DEAD_BUSH = CONFIG.getOrDefault("dead_bush", false);
        DEBUG_STICK = CONFIG.getOrDefault("debug_stick", false);
        ENCHANTED_GOLDEN_APPLE = CONFIG.getOrDefault("enchanted_golden_apple", false);
        END_PORTAL_FRAME = CONFIG.getOrDefault("end_portal_frame", false);
        GLOW_INK_SAC = CONFIG.getOrDefault("glow_ink_sac", false);
        GLOW_LICHEN = CONFIG.getOrDefault("glow_lichen", false);
        GLOWSTONE_DUST = CONFIG.getOrDefault("glowstone_dust", false);
        GRASS_BLOCK = CONFIG.getOrDefault("grass_block", false);
        HORSE_ARMOR = CONFIG.getOrDefault("horse_armor", false);
        LEATHER_FROM_SMELTING_ROTTEN_FLESH = CONFIG.getOrDefault("leather_from_smelting_rotten_flesh", true);
        MUSHROOM_STEM = CONFIG.getOrDefault("mushroom_stem", false);
        MUSHROOM_BLOCKS = CONFIG.getOrDefault("mushroom_blocks", false);
        NAME_TAG = CONFIG.getOrDefault("name_tag", false);
        ORES = CONFIG.getOrDefault("ores", false);
        CONCRETE_POWDER_FROM_SMELTING_CONCRETE = CONFIG.getOrDefault("concrete_powder_from_smelting_concrete", false);

        RecipesRefreshedPlus.LOGGER.info(configs.getConfigsList().size() + " configs set.");
    }
}
