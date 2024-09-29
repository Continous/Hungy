package xyz.fulmine.hungy.config;

import dev.isxander.yacl.api.ConfigEntry;
import dev.isxander.yacl.api.Option;
import dev.isxander.yacl.api.ConfigCategory;
import dev.isxander.yacl.api.YaclConfig;
import net.minecraft.world.Difficulty;

public class ConfigHandler {
    private static Difficulty hungyDifficulty = Difficulty.NORMAL; // Default value

    public static void initialize() {
        // Load the config options
        YaclConfig config = YaclConfig.builder()
            .category(ConfigCategory.builder()
                .name("Hungy's Difficulty Settings")
                .option(Option.create("defaultDifficulty", Difficulty.NORMAL)
                    .name("Default Difficulty")
                    .tooltip("Set the default difficulty for the mod")
                    .choices(Difficulty.values()) // Allow the user to choose from all difficulties
                    .onChange(ConfigHandler::setDifficulty)
                    .build())
                .build())
            .build();

        config.load(); // Load and apply the config
    }

    public static void setHungyDifficulty(Difficulty difficulty) {
        hungyDifficulty = difficulty;
    }

    public static Difficulty getHungyDifficulty() {
        return hungyDifficulty;
    }
}
