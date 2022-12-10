package net.wdfeer.crazymod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;

public abstract class FurnaceUpgradeEntity extends BlockEntity {
    public FurnaceUpgradeEntity(BlockEntityType type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
    @SuppressWarnings("unused")
    public static void tick(World world, BlockPos pos, BlockState state, FurnaceUpgradeEntity instance){
        BlockPos abovePos = pos.up();
        BlockState aboveState = world.getBlockState(abovePos);
        BlockEntity aboveBlockEntity = world.getBlockEntity(abovePos);
        if (aboveBlockEntity instanceof FurnaceUpgradeEntity)
            return;
        if (aboveState.getBlock().getName().toString().toLowerCase().contains("furnace")){
            FurnaceUpgradeEntity[] upgrades = getUpgrades(world, pos, instance);

            FurnaceCatalystEntity.tickAll(world, abovePos, aboveState, aboveBlockEntity, upgrades);
            if (aboveBlockEntity instanceof AbstractFurnaceBlockEntity furnaceEntity)
                FurnaceEfficiencyEnhancerEntity.tickAll(world, furnaceEntity, upgrades);
        }
    }
    private static FurnaceUpgradeEntity[] getUpgrades(World world, BlockPos topPos, FurnaceUpgradeEntity topUpgrade){
        ArrayList<FurnaceUpgradeEntity> upgrades = new ArrayList<>();
        upgrades.add(topUpgrade);
        int layers = 1;
        while (layers < 512){
            BlockEntity lowerEntity = world.getBlockEntity(topPos.down(layers));
            if (lowerEntity instanceof FurnaceUpgradeEntity upgrade) {
                upgrades.add(upgrade);
                layers++;
            } else {
                break;
            }
        }
        return upgrades.toArray(new FurnaceUpgradeEntity[0]);
    }
}
