package net.wdfeer.crazymod.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TitaniumDrill extends ToolItem {
    public TitaniumDrill(ToolMaterial material, Settings settings) {
        super(material, settings);
    }
    public static void addTooltipLine(List<Text> tooltip, String str, Formatting formatting){
        Text t = Text.of(str);
        t = t.getWithStyle(t.getStyle().withColor(formatting)).get(0);
        tooltip.add(t);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        addTooltipLine(tooltip,"Can only mine on the level of the stone pickaxe", Formatting.GRAY);
        addTooltipLine(tooltip,"Right click to switch to 3x3x3 mode", Formatting.GRAY);
    }
    @Override
    public boolean isSuitableFor(BlockState state) {
        return state.streamTags().anyMatch(tag -> tag == BlockTags.PICKAXE_MINEABLE || tag == BlockTags.SHOVEL_MINEABLE);
    }
    private boolean isCompatibleMiningLevel(BlockState state){
        return state.streamTags().noneMatch(tag -> tag == BlockTags.NEEDS_IRON_TOOL || tag == BlockTags.NEEDS_DIAMOND_TOOL);
    }
    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return isCompatibleMiningLevel(state);
    }
    boolean excavation = false;
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient() && hand == Hand.MAIN_HAND){
            excavation = !excavation;
            user.sendMessage(Text.of("Excavation mode is " + (excavation ? "on" : "off")));
            return TypedActionResult.success(user.getStackInHand(hand));
        }
        return super.use(world, user, hand);
    }
    void damage(ItemStack stack, LivingEntity user){
        stack.damage(1, user, e -> e.sendToolBreakStatus(user.preferredHand));
    }
    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!(miner instanceof PlayerEntity))
            return false;
        float hard = state.getHardness(world.getChunk(pos), pos);
        if (excavation) {
            for (int x = -1; x < 2; x++) {
                for (int y = -1; y < 2; y++) {
                    for (int z = -1; z < 2; z++) {
                        var newPos = pos.add(x, y, z);
                        var newState = world.getBlockState(newPos);
                        if (newState.isAir())
                            continue;
                        float newHard = newState.getHardness(world.getChunk(newPos), newPos);
                        if (isCompatibleMiningLevel(newState) && isSuitableFor(newState) && newHard < hard * 3f) {
                            world.breakBlock(newPos, true);
                            if (newHard > 0f)
                                damage(stack, miner);
                        }
                    }
                }
            }
        }
        damage(stack, miner);
        return hard > 0f;
    }
    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return this.getMaterial().getMiningSpeedMultiplier() * (excavation ? 0.15f : 1f) * (isSuitableFor(state) ? 1f : 0.12f);
    }
}
