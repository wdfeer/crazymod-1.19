package net.wdfeer.crazymod.item.custom;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.wdfeer.crazymod.item.ModItems;

public class TitaniumSword extends SwordItem {
    static final ToolMaterial material = new ToolMaterial() {
        @Override
        public int getDurability() {
            return 4200;
        }
        @Override
        public float getMiningSpeedMultiplier() {
            return 9f;
        }
        @Override
        public float getAttackDamage() {
            return 6;
        }
        @Override
        public int getMiningLevel() {
            return MiningLevels.NETHERITE;
        }
        @Override
        public int getEnchantability() {
            return 16;
        }
        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(ModItems.TITANIUM_INGOT);
        }
    };
    static final FabricItemSettings settings = new FabricItemSettings().group(ItemGroup.COMBAT).fireproof();
    public TitaniumSword() {
        super(material, 3, -2.4f, settings);
    }
}
