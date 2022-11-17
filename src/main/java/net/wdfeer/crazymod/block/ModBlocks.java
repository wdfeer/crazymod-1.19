package net.wdfeer.crazymod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.wdfeer.crazymod.CrazyMod;
import net.wdfeer.crazymod.block.custom.FurnaceCatalyst;

public class ModBlocks {
    public static final Block TITANIUM_OREBLOCK = RegisterBlock("titanium_oreblock",
            new Block(FabricBlockSettings.of(Material.STONE).strength(10f, 75f).requiresTool()),
            ItemGroup.BUILDING_BLOCKS);
    public static final Block FURNACE_CATALYST = RegisterBlock("furnace_catalyst",
            new FurnaceCatalyst(),
            ItemGroup.BUILDING_BLOCKS);
    static Block RegisterBlock(String name, Block block, ItemGroup tab)
    {
        RegisterBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(CrazyMod.MOD_ID, name), block);
    }
    static Item RegisterBlockItem(String name, Block block, ItemGroup tab)
    {
        return Registry.register(Registry.ITEM, new Identifier(CrazyMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }
    public static void Initialize() {}
}