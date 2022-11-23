package net.wdfeer.crazymod.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.wdfeer.crazymod.CrazyMod;
import net.wdfeer.crazymod.block.ModBlocks;

import java.util.Arrays;

public class ModOres {
    private static final ConfiguredFeature<?, ?> NETHER_TITANIUM_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>
            (Feature.ORE, new OreFeatureConfig(
                    OreConfiguredFeatures.NETHERRACK,
                    ModBlocks.TITANIUM_ORE_BLOCK.getDefaultState(),
                    4));

    public static PlacedFeature NETHER_TITANIUM_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(NETHER_TITANIUM_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(9),
                    SquarePlacementModifier.of(),
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(32))));
    private static final ConfiguredFeature<?, ?> TUNGSTEN_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>
            (Feature.ORE, new OreFeatureConfig(
                    OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.TUNGSTEN_ORE_BLOCK.getDefaultState(),
                    3));

    public static PlacedFeature TUNGSTEN_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(TUNGSTEN_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(100),
                    SquarePlacementModifier.of(),
                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(120), YOffset.getTop())));
    private static void RegisterConfiguredFeature(String name, ConfiguredFeature<?, ?> feature){
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(CrazyMod.MOD_ID, name), feature);
    }
    private static void RegisterPlacedFeature(String name, PlacedFeature feature){
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(CrazyMod.MOD_ID, name), feature);
    }
    public static void Initialize() {
        RegisterConfiguredFeature("titanium_ore_block", NETHER_TITANIUM_ORE_CONFIGURED_FEATURE);
        RegisterPlacedFeature("titanium_ore_block", NETHER_TITANIUM_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier(CrazyMod.MOD_ID, "titanium_ore_block")));
        RegisterConfiguredFeature("tungsten_ore_block", TUNGSTEN_ORE_CONFIGURED_FEATURE);
        RegisterPlacedFeature("tungsten_ore_block", TUNGSTEN_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier(CrazyMod.MOD_ID, "tungsten_ore_block")));
    }
}
