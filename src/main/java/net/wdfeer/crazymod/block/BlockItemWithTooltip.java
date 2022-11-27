package net.wdfeer.crazymod.block;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.wdfeer.crazymod.TextLine;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BlockItemWithTooltip extends BlockItem {
    public TextLine[] lines;
    public BlockItemWithTooltip(Block block, Settings settings, TextLine[] tooltip) {
        super(block, settings);
        lines = tooltip;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        TextLine.addLines(tooltip, lines);
    }
}
