package net.wdfeer.crazymod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;

public class UltraDenseHopperAcceleratorEntity extends HopperAcceleratorEntity {
    public UltraDenseHopperAcceleratorEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.ULTRA_DENSE_HOPPER_ACCELERATOR, pos, state);
    }

    @Override
    public float getExtraTicks() {
        return super.getExtraTicks() * 512;
    }
}
