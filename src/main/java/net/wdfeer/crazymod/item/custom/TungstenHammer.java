package net.wdfeer.crazymod.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.wdfeer.crazymod.toolmaterial.TungstenMaterial;

public class TungstenHammer extends HammerItem {
    public TungstenHammer() {
        super(13, TungstenMaterial.INSTANCE);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return super.getMiningSpeedMultiplier(stack, state) * 0.75f;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        stack.addEnchantment(Enchantments.SILK_TOUCH, 1);
    }
}
