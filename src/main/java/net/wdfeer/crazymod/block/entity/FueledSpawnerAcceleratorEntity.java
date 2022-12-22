package net.wdfeer.crazymod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;

public class FueledSpawnerAcceleratorEntity extends FueledBlockTickerEntity {
    public FueledSpawnerAcceleratorEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.FUELED_SPAWNER_ACCELERATOR, pos, state);
    }

    @Override
    public float getExtraTicks() {
        return 10;
    }

    @Override
    public int getRadius() {
        return 1;
    }
}
