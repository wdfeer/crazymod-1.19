package net.wdfeer.crazymod.toolmaterial;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.wdfeer.crazymod.item.ModItems;

public class TitaniumMaterial implements ToolMaterial {
    public static final TitaniumMaterial INSTANCE = new TitaniumMaterial();

    @Override
    public int getDurability() {
        return 4200;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 8.25f;
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
        return 12;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.TITANIUM_INGOT);
    }
}
