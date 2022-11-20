package net.wdfeer.crazymod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.wdfeer.crazymod.block.ModBlockEntities;

public class DenseFurnaceCatalystEntity extends FurnaceCatalystEntity {
    public DenseFurnaceCatalystEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.DENSE_FURNACE_CATALYST_ENTITY_TYPE, pos, state);
    }
    @Override
    public int getExtraTicks() {
        return 3;
    }
}
