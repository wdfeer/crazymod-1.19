package net.wdfeer.crazymod.block;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.wdfeer.crazymod.CrazyMod;
import net.wdfeer.crazymod.block.entity.DenseFurnaceCatalystEntity;
import net.wdfeer.crazymod.block.entity.DenseFurnaceEfficiencyEnhancerEntity;
import net.wdfeer.crazymod.block.entity.FurnaceCatalystEntity;
import net.wdfeer.crazymod.block.entity.FurnaceEfficiencyEnhancerEntity;

public class ModBlockEntities {
    public static final BlockEntityType<FurnaceCatalystEntity> FURNACE_CATALYST_ENTITY_TYPE =
            RegisterBlockEntityType("furnace_catalyst_entity",
                FurnaceCatalystEntity::new,
                ModBlocks.FURNACE_CATALYST);
    public static final BlockEntityType<DenseFurnaceCatalystEntity> DENSE_FURNACE_CATALYST_ENTITY_TYPE =
            RegisterBlockEntityType("dense_furnace_catalyst_entity",
                DenseFurnaceCatalystEntity::new,
                ModBlocks.DENSE_FURNACE_CATALYST);
    public static final BlockEntityType<FurnaceEfficiencyEnhancerEntity> FURNACE_EFFICIENCY_ENHANCER_ENTITY_TYPE =
            RegisterBlockEntityType("furnace_efficiency_enhancer_entity",
                FurnaceEfficiencyEnhancerEntity::new,
                ModBlocks.FURNACE_EFFICIENCY_ENHANCER);
    public static final BlockEntityType<DenseFurnaceEfficiencyEnhancerEntity> DENSE_FURNACE_EFFICIENCY_ENHANCER_ENTITY_TYPE =
            RegisterBlockEntityType("dense_furnace_efficiency_enhancer_entity",
                DenseFurnaceEfficiencyEnhancerEntity::new,
                ModBlocks.DENSE_FURNACE_EFFICIENCY_ENHANCER);

    private static <BE extends BlockEntity> BlockEntityType<BE> RegisterBlockEntityType(String name, FabricBlockEntityTypeBuilder.Factory<BE> factory, net.minecraft.block.Block block){
        return Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(CrazyMod.MOD_ID, name),
                FabricBlockEntityTypeBuilder.create(factory, block).build());
    }
    public static void Initialize() {}
}
