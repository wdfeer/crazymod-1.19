package net.wdfeer.crazymod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;

public class FurnaceCatalystEntity extends FurnaceUpgradeEntity {
    protected FurnaceCatalystEntity(BlockEntityType type, BlockPos pos, BlockState state){
        super(type, pos, state);
    }
    public FurnaceCatalystEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.FURNACE_CATALYST, pos, state);
    }
    public int getExtraTicks() {
        return 1;
    }
    public static int getAllExtraTicks(FurnaceUpgradeEntity[] upgrades){
        int extraTicks = 0;
        for (FurnaceUpgradeEntity upgrade : upgrades) {
            if (upgrade instanceof FurnaceCatalystEntity catalyst) {
                extraTicks += catalyst.getExtraTicks();
            }
        }
        return extraTicks;
    }
    public static void tickAll(World world, BlockPos furnacePos, BlockState furnaceState, AbstractFurnaceBlockEntity furnace, FurnaceUpgradeEntity[] upgrades) {
        int extraTicks = getAllExtraTicks(upgrades);
        for (int i = 0; i < extraTicks; i++) {
            AbstractFurnaceBlockEntity.tick(world, furnacePos, furnaceState, furnace);
        }
    }
}
