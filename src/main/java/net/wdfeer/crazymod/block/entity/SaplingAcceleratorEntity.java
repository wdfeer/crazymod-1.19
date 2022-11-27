package net.wdfeer.crazymod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;

public class SaplingAcceleratorEntity extends BlockEntity {
    public SaplingAcceleratorEntity(BlockEntityType type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
    public SaplingAcceleratorEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.SAPLING_ACCELERATOR, pos, state);
    }
    public int getExtraRandomTicks(){
        return 1;
    }
    public static void tick(World world, BlockPos pos, BlockState state, SaplingAcceleratorEntity instance){
        if (world.isClient)
            return;
        for (int x = -1; x <= 1; x++) {
            BlockPos blockPos = pos.offset(Direction.Axis.X, x);
            for (int y = -1; y <= 1; y++) {
                blockPos = blockPos.offset(Direction.Axis.Y, x);
                for (int z = -1; z <= 1; z++) {
                    blockPos = blockPos.offset(Direction.Axis.Z, z);
                    var blockState = world.getBlockState(blockPos);
                    if (!(blockState.getBlock() instanceof SaplingBlock))
                        continue;
                    for (int i = 0; i < instance.getExtraRandomTicks(); i++) {
                        blockState.randomTick((ServerWorld) world, blockPos, world.random);
                    }
                }
            }
        }


    }
}
