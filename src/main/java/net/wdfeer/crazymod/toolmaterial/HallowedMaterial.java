package net.wdfeer.crazymod.toolmaterial;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.wdfeer.crazymod.item.ModItems;

public class HallowedMaterial implements ToolMaterial {
    public static final HallowedMaterial INSTANCE = new HallowedMaterial();

    @Override
    public int getDurability() {
        return 4000;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 8.5f;
    }

    @Override
    public float getAttackDamage() {
        return 0;
    }

    @Override
    public int getMiningLevel() {
        return MiningLevels.NETHERITE;
    }

    @Override
    public int getEnchantability() {
        return 25;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }
}
