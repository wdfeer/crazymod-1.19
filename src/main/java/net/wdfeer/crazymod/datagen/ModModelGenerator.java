package net.wdfeer.crazymod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;
import net.wdfeer.crazymod.block.ModBlocks;
import net.wdfeer.crazymod.item.ModItems;

public class ModModelGenerator extends FabricModelProvider {
    public ModModelGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        for (Block b: ModBlocks.getCubeAllModelBlocks()) {
            blockStateModelGenerator.registerSimpleCubeAll(b);
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        for (Item i: ModItems.getGeneratedModelItems()) {
            itemModelGenerator.register(i, Models.GENERATED);
        }
        for (Item i: ModItems.getHandheldItems()) {
            itemModelGenerator.register(i, Models.HANDHELD);
        }
    }
}
