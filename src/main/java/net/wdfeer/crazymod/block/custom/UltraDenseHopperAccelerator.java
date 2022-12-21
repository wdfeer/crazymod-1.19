package net.wdfeer.crazymod.block.custom;

import net.minecraft.block.entity.BlockEntityType;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;
import net.wdfeer.crazymod.block.entity.HopperAcceleratorEntity;

public class UltraDenseHopperAccelerator extends HopperAccelerator {
    @Override
    public BlockEntityType<HopperAcceleratorEntity> getBlockEntityType() {
        return ModBlockEntityTypes.ULTRA_DENSE_HOPPER_ACCELERATOR;
    }

}
