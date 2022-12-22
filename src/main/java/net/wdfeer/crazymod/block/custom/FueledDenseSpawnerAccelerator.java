package net.wdfeer.crazymod.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.world.World;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;
import net.wdfeer.crazymod.block.entity.FueledSpawnerAcceleratorEntity;
import org.jetbrains.annotations.Nullable;

public class FueledDenseSpawnerAccelerator extends FueledSpawnerAccelerator {
    @Override
    public BlockEntityType<? extends FueledSpawnerAcceleratorEntity> getBlockEntityType() {
        return ModBlockEntityTypes.FUELED_DENSE_SPAWNER_ACCELERATOR;
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, getBlockEntityType(), FueledSpawnerAcceleratorEntity::tick);
    }
}
