package net.wdfeer.crazymod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;

public class SpawnerAcceleratorEntity extends BlockEntityTickerEntity {
    public SpawnerAcceleratorEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.SPAWNER_ACCELERATOR, pos, state);
    }

    @Override
    public float getExtraTicks() {
        return 0.25f;
    }
    @Override
    public int getRadius() {
        return 1;
    }
    @Override
    public boolean filter(BlockState state, BlockEntity blockEntity) {
        String blockName = state.getBlock().getName().toString().toLowerCase();
        return super.filter(state, blockEntity) && (blockName.contains("spawner") || blockName.contains("conjurer"));
    }
}
