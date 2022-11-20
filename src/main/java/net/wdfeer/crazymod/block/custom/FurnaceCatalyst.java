package net.wdfeer.crazymod.block.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.wdfeer.crazymod.block.ModBlockEntities;
import net.wdfeer.crazymod.block.entity.FurnaceCatalystEntity;
import net.wdfeer.crazymod.block.entity.FurnaceUpgradeEntity;
import org.jetbrains.annotations.Nullable;

public class FurnaceCatalyst extends BlockWithEntity implements BlockEntityProvider {
    public FurnaceCatalyst() {
        super(FabricBlockSettings.of(Material.STONE).strength(4.5f, 30f).requiresTool());
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new FurnaceCatalystEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type,
                ModBlockEntities.FURNACE_CATALYST_ENTITY_TYPE,
                FurnaceUpgradeEntity::tick);
    }
}
