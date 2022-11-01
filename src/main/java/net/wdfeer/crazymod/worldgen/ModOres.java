package net.wdfeer.crazymod.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
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
import net.wdfeer.crazymod.block.ModBlocks;

import java.util.Arrays;

public class ModOres {
    private static final ConfiguredFeature<?, ?> NETHER_TITANIUM_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
            (Feature.ORE, new OreFeatureConfig(
                    OreConfiguredFeatures.NETHERRACK,
                    ModBlocks.TITANIUM_OREBLOCK.getDefaultState(),
                    8));

    public static PlacedFeature NETHER_TITANIUM_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(NETHER_TITANIUM_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(12),
                    SquarePlacementModifier.of(),
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(32))));
    public static void Initialize() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier("crazymod", "titanium_oreblock"), NETHER_TITANIUM_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("crazymod", "titanium_oreblock"),
                NETHER_TITANIUM_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier("crazymod", "titanium_oreblock")));
    }
}
