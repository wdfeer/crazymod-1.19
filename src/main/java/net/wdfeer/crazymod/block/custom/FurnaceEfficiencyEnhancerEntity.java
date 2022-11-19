package net.wdfeer.crazymod.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.wdfeer.crazymod.block.ModBlockEntities;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;

public class FurnaceEfficiencyEnhancerEntity extends FurnaceUpgradeEntity {
    protected FurnaceEfficiencyEnhancerEntity(BlockEntityType type, BlockPos pos, BlockState state){
        super(type, pos, state);
    }
    public FurnaceEfficiencyEnhancerEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FURNACE_EFFICIENCY_ENHANCER_ENTITY_TYPE, pos, state);
    }
    public float getFailChance() {
        return 0.8f;
    }
    public static void tickAll(World world, AbstractFurnaceBlockEntity furnace, FurnaceUpgradeEntity[] upgrades) {
        float failChance = 1f;
        for (FurnaceUpgradeEntity upgrade : upgrades) {
            if (upgrade instanceof FurnaceEfficiencyEnhancerEntity eff) {
                failChance *= eff.getFailChance();
            }
        }
        if (failChance == 1f)
            return;

        int ticks = FurnaceCatalystEntity.getAllExtraTicks(upgrades) + 1;

        for (int i = 0; i < ticks; i++) {
            tryAddBurnTime(furnace, world.random, failChance);
        }
    }
    private static void tryAddBurnTime(AbstractFurnaceBlockEntity furnace, net.minecraft.util.math.random.Random random, float failChance){
        Field burnTime = FieldUtils.getField(AbstractFurnaceBlockEntity.class, "burnTime", true);
        try {
            int current = (int)burnTime.get(furnace);
            if (current > 0 && random.nextFloat() > failChance){
                burnTime.set(furnace, current + 1);
            }
        } catch (IllegalAccessException ignored) {}
    }
}