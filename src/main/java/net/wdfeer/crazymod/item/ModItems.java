package net.wdfeer.crazymod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.wdfeer.crazymod.CrazyMod;
import net.wdfeer.crazymod.item.custom.CopperBow;
import net.wdfeer.crazymod.item.custom.TitaniumDrill;
import net.wdfeer.crazymod.item.custom.TitaniumRepeater;
import net.wdfeer.crazymod.toolmaterial.TitaniumDrillMaterial;
import net.wdfeer.crazymod.toolmaterial.TitaniumMaterial;

public class ModItems {

    public static final Item TITANIUM_ORE = RegisterItem("titanium_ore",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).fireproof()));
    public static final Item TITANIUM_CLUSTER = RegisterItem("titanium_cluster",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).fireproof()));
    public static final Item TITANIUM_INGOT = RegisterItem("titanium_ingot",
            new Item(new FabricItemSettings().group(ItemGroup.MATERIALS).fireproof()));
    public static final Item TITANIUM_SWORD = RegisterItem("titanium_sword",
            new SwordItem(TitaniumMaterial.INSTANCE, 9, -2.4f, new FabricItemSettings().group(ItemGroup.COMBAT).fireproof()));
    public static final Item TITANIUM_PICKAXE = RegisterItem("titanium_pickaxe",
            new PickaxeItem(TitaniumMaterial.INSTANCE, 5, -2.5f, new FabricItemSettings().group(ItemGroup.TOOLS).fireproof()));
    public static final Item TITANIUM_DRILL = RegisterItem("titanium_drill",
            new TitaniumDrill());
    public static final Item TITANIUM_REPEATER = RegisterItem("titanium_repeater",
            new TitaniumRepeater());
    public static final Item COPPER_BOW = RegisterItem("copper_bow",
            new CopperBow());
    static Item RegisterItem(String name, Item item)
    {
        return Registry.register(Registry.ITEM, new Identifier(CrazyMod.MOD_ID, name), item);
    }
    public static void Initialize() {}
}