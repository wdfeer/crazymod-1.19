package net.wdfeer.crazymod.item.custom;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.world.World;
import net.wdfeer.crazymod.toolmaterial.TungstenMaterial;

public class TungstenPickaxe extends PickaxeItem {
    public TungstenPickaxe() {
        super(TungstenMaterial.INSTANCE, 5, -2.2f, new FabricItemSettings().group(ItemGroup.TOOLS));
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
