package net.wdfeer.crazymod.block.custom;

import net.minecraft.block.entity.BlockEntityType;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;
import net.wdfeer.crazymod.block.entity.FurnaceEfficiencyEnhancerEntity;

public class FurnaceEfficiencyEnhancer extends FurnaceUpgradeBlock {
    @Override
    public BlockEntityType<FurnaceEfficiencyEnhancerEntity> getBlockEntityType() {
        return ModBlockEntityTypes.FURNACE_EFFICIENCER;
    }
}
