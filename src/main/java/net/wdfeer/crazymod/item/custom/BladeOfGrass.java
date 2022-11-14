package net.wdfeer.crazymod.item.custom;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class BladeOfGrass extends SwordItem {
    public BladeOfGrass() {
        super(new ToolMaterial() {
            @Override
            public int getDurability() {
                return 220;
            }
            @Override
            public float getMiningSpeedMultiplier() {
                return 0;
            }
            @Override
            public float getAttackDamage() {
                return 0;
            }
            @Override
            public int getMiningLevel() {
                return 0;
            }
            @Override
            public int getEnchantability() {
                return 16;
            }
            @Override
            public Ingredient getRepairIngredient() {
                return null;
            }
        }, 5, -2.4f, new FabricItemSettings().group(ItemGroup.COMBAT));
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        StatusEffectInstance status = new StatusEffectInstance(StatusEffects.POISON, 7 * 20, 1);
        target.addStatusEffect(status, attacker);
        return super.postHit(stack, target, attacker);
    }
}
