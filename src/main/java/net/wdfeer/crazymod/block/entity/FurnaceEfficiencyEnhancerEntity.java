package net.wdfeer.crazymod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.wdfeer.crazymod.CrazyMod;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;

public class FurnaceEfficiencyEnhancerEntity extends FurnaceUpgradeEntity {
    protected FurnaceEfficiencyEnhancerEntity(BlockEntityType type, BlockPos pos, BlockState state){
        super(type, pos, state);
    }
    public FurnaceEfficiencyEnhancerEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.FURNACE_EFFICIENCER, pos, state);
    }
    public float getExtraFuelTime() {
        return 0.25f;
    }
    public static void tickAll(World world, AbstractFurnaceBlockEntity furnace, FurnaceUpgradeEntity[] upgrades) {
        float fuelTimeMult = 1f;
        for (FurnaceUpgradeEntity upgrade : upgrades) {
            if (upgrade instanceof FurnaceEfficiencyEnhancerEntity eff) {
                fuelTimeMult += eff.getExtraFuelTime();
            }
        }
        if (fuelTimeMult == 1f)
            return;
        float failChance = 1f / fuelTimeMult;

        int ticks = FurnaceCatalystEntity.getAllExtraTicks(upgrades) + 1;

        addBurnTicks(furnace, world.random, failChance, ticks);
    }
    private static void addBurnTicks(AbstractFurnaceBlockEntity furnace, net.minecraft.util.math.random.Random random, float failChance, int times){
        PropertyDelegate propertyDelegate = null;
        var fields = FieldUtils.getAllFields(AbstractFurnaceBlockEntity.class);
        for (Field f : fields) {
            f.setAccessible(true);
            try {
                if (f.get(furnace) instanceof PropertyDelegate delegate){
                    if (delegate.get(0) <= 0)
                        continue;
                    propertyDelegate = delegate;
                    break;
                }
            } catch (IllegalAccessException ignored) {}
        }
        if (propertyDelegate == null){
            CrazyMod.LOGGER.error("Failed to find a PropertyDelegate field in the AbstractFurnaceBlockEntity class");
            return;
        }
        for (int i = 0; i < times; i++) {
            int current = propertyDelegate.get(0);
            if (current > 0 && random.nextFloat() > failChance){
                propertyDelegate.set(0, current + 1);
            }
        }
    }
}