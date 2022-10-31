package net.wdfeer.crazymod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.wdfeer.crazymod.CrazyMod;

public class ModItems {
    public static final Item TITANIUM_INGOT = RegisterItem("titanium_ingot",
            new Item(new FabricItemSettings().group(ItemGroup.MATERIALS).fireproof()));
    static Item RegisterItem(String name, Item item)
    {
        return Registry.register(Registry.ITEM, new Identifier(CrazyMod.MOD_ID, name), item);
    }
    public static void RegisterModItems() {}
}