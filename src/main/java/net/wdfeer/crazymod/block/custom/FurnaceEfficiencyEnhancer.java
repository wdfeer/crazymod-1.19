package net.wdfeer.crazymod.block.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;
import net.wdfeer.crazymod.block.entity.FurnaceEfficiencyEnhancerEntity;
import net.wdfeer.crazymod.block.entity.FurnaceUpgradeEntity;
import org.jetbrains.annotations.Nullable;

public class FurnaceEfficiencyEnhancer extends BlockWithEntity implements BlockEntityProvider {
    public FurnaceEfficiencyEnhancer() {
        super(FabricBlockSettings.of(Material.STONE).strength(6f, 30f).requiresTool());
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new FurnaceEfficiencyEnhancerEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type,
                ModBlockEntityTypes.FURNACE_EFFICIENCER,
                FurnaceUpgradeEntity::tick);
    }
}
