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

        RecipesRefreshedPlus.LOGGER.info(configs.getConfigsList().size() + " configs set.");
    }
}
