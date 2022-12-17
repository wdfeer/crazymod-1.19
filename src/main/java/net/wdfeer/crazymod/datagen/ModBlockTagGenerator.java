package net.wdfeer.crazymod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.wdfeer.crazymod.block.BlockWithData;
import net.wdfeer.crazymod.block.ModBlocks;

public class ModBlockTagGenerator extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }
    private static final TagKey<Block> PICKAXE_MINEABLE = TagKey.of(Registry.BLOCK_KEY, new Identifier("minecraft:mineable/pickaxe"));
    private static final TagKey<Block> NEEDS_IRON_TOOL = TagKey.of(Registry.BLOCK_KEY, new Identifier("minecraft:needs_iron_tool"));
    private static final TagKey<Block> NEEDS_DIAMOND_TOOL = TagKey.of(Registry.BLOCK_KEY, new Identifier("minecraft:needs_diamond_tool"));
    @Override
    protected void generateTags() {
        var pickaxeMineable = getOrCreateTagBuilder(PICKAXE_MINEABLE);
        var needsDiamond = getOrCreateTagBuilder(NEEDS_DIAMOND_TOOL);
        var needsIron = getOrCreateTagBuilder(NEEDS_IRON_TOOL);
        for (BlockWithData item: ModBlocks.allBlocks) {
            var data = item.data();
            if (data.pickaxeMineable)
                pickaxeMineable.add(item.block());
            switch (data.miningLevelRequired){
                case MiningLevels.IRON -> needsIron.add(item.block());
                case MiningLevels.DIAMOND -> needsDiamond.add(item.block());
            }
        }
    }
}