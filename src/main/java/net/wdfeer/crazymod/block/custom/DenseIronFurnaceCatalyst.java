package net.wdfeer.crazymod.block.custom;

import net.minecraft.block.entity.BlockEntityType;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;
import net.wdfeer.crazymod.block.entity.DenseIronFurnaceCatalystEntity;

public class DenseIronFurnaceCatalyst extends FurnaceUpgradeBlock {

    @Override
    public BlockEntityType<DenseIronFurnaceCatalystEntity> getBlockEntityType() {
        return ModBlockEntityTypes.DENSE_IRON_FURNACE_CATALYST;
    }
}
