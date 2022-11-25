package net.wdfeer.crazymod.item.custom;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public abstract class HammerItem extends MiningToolItem {
    public HammerItem(float attackDamage, float attackSpeed, ToolMaterial material) {
        super(attackDamage, attackSpeed, material, TagKey.of(Registry.BLOCK_KEY, new Identifier("minecraft:mineable/pickaxe")), new FabricItemSettings().group(ItemGroup.TOOLS));
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return this.miningSpeed;
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        return true;
    }
}
