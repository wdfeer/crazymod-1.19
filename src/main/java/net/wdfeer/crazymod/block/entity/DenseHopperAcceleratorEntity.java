package net.wdfeer.crazymod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;

public class DenseHopperAcceleratorEntity extends HopperAcceleratorEntity {
    public DenseHopperAcceleratorEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.DENSE_HOPPER_ACCELERATOR, pos, state);
    }

    @Override
    public int getExtraTicks() {
        return 8;
    }
}
