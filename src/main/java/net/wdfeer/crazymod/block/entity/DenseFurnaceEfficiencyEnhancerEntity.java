package net.wdfeer.crazymod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;

public class DenseFurnaceEfficiencyEnhancerEntity extends FurnaceEfficiencyEnhancerEntity {

    public DenseFurnaceEfficiencyEnhancerEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.DENSE_FURNACE_EFFICIENCER, pos, state);
    }

    @Override
    public float getExtraFuelTime() {
        return 0.75f;
    }
}
