package net.wdfeer.crazymod.block.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.wdfeer.crazymod.block.ModBlocks;

@SuppressWarnings("deprecation")
public class FurnaceCatalyst extends Block {
    public FurnaceCatalyst() {
        super(FabricBlockSettings.of(Material.STONE).strength(4f, 30f).requiresTool());
    }


    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        world.createAndScheduleBlockTick(pos, state.getBlock(), 5);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockPos abovePos = pos.up();
        BlockState aboveState = world.getBlockState(abovePos);
        if (aboveState.isAir())
            return;
        BlockEntity aboveBlockEntity = world.getBlockEntity(abovePos);
        if (aboveBlockEntity instanceof AbstractFurnaceBlockEntity furnaceEntity){
            int count = 1;
            while (count < 512){
                BlockPos below = pos.down(count);
                if (!world.getBlockState(below).isOf(ModBlocks.FURNACE_CATALYST)) {
                    break;
                } else {
                    count++;
                }
            }
            for (int i = 0; i < count; i++) {
                AbstractFurnaceBlockEntity.tick(world, abovePos, aboveState, furnaceEntity);
            }
            world.createAndScheduleBlockTick(pos, state.getBlock(), 1);
        }
        else
            world.createAndScheduleBlockTick(pos, state.getBlock(), 20);
    }
}
