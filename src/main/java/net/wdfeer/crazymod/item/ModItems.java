package net.wdfeer.crazymod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.wdfeer.crazymod.CrazyMod;
import net.wdfeer.crazymod.item.custom.*;
import net.wdfeer.crazymod.toolmaterial.BoneMaterial;
import net.wdfeer.crazymod.toolmaterial.HallowedMaterial;
import net.wdfeer.crazymod.toolmaterial.TitaniumMaterial;

public class ModItems {

    public static final Item TITANIUM_ORE = RegisterItem("titanium_ore",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).fireproof()));
    public static final Item TITANIUM_CLUSTER = RegisterItem("titanium_cluster",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).fireproof()));
    public static final Item TITANIUM_INGOT = RegisterItem("titanium_ingot",
            new Item(new FabricItemSettings().group(ItemGroup.MATERIALS).fireproof()));
    public static final Item TITANIUM_SWORD = RegisterItem("titanium_sword",
            new SwordItem(TitaniumMaterial.INSTANCE, 8, -2.4f, new FabricItemSettings().group(ItemGroup.COMBAT).fireproof()));
    public static final Item TITANIUM_PICKAXE = RegisterItem("titanium_pickaxe",
            new PickaxeItem(TitaniumMaterial.INSTANCE, 5, -2.5f, new FabricItemSettings().group(ItemGroup.TOOLS).fireproof()));
    public static final Item TITANIUM_DRILL = RegisterItem("titanium_drill",
            new TitaniumDrill());
    public static final Item TITANIUM_REPEATER = RegisterItem("titanium_repeater",
            new TitaniumRepeater());
    public static final Item COPPER_BOW = RegisterItem("copper_bow",
            new CopperBow());
    public static final Item EXCALIBUR = RegisterItem("excalibur",
            new SwordItem(HallowedMaterial.INSTANCE, 10, -2.5f, new FabricItemSettings().group(ItemGroup.COMBAT).fireproof()));
    public static final Item BONE_SWORD = RegisterItem("bone_sword",
            new SwordItem(BoneMaterial.INSTANCE, 5, -2.25f, new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item WAND_OF_SPARKING = RegisterItem("wand_of_sparking",
            new WandOfSparking());
    public static final Item BLADE_OF_GRASS = RegisterItem("blade_of_grass",
            new BladeOfGrass());
    public static final Item AMETHYST_STAFF = RegisterItem("amethyst_staff",
            new AmethystStaff());
    static Item RegisterItem(String name, Item item)
    {
        return Registry.register(Registry.ITEM, new Identifier(CrazyMod.MOD_ID, name), item);
    }
    public static void Initialize() {}
}