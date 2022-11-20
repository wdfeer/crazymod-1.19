package net.wdfeer.crazymod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.wdfeer.crazymod.block.ModBlockEntities;

public class DenseFurnaceEfficiencyEnhancerEntity extends FurnaceEfficiencyEnhancerEntity {

    public DenseFurnaceEfficiencyEnhancerEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.DENSE_FURNACE_EFFICIENCY_ENHANCER_ENTITY_TYPE, pos, state);
    }

    @Override
    public float getFailChance() {
        return 0.5f;
    }
}
