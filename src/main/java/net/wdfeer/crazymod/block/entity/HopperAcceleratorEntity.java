package net.wdfeer.crazymod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;

public class HopperAcceleratorEntity extends BlockTickerEntity {
    public HopperAcceleratorEntity(BlockEntityType type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
    public HopperAcceleratorEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.HOPPER_ACCELERATOR, pos, state);
    }
    @Override
    public float getExtraTicks(){
        return 1;
    }
    @Override
    public int getRadius() {
        return 1;
    }
    @Override
    public boolean filter(BlockState state, BlockEntity blockEntity) {
        return super.filter(state, blockEntity) && state.getBlock().getName().toString().toLowerCase().contains("hopper");
    }
}
