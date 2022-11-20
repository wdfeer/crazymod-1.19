package net.wdfeer.crazymod.block.custom;

import net.minecraft.block.entity.BlockEntityType;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;
import net.wdfeer.crazymod.block.entity.DenseFurnaceEfficiencyEnhancerEntity;

public class DenseFurnaceEfficiencyEnhancer extends FurnaceUpgradeBlock {
    @Override
    public BlockEntityType<DenseFurnaceEfficiencyEnhancerEntity> getBlockEntityType() {
        return ModBlockEntityTypes.DENSE_FURNACE_EFFICIENCER;
    }
}
