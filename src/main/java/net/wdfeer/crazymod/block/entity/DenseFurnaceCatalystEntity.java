package net.wdfeer.crazymod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;

public class DenseFurnaceCatalystEntity extends FurnaceCatalystEntity {
    public DenseFurnaceCatalystEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.DENSE_FURNACE_CATALYST, pos, state);
    }
    @Override
    public int getExtraTicks() {
        return 3;
    }
}
