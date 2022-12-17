package net.wdfeer.crazymod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;

public class DenseSpawnerAcceleratorEntity extends SpawnerAcceleratorEntity {
    public DenseSpawnerAcceleratorEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.DENSE_SPAWNER_ACCELERATOR, pos, state);
    }

    @Override
    public float getExtraTicks() {
        return super.getExtraTicks() * 8;
    }
}
