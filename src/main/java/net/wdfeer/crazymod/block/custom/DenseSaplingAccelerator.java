package net.wdfeer.crazymod.block.custom;

import net.minecraft.block.entity.BlockEntityType;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;
import net.wdfeer.crazymod.block.entity.SaplingAcceleratorEntity;

public class DenseSaplingAccelerator extends SaplingAccelerator {
    @Override
    public BlockEntityType<? extends SaplingAcceleratorEntity> getBlockEntityType() {
        return ModBlockEntityTypes.DENSE_SAPLING_ACCELERATOR;
    }
}
