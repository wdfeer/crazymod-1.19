package net.wdfeer.crazymod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static net.wdfeer.crazymod.util.ExtraMath.RandomRound;

public abstract class BlockTickerEntity extends BlockEntity {
    public BlockTickerEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public abstract float getExtraTicks();
    public abstract int getRadius();
    public boolean filter(BlockState state, BlockEntity blockEntity){
        return !(blockEntity instanceof BlockTickerEntity);
    }

    public static void tick(World world, BlockPos thisPos, BlockState thisState, BlockTickerEntity instance){
        if (world.isClient)
            return;
        int radius = instance.getRadius();
        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos blockPos = thisPos.add(x, y, z);
                    instance.tryTickBlock(world, blockPos);
                }
            }
        }
    }
    public void tryTickBlock(World world, BlockPos pos){
        var blockState = world.getBlockState(pos);
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity == null) return;
        if (!filter(blockState, blockEntity)) return;
        int ticks = RandomRound(getExtraTicks());
        for (int i = 0; i < ticks; i++) {
            tickBlockEntity(world, pos, blockState, blockEntity);
        }
    }
    public static void tickBlockEntity(World world, BlockPos pos, BlockState state, BlockEntity entity){
        BlockEntityType blockEntityType = entity.getType();
        BlockEntityTicker ticker = state.getBlockEntityTicker(world, blockEntityType);
        if (ticker == null) return;
        ticker.tick(world, pos, state, entity);
    }
}