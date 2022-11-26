package net.wdfeer.crazymod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;

public class IronFurnaceCatalystEntity extends FurnaceCatalystEntity {
    public IronFurnaceCatalystEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.IRON_FURNACE_CATALYST, pos, state);
    }
    @Override
    public int getExtraTicks() {
        return 6;
    }
}
