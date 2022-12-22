package net.wdfeer.crazymod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;

public class FueledSpawnerAcceleratorEntity extends FueledBlockTickerEntity {
    public FueledSpawnerAcceleratorEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
    public FueledSpawnerAcceleratorEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.FUELED_SPAWNER_ACCELERATOR, pos, state);
    }

    @Override
    public float getExtraTicks() {
        return 1;
    }

    @Override
    public int getRadius() {
        return 1;
    }

    @Override
    public float getFuelConsumption() {
        return super.getFuelConsumption() * 2f;
    }

    @Override
    public boolean filter(BlockState state, BlockEntity blockEntity) {
        String blockName = state.getBlock().getName().toString().toLowerCase();
        return super.filter(state, blockEntity) && (blockName.contains("spawner") || blockName.contains("conjurer"));
    }
}
