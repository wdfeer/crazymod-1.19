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
import net.wdfeer.crazymod.toolmaterial.CopperMaterial;
import net.wdfeer.crazymod.toolmaterial.HallowedMaterial;
import net.wdfeer.crazymod.toolmaterial.TitaniumMaterial;

public class ModItems {
    public static final Item COPPER_HAMMER = RegisterItem("copper_hammer",
            new HammerItem(9, CopperMaterial.INSTANCE));
    public static final Item TUNGSTEN_ORE = RegisterItem("tungsten_ore",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item TUNGSTEN_CLUSTER = RegisterItem("tungsten_cluster",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item TUNGSTEN_INGOT = RegisterItem("tungsten_ingot",
            new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item TUNGSTEN_PICKAXE = RegisterItem("tungsten_pickaxe",
            new TungstenPickaxe());
    public static final Item TUNGSTEN_HAMMER = RegisterItem("tungsten_hammer",
            new TungstenHammer());
    public static final Item TUNGSTEN_SHORTSWORD = RegisterItem("tungsten_shortsword",
            new TungstenShortsword());
    public static final Item TITANIUM_ORE = RegisterItem("titanium_ore",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).fireproof()));
    public static final Item TITANIUM_CLUSTER = RegisterItem("titanium_cluster",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).fireproof()));
    public static final Item TITANIUM_INGOT = RegisterItem("titanium_ingot",
            new Item(new FabricItemSettings().group(ItemGroup.MATERIALS).fireproof()));
    public static final Item TITANIUM_PICKAXE = RegisterItem("titanium_pickaxe",
            new PickaxeItem(TitaniumMaterial.INSTANCE, 6, -2.4f, new FabricItemSettings().group(ItemGroup.TOOLS).fireproof()));
    public static final Item TITANIUM_DRILL = RegisterItem("titanium_drill",
            new TitaniumDrill());

    public static final Item TITANIUM_SWORD = RegisterItem("titanium_sword",
            new SwordItem(TitaniumMaterial.INSTANCE, 8, -2.5f, new FabricItemSettings().group(ItemGroup.COMBAT).fireproof()));
    public static final Item TITANIUM_REPEATER = RegisterItem("titanium_repeater",
            new TitaniumRepeater());
    public static final Item EXCALIBUR = RegisterItem("excalibur",
            new SwordItem(HallowedMaterial.INSTANCE, 9, -2.5f, new FabricItemSettings().group(ItemGroup.COMBAT).fireproof()));
    public static final Item BONE_SWORD = RegisterItem("bone_sword",
            new SwordItem(BoneMaterial.INSTANCE, 5, -2.2f, new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item BLADE_OF_GRASS = RegisterItem("blade_of_grass",
            new BladeOfGrass());

    public static final Item COPPER_BOW = RegisterItem("copper_bow",
            new CopperBow());

    public static final Item WAND_OF_SPARKING = RegisterItem("wand_of_sparking",
            new WandOfSparking());
    public static final Item AMETHYST_STAFF = RegisterItem("amethyst_staff",
            new AmethystStaff());
    public static final Item EMERALD_STAFF = RegisterItem("emerald_staff",
            new EmeraldStaff());
    public static Item[] getPickaxes(){
        return new Item[] {TUNGSTEN_PICKAXE, TITANIUM_PICKAXE, COPPER_HAMMER, TUNGSTEN_HAMMER, TITANIUM_DRILL};
    }
    public static Item[] getGeneratedModelItems(){
        return new Item[] {TUNGSTEN_ORE, TUNGSTEN_CLUSTER, TUNGSTEN_INGOT, TITANIUM_ORE, TITANIUM_CLUSTER, TITANIUM_INGOT};
    }
    public static Item[] getHandheldItems(){
        return new Item[] {COPPER_HAMMER, TUNGSTEN_PICKAXE, TUNGSTEN_SHORTSWORD, TUNGSTEN_HAMMER, TITANIUM_PICKAXE, TITANIUM_DRILL, TITANIUM_SWORD, TITANIUM_REPEATER, EXCALIBUR, BONE_SWORD, BLADE_OF_GRASS, WAND_OF_SPARKING, AMETHYST_STAFF, EMERALD_STAFF};
    }
    static Item RegisterItem(String name, Item item)
    {
        return Registry.register(Registry.ITEM, new Identifier(CrazyMod.MOD_ID, name), item);
    }
    public static void Initialize() {}
}