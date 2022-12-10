package net.wdfeer.crazymod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static net.wdfeer.crazymod.util.ExtraMath.RandomRound;

public abstract class BlockEntityTickerEntity extends BlockEntity {
    public BlockEntityTickerEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public abstract float getExtraTicks();
    public abstract int getRadius();
    public boolean filter(BlockState state, BlockEntity blockEntity){
        return !(blockEntity instanceof BlockEntityTickerEntity);
    }

    public static void tick(World world, BlockPos thisPos, BlockState thisState, BlockEntityTickerEntity instance){
        if (world.isClient)
            return;
        int radius = instance.getRadius();
        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos blockPos = thisPos.add(x, y, z);
                    var blockState = world.getBlockState(blockPos);
                    BlockEntity blockEntity = world.getBlockEntity(blockPos);
                    if (blockEntity == null) continue;
                    if (!instance.filter(blockState, blockEntity)) continue;
                    int ticks = RandomRound(instance.getExtraTicks());
                    for (int i = 0; i < ticks; i++) {
                        tickBlockEntity(world, blockPos, blockState, blockEntity);
                    }
                }
            }
        }
    }
    public static void tickBlockEntity(World world, BlockPos pos, BlockState state, BlockEntity entity){
        BlockEntityType blockEntityType = entity.getType();
        BlockEntityTicker ticker = state.getBlockEntityTicker(world, blockEntityType);
        if (ticker == null) return;
        ticker.tick(world, pos, state, entity);
    }
}