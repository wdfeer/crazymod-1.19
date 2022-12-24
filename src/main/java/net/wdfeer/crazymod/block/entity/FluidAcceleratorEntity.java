package net.wdfeer.crazymod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;
import net.wdfeer.crazymod.util.ExtraMath;

public class FluidAcceleratorEntity extends BlockTickerEntity {
    public FluidAcceleratorEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.FLUID_ACCELERATOR, pos, state);
    }

    @Override
    public float getExtraTicks() {
        return 2;
    }
    @Override
    public int getRadius() {
        return 1;
    }
    @Override
    public void tryTickBlock(World world, BlockPos pos) {
        FluidState fluidState = world.getFluidState(pos);
        if (fluidState == null) return;
        Fluid fluid = fluidState.getFluid();
        int fluidTickRate = fluid.getTickRate(world);
        if (fluidTickRate <= 0) return;
        int ticks = ExtraMath.RandomRound(getExtraTicks() / fluidTickRate);
        for (int i = 0; i < ticks; i++) {
            fluidState.onScheduledTick(world, pos);
        }
    }
}
