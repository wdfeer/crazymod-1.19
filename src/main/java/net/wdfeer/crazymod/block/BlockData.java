package net.wdfeer.crazymod.block;

import net.fabricmc.yarn.constants.MiningLevels;

public class BlockData {
    public final BlockModelType modelType;
    public boolean pickaxeMineable = true;
    public int miningLevelRequired = MiningLevels.HAND;
    public boolean dropsSelf = true;

    public BlockData(BlockModelType modelType) {
        this.modelType = modelType;
    }
    public BlockData(BlockModelType modelType, int miningLevel, boolean dropsSelf) {
        this.modelType = modelType;
        this.miningLevelRequired = miningLevel;
        this.dropsSelf = dropsSelf;
    }
}
