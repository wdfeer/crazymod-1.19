package net.wdfeer.crazymod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.wdfeer.crazymod.block.BlockWithData;
import net.wdfeer.crazymod.block.ModBlocks;
import net.wdfeer.crazymod.item.ModItems;

public class ModModelGenerator extends FabricModelProvider {
    public ModModelGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }
    public static final TexturedModel.Factory CUBE_TOP_SAME_BOTTOM = TexturedModel.makeFactory(
            block -> new TextureMap()
                    .put(TextureKey.SIDE, TextureMap.getSubId(block, "_side"))
                    .put(TextureKey.TOP, TextureMap.getSubId(block, "_top"))
                    .put(TextureKey.BOTTOM, TextureMap.getSubId(block, "_top")),
            Models.CUBE_BOTTOM_TOP
    );
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        for (BlockWithData item: ModBlocks.allBlocks) {
            switch (item.data().modelType){
                case CubeAll -> blockStateModelGenerator.registerSimpleCubeAll(item.block());
                case CubeTopSameBottom -> blockStateModelGenerator.registerSingleton(item.block(), CUBE_TOP_SAME_BOTTOM);
            }
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
