package net.wdfeer.crazymod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.wdfeer.crazymod.block.custom.UltimateComputerAccelerator;

public class UltimateComputerAcceleratorEntity extends AdvancedComputerAcceleratorEntity {
    public UltimateComputerAcceleratorEntity(BlockEntityType type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
    public UltimateComputerAcceleratorEntity(BlockPos pos, BlockState state) {
        super(UltimateComputerAccelerator.blockEntityType, pos, state);
    }
    @Override
    public float getExtraTicks(){
        return super.getExtraTicks() * 2;
    }
    @Override
    public int getRadius() {
        return 3;
    }
}
