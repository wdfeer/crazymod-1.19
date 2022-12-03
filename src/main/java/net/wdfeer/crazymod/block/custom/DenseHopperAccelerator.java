package net.wdfeer.crazymod.block.custom;

import net.minecraft.block.entity.BlockEntityType;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;
import net.wdfeer.crazymod.block.entity.HopperAcceleratorEntity;

public class DenseHopperAccelerator extends HopperAccelerator {
    @Override
    public BlockEntityType<HopperAcceleratorEntity> getBlockEntityType() {
        return ModBlockEntityTypes.DENSE_HOPPER_ACCELERATOR;
    }
}
