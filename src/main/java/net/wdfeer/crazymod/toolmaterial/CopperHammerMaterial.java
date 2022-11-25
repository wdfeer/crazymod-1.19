package net.wdfeer.crazymod.toolmaterial;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class CopperHammerMaterial implements ToolMaterial {
    public static final CopperHammerMaterial INSTANCE = new CopperHammerMaterial();
    @Override
    public int getDurability() {
        return 480;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 4f;
    }

    @Override
    public float getAttackDamage() {
        return 0;
    }

    @Override
    public int getMiningLevel() {
        return MiningLevels.STONE;
    }

    @Override
    public int getEnchantability() {
        return 10;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.COPPER_INGOT);
    }
}
