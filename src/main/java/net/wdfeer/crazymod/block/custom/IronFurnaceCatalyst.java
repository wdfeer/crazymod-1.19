package net.wdfeer.crazymod.block.custom;

import net.minecraft.block.entity.BlockEntityType;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;
import net.wdfeer.crazymod.block.entity.IronFurnaceCatalystEntity;

public class IronFurnaceCatalyst extends FurnaceUpgradeBlock {

    @Override
    public BlockEntityType<IronFurnaceCatalystEntity> getBlockEntityType() {
        return ModBlockEntityTypes.IRON_FURNACE_CATALYST;
    }
}
