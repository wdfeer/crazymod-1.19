package net.wdfeer.crazymod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.wdfeer.crazymod.block.custom.AdvancedComputerAccelerator;

public class AdvancedComputerAcceleratorEntity extends ComputerAcceleratorEntity {
    public AdvancedComputerAcceleratorEntity(BlockEntityType type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
    public AdvancedComputerAcceleratorEntity(BlockPos pos, BlockState state) {
        super(AdvancedComputerAccelerator.blockEntityType, pos, state);
    }
    @Override
    public float getExtraTicks(){
        return super.getExtraTicks() * 2;
    }
    @Override
    public int getRadius() {
        return 2;
    }
}
