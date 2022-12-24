package net.wdfeer.crazymod.block.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.world.World;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;
import net.wdfeer.crazymod.block.entity.FluidAcceleratorEntity;
import org.jetbrains.annotations.Nullable;

public class FluidAccelerator extends ModBlockWithEntity {
    public static final FabricBlockSettings defaultSettings = FabricBlockSettings.of(Material.STONE).strength(6f, 30f).requiresTool();
    public FluidAccelerator() {
        super(defaultSettings);
    }
    @Override
    public BlockEntityType<? extends FluidAcceleratorEntity> getBlockEntityType() {
        return ModBlockEntityTypes.FLUID_ACCELERATOR;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, getBlockEntityType(), FluidAcceleratorEntity::tick);
    }
}
