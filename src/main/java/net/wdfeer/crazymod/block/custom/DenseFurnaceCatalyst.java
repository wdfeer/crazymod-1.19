package net.wdfeer.crazymod.block.custom;

import net.minecraft.block.entity.BlockEntityType;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;
import net.wdfeer.crazymod.block.entity.DenseFurnaceCatalystEntity;

public class DenseFurnaceCatalyst extends FurnaceUpgradeBlock {

    @Override
    public BlockEntityType<DenseFurnaceCatalystEntity> getBlockEntityType() {
        return ModBlockEntityTypes.DENSE_FURNACE_CATALYST;
    }
}
