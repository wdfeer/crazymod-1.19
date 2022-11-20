package net.wdfeer.crazymod.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.wdfeer.crazymod.block.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

public class DenseFurnaceCatalyst extends FurnaceCatalyst {
    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DenseFurnaceCatalystEntity(pos, state);
    }
    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type,
                ModBlockEntities.DENSE_FURNACE_CATALYST_ENTITY_TYPE,
                FurnaceUpgradeEntity::tick);
    }
}
