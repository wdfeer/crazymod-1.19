package net.wdfeer.crazymod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;

public class DenseSaplingAcceleratorEntity extends SaplingAcceleratorEntity {
    public DenseSaplingAcceleratorEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.DENSE_SAPLING_ACCELERATOR, pos, state);
    }

    @Override
    public float getExtraTicks() {
        return super.getExtraTicks() * 8f;
    }
}
