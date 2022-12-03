package net.wdfeer.crazymod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.wdfeer.crazymod.CrazyMod;
import net.wdfeer.crazymod.TextLine;
import net.wdfeer.crazymod.block.custom.*;
import org.jetbrains.annotations.Nullable;

public class ModBlocks {
    public static final Block TUNGSTEN_ORE_BLOCK = RegisterBlock("tungsten_ore_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(8f, 40f).requiresTool()),
            ItemGroup.BUILDING_BLOCKS);
    public static final Block TITANIUM_ORE_BLOCK = RegisterBlock("titanium_ore_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(7f, 25f).requiresTool()),
            ItemGroup.BUILDING_BLOCKS);
    public static final Block FURNACE_CATALYST = RegisterBlock("furnace_catalyst",
            new FurnaceCatalyst(),
            ItemGroup.DECORATIONS,
            new TextLine[]{new TextLine("+1x speed", Formatting.GRAY)});
    public static final Block DENSE_FURNACE_CATALYST = RegisterBlock("dense_furnace_catalyst",
            new DenseFurnaceCatalyst(),
            ItemGroup.DECORATIONS,
            new TextLine[]{new TextLine("+3x speed", Formatting.GRAY)});
    public static final Block IRON_FURNACE_CATALYST = RegisterBlock("iron_furnace_catalyst",
            new IronFurnaceCatalyst(),
            ItemGroup.DECORATIONS,
            new TextLine[]{new TextLine("+6x speed", Formatting.GRAY)});
    public static final Block DENSE_IRON_FURNACE_CATALYST = RegisterBlock("dense_iron_furnace_catalyst",
            new DenseIronFurnaceCatalyst(),
            ItemGroup.DECORATIONS,
            new TextLine[]{new TextLine("+18x speed", Formatting.GRAY)});
    public static final Block FURNACE_EFFICIENCY_ENHANCER = RegisterBlock("furnace_efficiency_enhancer",
            new FurnaceEfficiencyEnhancer(),
            ItemGroup.DECORATIONS,
            new TextLine[]{new TextLine("+25% fuel time", Formatting.GRAY)});
    public static final Block DENSE_FURNACE_EFFICIENCY_ENHANCER = RegisterBlock("dense_furnace_efficiency_enhancer",
            new DenseFurnaceEfficiencyEnhancer(),
            ItemGroup.DECORATIONS,
            new TextLine[]{new TextLine("+75% fuel time", Formatting.GRAY)});
    public static final Block SAPLING_ACCELERATOR = RegisterBlock("sapling_accelerator",
            new SaplingAccelerator(),
            ItemGroup.DECORATIONS,
            new TextLine[]{new TextLine("Range: 3x3x3", Formatting.GRAY), new TextLine("Speed: +25%", Formatting.GRAY)});
    public static final Block DENSE_SAPLING_ACCELERATOR = RegisterBlock("dense_sapling_accelerator",
            new DenseSaplingAccelerator(),
            ItemGroup.DECORATIONS,
            new TextLine[]{new TextLine("Range: 3x3x3", Formatting.GRAY), new TextLine("Speed: +2x", Formatting.GRAY)});
    public static Block[] getCubeAllModelBlocks(){
        return new Block[] {TUNGSTEN_ORE_BLOCK, TITANIUM_ORE_BLOCK};
    }
    public static Block[] getMineableBlocks(){
        return new Block[] {TITANIUM_ORE_BLOCK, TUNGSTEN_ORE_BLOCK, FURNACE_CATALYST, FURNACE_EFFICIENCY_ENHANCER, DENSE_FURNACE_CATALYST, DENSE_FURNACE_EFFICIENCY_ENHANCER, IRON_FURNACE_CATALYST, DENSE_IRON_FURNACE_CATALYST, SAPLING_ACCELERATOR, DENSE_SAPLING_ACCELERATOR};
    }
    static Block RegisterBlock(String name, Block block, ItemGroup tab)
    {
        RegisterBlockItem(name, block, tab, null);
        return Registry.register(Registry.BLOCK, new Identifier(CrazyMod.MOD_ID, name), block);
    }
    static Block RegisterBlock(String name, Block block, ItemGroup tab, TextLine[] tooltip)
    {
        RegisterBlockItem(name, block, tab, tooltip);
        return Registry.register(Registry.BLOCK, new Identifier(CrazyMod.MOD_ID, name), block);
    }
    static void RegisterBlockItem(String name, Block block, ItemGroup tab, @Nullable TextLine[] tooltip)
    {
        BlockItem item;
        if (tooltip == null)
            item = new BlockItem(block, new FabricItemSettings().group(tab));
        else
            item = new BlockItemWithTooltip(block, new FabricItemSettings().group(tab), tooltip);
        Registry.register(Registry.ITEM, new Identifier(CrazyMod.MOD_ID, name), item);
    }
    public static void Initialize() {}
}