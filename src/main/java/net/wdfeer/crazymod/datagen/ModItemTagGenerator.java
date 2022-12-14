package net.wdfeer.crazymod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.wdfeer.crazymod.item.ModItems;

public class ModItemTagGenerator extends FabricTagProvider.ItemTagProvider {
    public ModItemTagGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }
    private static final TagKey<Item> PICKAXES = TagKey.of(Registry.ITEM_KEY, new Identifier("fabric:pickaxes"));
    private static final TagKey<Item> TUNGSTEN_INGOTS = TagKey.of(Registry.ITEM_KEY, new Identifier("c:tungsten_ingots"));
    @Override
    protected void generateTags() {
        var pickaxeBuilder = getOrCreateTagBuilder(PICKAXES);
        for (Item i : ModItems.getPickaxes()) {
            pickaxeBuilder.add(i);
        }
        getOrCreateTagBuilder(TUNGSTEN_INGOTS).add(ModItems.TUNGSTEN_INGOT);
    }
}