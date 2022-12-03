package net.wdfeer.crazymod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;

public class SaplingAcceleratorEntity extends BlockEntity {
    public SaplingAcceleratorEntity(BlockEntityType type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
    public SaplingAcceleratorEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.SAPLING_ACCELERATOR, pos, state);
    }
    public int getRelativeSpeedBoost(){
        return 1;
    }
    private static float getRelativeSpeedToExtraRandomTicksRatio(){ return 4f; }
    public static void tick(World world, BlockPos pos, BlockState state, SaplingAcceleratorEntity instance){
        if (world.isClient)
            return;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    BlockPos blockPos = pos.add(x, y, z);
                    var blockState = world.getBlockState(blockPos);
                    if (!(blockState.getBlock() instanceof SaplingBlock))
                        continue;
                    for (int i = 0; i < instance.getRelativeSpeedBoost(); i++) {
                        if (world.random.nextFloat() * getRelativeSpeedToExtraRandomTicksRatio() > 1f)
                            continue;
                        if ((world.random.nextFloat() * 20) < world.getGameRules().get(GameRules.RANDOM_TICK_SPEED).get())
                            blockState.randomTick((ServerWorld) world, blockPos, world.random);
                    }
                }
            }
        }


    }
}
