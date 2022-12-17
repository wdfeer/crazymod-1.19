package net.wdfeer.crazymod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.data.server.BlockLootTableGenerator;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.util.Identifier;
import net.wdfeer.crazymod.block.BlockWithData;
import net.wdfeer.crazymod.block.ModBlocks;

import java.util.function.BiConsumer;

public class ModBlockLootTableGenerator extends SimpleFabricLootTableProvider {
    public ModBlockLootTableGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator, LootContextTypes.BLOCK);
    }
    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> biConsumer) {
        for (BlockWithData values: ModBlocks.allBlocks) {
            if (values.data().dropsSelf){
                biConsumer.accept(values.block().getLootTableId(), BlockLootTableGenerator.drops(values.item()));
            }
        }
    }
}
