package net.wdfeer.crazymod.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.wdfeer.crazymod.block.ModBlockEntities;
import net.wdfeer.crazymod.block.ModBlocks;

public class FurnaceCatalystEntity extends BlockEntity {
    public FurnaceCatalystEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FURNACE_CATALYST_ENTITY_TYPE, pos, state);
    }
    @SuppressWarnings("unused")
    public static void tick(World world, BlockPos pos, BlockState state, FurnaceCatalystEntity instance){
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
        }
    }
}
