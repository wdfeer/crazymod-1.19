package net.wdfeer.crazymod.item.custom;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.world.World;
import net.wdfeer.crazymod.toolmaterial.TungstenMaterial;

public class TungstenShortsword extends SwordItem {
    public TungstenShortsword() {
        super(TungstenMaterial.INSTANCE, 5, -2f, new FabricItemSettings().group(ItemGroup.COMBAT));
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        if (!world.isClient){
            stack.addEnchantment(Enchantments.LOOTING, 1);
            if (world.random.nextFloat() < 0.25f)
                stack.addEnchantment(Enchantments.SHARPNESS, 1);
        }
    }
}
