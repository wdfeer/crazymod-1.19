package net.wdfeer.crazymod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.wdfeer.crazymod.block.custom.ComputerAccelerator;

import java.util.Arrays;

public class ComputerAcceleratorEntity extends BlockEntityTickerEntity {
    public ComputerAcceleratorEntity(BlockEntityType type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
    public ComputerAcceleratorEntity(BlockPos pos, BlockState state) {
        super(ComputerAccelerator.blockEntityType, pos, state);
    }
    @Override
    public float getExtraTicks(){
        return 1;
    }
    @Override
    public int getRadius() {
        return 1;
    }
    static final String[] affectedBlocks = new String[] {
        "turtle_normal", "turtle_advanced" };
    @Override
    public boolean filter(BlockState state, BlockEntity blockEntity) {
        String blockName = state.getBlock().getName().toString();
        return super.filter(state, blockEntity) &&
                Arrays.stream(affectedBlocks).anyMatch(blockName::contains);
    }
}
