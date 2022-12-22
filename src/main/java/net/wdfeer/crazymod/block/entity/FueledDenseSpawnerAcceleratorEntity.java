package net.wdfeer.crazymod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;

public class FueledDenseSpawnerAcceleratorEntity extends FueledSpawnerAcceleratorEntity {
    public FueledDenseSpawnerAcceleratorEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.FUELED_DENSE_SPAWNER_ACCELERATOR, pos, state);
    }

    @Override
    public float getExtraTicks() {
        return super.getExtraTicks() * 8;
    }

    @Override
    public float getFuelConsumption() {
        return super.getFuelConsumption() * 8f;
    }
}
