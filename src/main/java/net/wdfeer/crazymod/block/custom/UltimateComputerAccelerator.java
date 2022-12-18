package net.wdfeer.crazymod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.wdfeer.crazymod.block.entity.AdvancedComputerAcceleratorEntity;
import net.wdfeer.crazymod.block.entity.ComputerAcceleratorEntity;

public class UltimateComputerAccelerator extends ComputerAccelerator {
    @Override
    public BlockEntityType<? extends ComputerAcceleratorEntity> getBlockEntityType() {
        return blockEntityType;
    }

    public static Block instance;
    public static BlockEntityType<AdvancedComputerAcceleratorEntity> blockEntityType;
}
