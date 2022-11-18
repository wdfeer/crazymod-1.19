package net.wdfeer.crazymod.block;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.wdfeer.crazymod.CrazyMod;
import net.wdfeer.crazymod.block.custom.FurnaceCatalystEntity;

public class ModBlockEntities {
    public static final BlockEntityType<FurnaceCatalystEntity> FURNACE_CATALYST_ENTITY_TYPE = Registry.register(Registry.BLOCK_ENTITY_TYPE,
            new Identifier(CrazyMod.MOD_ID, "furnace_catalyst_entity"),
            FabricBlockEntityTypeBuilder.create(FurnaceCatalystEntity::new, ModBlocks.FURNACE_CATALYST).build());
    public static void Initialize() {}
}
