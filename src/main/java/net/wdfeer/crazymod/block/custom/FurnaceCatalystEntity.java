package net.wdfeer.crazymod.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.wdfeer.crazymod.block.ModBlockEntities;

public class FurnaceCatalystEntity extends BlockEntity {
    protected FurnaceCatalystEntity(BlockEntityType type, BlockPos pos, BlockState state){
        super(type, pos, state);
    }
    public FurnaceCatalystEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FURNACE_CATALYST_ENTITY_TYPE, pos, state);
    }
    public int getExtraTicks() {
        return 1;
    }
    @SuppressWarnings("unused")
    public static void tick(World world, BlockPos pos, BlockState state, FurnaceCatalystEntity instance){
        BlockPos abovePos = pos.up();
        BlockState aboveState = world.getBlockState(abovePos);
        if (aboveState.isAir())
            return;
        BlockEntity aboveBlockEntity = world.getBlockEntity(abovePos);
        if (aboveBlockEntity instanceof AbstractFurnaceBlockEntity furnaceEntity){
            int extraTicks = getTotalExtraTicks(world, pos, instance);
            for (int i = 0; i < extraTicks; i++) {
                AbstractFurnaceBlockEntity.tick(world, abovePos, aboveState, furnaceEntity);
            }
        }
    }
    private static int getTotalExtraTicks(World world, BlockPos topPos, FurnaceCatalystEntity topCatalyst){
        int catalystCount = 1;
        int extraTicks = topCatalyst.getExtraTicks();
        while (catalystCount < 512){
            BlockPos below = topPos.down(catalystCount);
            BlockEntity belowEntity = world.getBlockEntity(below);
            if (belowEntity instanceof FurnaceCatalystEntity catalyst) {
                extraTicks += catalyst.getExtraTicks();
                catalystCount++;
            } else {
                break;
            }
        }
        return extraTicks;
    }
}
