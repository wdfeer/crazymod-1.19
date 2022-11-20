package net.wdfeer.crazymod.block.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.wdfeer.crazymod.block.entity.FurnaceUpgradeEntity;
import org.jetbrains.annotations.Nullable;

public abstract class FurnaceUpgradeBlock extends BlockWithEntity implements BlockEntityProvider {
    public FurnaceUpgradeBlock() {
        super(FabricBlockSettings.of(Material.STONE).strength(4.5f, 30f).requiresTool());
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    public abstract BlockEntityType<? extends FurnaceUpgradeEntity> getBlockEntityType();
    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return getBlockEntityType().instantiate(pos, state);
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type,
                getBlockEntityType(),
                FurnaceUpgradeEntity::tick);
    }
}
