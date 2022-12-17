package net.wdfeer.crazymod.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.world.World;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;
import net.wdfeer.crazymod.block.entity.DenseSpawnerAcceleratorEntity;
import net.wdfeer.crazymod.block.entity.SpawnerAcceleratorEntity;
import org.jetbrains.annotations.Nullable;

public class DenseSpawnerAccelerator extends SpawnerAccelerator {
    @Override
    public BlockEntityType<? extends SpawnerAcceleratorEntity> getBlockEntityType() {
        return ModBlockEntityTypes.DENSE_SPAWNER_ACCELERATOR;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, getBlockEntityType(), DenseSpawnerAcceleratorEntity::tick);
    }
}
