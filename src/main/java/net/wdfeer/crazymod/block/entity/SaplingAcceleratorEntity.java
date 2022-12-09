package net.wdfeer.crazymod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;

public class SaplingAcceleratorEntity extends RandomTickerEntity {
    public SaplingAcceleratorEntity(BlockEntityType type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
    public SaplingAcceleratorEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.SAPLING_ACCELERATOR, pos, state);
    }

    @Override
    public float getExtraTicks() {
        return 0.25f;
    }

    @Override
    public int getRadius() {
        return 1;
    }

    @Override
    public boolean filter(BlockState state, BlockEntity blockEntity) {
        return super.filter(state, blockEntity) && state.getBlock().getName().toString().toLowerCase().contains("sapling");
    }
}
