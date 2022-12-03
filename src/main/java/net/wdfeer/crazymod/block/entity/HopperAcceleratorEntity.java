package net.wdfeer.crazymod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;

public class HopperAcceleratorEntity extends BlockEntity {
    public HopperAcceleratorEntity(BlockEntityType type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
    public HopperAcceleratorEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.HOPPER_ACCELERATOR, pos, state);
    }
    public int getExtraTicks(){
        return 1;
    }
    public static void tick(World world, BlockPos pos, BlockState state, HopperAcceleratorEntity instance){
        if (world.isClient)
            return;
        for (int x = -1; x <= 1; x++) {
            BlockPos blockPos = pos.offset(Direction.Axis.X, x);
            for (int y = -1; y <= 1; y++) {
                blockPos = blockPos.offset(Direction.Axis.Y, y);
                for (int z = -1; z <= 1; z++) {
                    blockPos = blockPos.offset(Direction.Axis.Z, z);
                    var blockState = world.getBlockState(blockPos);
                    if (!(blockState.getBlock().getName().toString().toLowerCase().contains("hopper"))) continue;
                    BlockEntity blockEntity = world.getBlockEntity(blockPos);
                    if (blockEntity instanceof HopperAcceleratorEntity) continue;
                    if (blockEntity == null) continue;
                    BlockEntityType blockEntityType = blockEntity.getType();
                    BlockEntityTicker ticker = blockState.getBlockEntityTicker(world, blockEntityType);
                    if (ticker == null) continue;
                    for (int i = 0; i < instance.getExtraTicks(); i++) {
                        ticker.tick(world, blockPos, blockState, blockEntity);
                    }
                }
            }
        }
    }
}
