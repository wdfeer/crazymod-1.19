package net.wdfeer.crazymod.toolmaterial;

import net.fabricmc.yarn.constants.MiningLevels;

public class TitaniumDrillMaterial extends TitaniumMaterial {
    public static final TitaniumDrillMaterial INSTANCE = new TitaniumDrillMaterial();
    @Override
    public int getDurability() {
        return super.getDurability() / 2;
    }
    @Override
    public float getMiningSpeedMultiplier() {
        return super.getMiningSpeedMultiplier() * 3f;
    }
    @Override
    public int getMiningLevel() {
        return MiningLevels.STONE;
    }
    @Override
    public float getAttackDamage() {
        return 4f;
    }
}
