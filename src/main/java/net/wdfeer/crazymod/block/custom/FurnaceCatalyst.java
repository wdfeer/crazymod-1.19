package net.wdfeer.crazymod.block.custom;

import net.minecraft.block.entity.BlockEntityType;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;
import net.wdfeer.crazymod.block.entity.FurnaceCatalystEntity;

public class FurnaceCatalyst extends FurnaceUpgradeBlock {
    @Override
    public BlockEntityType<FurnaceCatalystEntity> getBlockEntityType() {
        return ModBlockEntityTypes.FURNACE_CATALYST;
    }
}
