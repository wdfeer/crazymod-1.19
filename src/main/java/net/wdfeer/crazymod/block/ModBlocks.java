package net.wdfeer.crazymod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.wdfeer.crazymod.CrazyMod;
import net.wdfeer.crazymod.block.custom.DenseFurnaceCatalyst;
import net.wdfeer.crazymod.block.custom.DenseFurnaceEfficiencyEnhancer;
import net.wdfeer.crazymod.block.custom.FurnaceCatalyst;
import net.wdfeer.crazymod.block.custom.FurnaceEfficiencyEnhancer;

public class ModBlocks {
    public static final Block TITANIUM_ORE_BLOCK = RegisterBlock("titanium_ore_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(7f, 25f).requiresTool()),
            ItemGroup.BUILDING_BLOCKS);
    public static final Block TUNGSTEN_ORE_BLOCK = RegisterBlock("tungsten_ore_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(8f, 40f).requiresTool()),
            ItemGroup.BUILDING_BLOCKS);
    public static final Block FURNACE_CATALYST = RegisterBlock("furnace_catalyst",
            new FurnaceCatalyst(),
            ItemGroup.DECORATIONS);
    public static final Block DENSE_FURNACE_CATALYST = RegisterBlock("dense_furnace_catalyst",
            new DenseFurnaceCatalyst(),
            ItemGroup.DECORATIONS);
    public static final Block FURNACE_EFFICIENCY_ENHANCER = RegisterBlock("furnace_efficiency_enhancer",
            new FurnaceEfficiencyEnhancer(),
            ItemGroup.DECORATIONS);
    public static final Block DENSE_FURNACE_EFFICIENCY_ENHANCER = RegisterBlock("dense_furnace_efficiency_enhancer",
            new DenseFurnaceEfficiencyEnhancer(),
            ItemGroup.DECORATIONS);
    public static Block[] getMineableBlocks(){
        return new Block[] {TITANIUM_ORE_BLOCK, TUNGSTEN_ORE_BLOCK, FURNACE_CATALYST, FURNACE_EFFICIENCY_ENHANCER, DENSE_FURNACE_CATALYST, DENSE_FURNACE_EFFICIENCY_ENHANCER};
    }
    static Block RegisterBlock(String name, Block block, ItemGroup tab)
    {
        RegisterBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(CrazyMod.MOD_ID, name), block);
    }
    static void RegisterBlockItem(String name, Block block, ItemGroup tab)
    {
        Registry.register(Registry.ITEM, new Identifier(CrazyMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }
    public static void Initialize() {}
}