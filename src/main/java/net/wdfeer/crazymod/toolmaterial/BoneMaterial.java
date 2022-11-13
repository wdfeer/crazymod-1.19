package net.wdfeer.crazymod.toolmaterial;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class BoneMaterial implements ToolMaterial {
    public static final BoneMaterial INSTANCE = new BoneMaterial();
    @Override
    public int getDurability() {
        return 240;
    }
    @Override
    public float getMiningSpeedMultiplier() {
        return 4.5f;
    }
    @Override
    public float getAttackDamage() {
        return 0;
    }

    @Override
    public int getMiningLevel() {
        return MiningLevels.IRON;
    }

    @Override
    public int getEnchantability() {
        return 19;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.BONE);
    }
}
