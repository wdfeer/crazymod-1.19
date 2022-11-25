package net.wdfeer.crazymod.toolmaterial;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.wdfeer.crazymod.item.ModItems;

public class TungstenMaterial implements ToolMaterial {
    public static final TungstenMaterial INSTANCE = new TungstenMaterial();

    @Override
    public int getDurability() {
        return 3600;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 7.5f;
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
        return 9;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.TUNGSTEN_INGOT);
    }
}
