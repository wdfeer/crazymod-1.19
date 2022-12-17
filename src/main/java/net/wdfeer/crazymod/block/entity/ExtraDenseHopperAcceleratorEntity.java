package net.wdfeer.crazymod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;

public class ExtraDenseHopperAcceleratorEntity extends HopperAcceleratorEntity {
    public ExtraDenseHopperAcceleratorEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.EXTRA_DENSE_HOPPER_ACCELERATOR, pos, state);
    }

    @Override
    public float getExtraTicks() {
        return super.getExtraTicks() * 64;
    }
}
