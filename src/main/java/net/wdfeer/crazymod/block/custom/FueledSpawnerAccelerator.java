package net.wdfeer.crazymod.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.world.World;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;
import net.wdfeer.crazymod.block.entity.FueledSpawnerAcceleratorEntity;
import org.jetbrains.annotations.Nullable;

public class FueledSpawnerAccelerator extends FueledBlockTicker {
    public FueledSpawnerAccelerator() {
        super(SpawnerAccelerator.defaultSettings);
    }
    @Override
    public BlockEntityType<? extends FueledSpawnerAcceleratorEntity> getBlockEntityType() {
        return ModBlockEntityTypes.FUELED_SPAWNER_ACCELERATOR;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, getBlockEntityType(), FueledSpawnerAcceleratorEntity::tick);
    }
}
