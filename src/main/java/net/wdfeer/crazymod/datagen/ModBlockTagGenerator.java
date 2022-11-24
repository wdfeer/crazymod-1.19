package net.wdfeer.crazymod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.wdfeer.crazymod.block.ModBlocks;

public class ModBlockTagGenerator extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }
    private static final TagKey<Block> PICKAXE_MINEABLE = TagKey.of(Registry.BLOCK_KEY, new Identifier("minecraft:mineable/pickaxe"));
    private static final TagKey<Block> NEEDS_IRON_TOOL = TagKey.of(Registry.BLOCK_KEY, new Identifier("minecraft:needs_iron_tool"));
    private static final TagKey<Block> NEEDS_DIAMOND_TOOL = TagKey.of(Registry.BLOCK_KEY, new Identifier("minecraft:needs_diamond_tool"));
    private void addAll(Block[] entries, FabricTagBuilder<Block> tagBuilder){
        for (Block b: entries) {
            tagBuilder.add(b);
        }
    }
    @Override
    protected void generateTags() {
        addAll(ModBlocks.getMineableBlocks(), getOrCreateTagBuilder(PICKAXE_MINEABLE));
        getOrCreateTagBuilder(NEEDS_DIAMOND_TOOL).add(ModBlocks.TITANIUM_ORE_BLOCK);
        getOrCreateTagBuilder(NEEDS_IRON_TOOL).add(ModBlocks.TUNGSTEN_ORE_BLOCK);
    }
}