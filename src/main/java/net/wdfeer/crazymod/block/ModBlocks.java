package net.wdfeer.crazymod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.wdfeer.crazymod.CrazyMod;
import net.wdfeer.crazymod.util.TextLine;
import net.wdfeer.crazymod.block.custom.*;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class ModBlocks {
    public static ArrayList<BlockWithData> allBlocks = new ArrayList<>();
    public static final Block TUNGSTEN_ORE_BLOCK = RegisterBlock("tungsten_ore_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(8f, 40f).requiresTool()),
            new BlockData(BlockModelType.CubeAll, MiningLevels.IRON, false),
            ItemGroup.BUILDING_BLOCKS);
    public static final Block TITANIUM_ORE_BLOCK = RegisterBlock("titanium_ore_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(7f, 25f).requiresTool()),
            new BlockData(BlockModelType.CubeAll, MiningLevels.DIAMOND, false),
            ItemGroup.BUILDING_BLOCKS);
    public static final Block FURNACE_CATALYST = RegisterBlock("furnace_catalyst",
            new FurnaceCatalyst(),
            new BlockData(BlockModelType.CubeTopSameBottom),
            ItemGroup.DECORATIONS,
            new TextLine[]{new TextLine("+1x speed", Formatting.GRAY)});
    public static final Block DENSE_FURNACE_CATALYST = RegisterBlock("dense_furnace_catalyst",
            new DenseFurnaceCatalyst(),
            new BlockData(BlockModelType.CubeTopSameBottom),
            ItemGroup.DECORATIONS,
            new TextLine[]{new TextLine("+3x speed", Formatting.GRAY)});
    public static final Block IRON_FURNACE_CATALYST = RegisterBlock("iron_furnace_catalyst",
            new IronFurnaceCatalyst(),
            new BlockData(BlockModelType.CubeTopSameBottom),
            ItemGroup.DECORATIONS,
            new TextLine[]{new TextLine("+6x speed", Formatting.GRAY)});
    public static final Block DENSE_IRON_FURNACE_CATALYST = RegisterBlock("dense_iron_furnace_catalyst",
            new DenseIronFurnaceCatalyst(),
            new BlockData(BlockModelType.CubeTopSameBottom),
            ItemGroup.DECORATIONS,
            new TextLine[]{new TextLine("+18x speed", Formatting.GRAY)});
    public static final Block FURNACE_EFFICIENCY_ENHANCER = RegisterBlock("furnace_efficiency_enhancer",
            new FurnaceEfficiencyEnhancer(),
            new BlockData(BlockModelType.CubeTopSameBottom),
            ItemGroup.DECORATIONS,
            new TextLine[]{new TextLine("+25% fuel time", Formatting.GRAY)});
    public static final Block DENSE_FURNACE_EFFICIENCY_ENHANCER = RegisterBlock("dense_furnace_efficiency_enhancer",
            new DenseFurnaceEfficiencyEnhancer(),
            new BlockData(BlockModelType.CubeTopSameBottom),
            ItemGroup.DECORATIONS,
            new TextLine[]{new TextLine("+75% fuel time", Formatting.GRAY)});
    public static final Block SAPLING_ACCELERATOR = RegisterBlock("sapling_accelerator",
            new SaplingAccelerator(),
            new BlockData(BlockModelType.CubeTopSameBottom),
            ItemGroup.DECORATIONS,
            new TextLine[]{new TextLine("Range: 3x3x3", Formatting.GRAY), new TextLine("Speed: +25%", Formatting.GRAY)});
    public static final Block DENSE_SAPLING_ACCELERATOR = RegisterBlock("dense_sapling_accelerator",
            new DenseSaplingAccelerator(),
            new BlockData(BlockModelType.CubeTopSameBottom),
            ItemGroup.DECORATIONS,
            new TextLine[]{new TextLine("Range: 3x3x3", Formatting.GRAY), new TextLine("Speed: +2x", Formatting.GRAY)});
    public static final Block HOPPER_ACCELERATOR = RegisterBlock("hopper_accelerator",
            new HopperAccelerator(),
            new BlockData(BlockModelType.CubeTopSameBottom),
            ItemGroup.DECORATIONS,
            new TextLine[]{new TextLine("Range: 3x3x3", Formatting.GRAY), new TextLine("Speed: +1x", Formatting.GRAY)});
    public static final Block DENSE_HOPPER_ACCELERATOR = RegisterBlock("dense_hopper_accelerator",
            new DenseHopperAccelerator(),
            new BlockData(BlockModelType.CubeTopSameBottom),
            ItemGroup.DECORATIONS,
            new TextLine[]{new TextLine("Range: 3x3x3", Formatting.GRAY), new TextLine("Speed: +8x", Formatting.GRAY)});
    public static final Block EXTRA_DENSE_HOPPER_ACCELERATOR = RegisterBlock("extra_dense_hopper_accelerator",
            new ExtraDenseHopperAccelerator(),
            new BlockData(BlockModelType.CubeTopSameBottom),
            ItemGroup.DECORATIONS,
            new TextLine[]{new TextLine("Range: 3x3x3", Formatting.GRAY), new TextLine("Speed: +64x", Formatting.GRAY)});
    public static final Block ULTRA_DENSE_HOPPER_ACCELERATOR = RegisterBlock("ultra_dense_hopper_accelerator",
            new UltraDenseHopperAccelerator(),
            new BlockData(BlockModelType.CubeTopSameBottom),
            ItemGroup.DECORATIONS,
            new TextLine[]{new TextLine("Range: 3x3x3", Formatting.GRAY), new TextLine("Speed: +512x", Formatting.GRAY)});
    public static final Block SPAWNER_ACCELERATOR = RegisterBlock("spawner_accelerator",
            new SpawnerAccelerator(),
            new BlockData(BlockModelType.CubeTopSameBottom),
            ItemGroup.DECORATIONS,
            new TextLine[]{new TextLine("Range: 3x3x3", Formatting.GRAY), new TextLine("Speed: +25%", Formatting.GRAY)});
    public static final Block DENSE_SPAWNER_ACCELERATOR = RegisterBlock("dense_spawner_accelerator",
            new DenseSpawnerAccelerator(),
            new BlockData(BlockModelType.CubeTopSameBottom),
            ItemGroup.DECORATIONS,
            new TextLine[]{new TextLine("Range: 3x3x3", Formatting.GRAY), new TextLine("Speed: +2x", Formatting.GRAY)});
    public static Block RegisterBlock(String name, Block block, BlockData data, ItemGroup tab)
    {
        return RegisterBlock(name, block, data, tab, null);
    }
    public static Block RegisterBlock(String name, Block block, BlockData data, ItemGroup tab, TextLine[] tooltip)
    {
        BlockItem item = RegisterBlockItem(name, block, tab, tooltip);
        allBlocks.add(new BlockWithData(block, data, item));
        return Registry.register(Registry.BLOCK, new Identifier(CrazyMod.MOD_ID, name), block);
    }
    static BlockItem RegisterBlockItem(String name, Block block, ItemGroup tab, @Nullable TextLine[] tooltip)
    {
        BlockItem item;
        if (tooltip == null)
            item = new BlockItem(block, new FabricItemSettings().group(tab));
        else
            item = new BlockItemWithTooltip(block, new FabricItemSettings().group(tab), tooltip);
        Registry.register(Registry.ITEM, new Identifier(CrazyMod.MOD_ID, name), item);
        return item;
    }

    public static void Initialize() {
        ComputerAccelerator.Initialize();
    }
}