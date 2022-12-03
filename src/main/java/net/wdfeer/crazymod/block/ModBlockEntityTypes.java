package net.wdfeer.crazymod.block;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.wdfeer.crazymod.CrazyMod;
import net.wdfeer.crazymod.block.entity.*;

public class ModBlockEntityTypes {
    public static final BlockEntityType<FurnaceCatalystEntity> FURNACE_CATALYST =
            RegisterBlockEntityType("furnace_catalyst_entity",
                FurnaceCatalystEntity::new,
                ModBlocks.FURNACE_CATALYST);
    public static final BlockEntityType<DenseFurnaceCatalystEntity> DENSE_FURNACE_CATALYST =
            RegisterBlockEntityType("dense_furnace_catalyst_entity",
                DenseFurnaceCatalystEntity::new,
                ModBlocks.DENSE_FURNACE_CATALYST);
    public static final BlockEntityType<IronFurnaceCatalystEntity> IRON_FURNACE_CATALYST =
            RegisterBlockEntityType("iron_furnace_catalyst_entity",
                    IronFurnaceCatalystEntity::new,
                    ModBlocks.IRON_FURNACE_CATALYST);
    public static final BlockEntityType<DenseIronFurnaceCatalystEntity> DENSE_IRON_FURNACE_CATALYST =
            RegisterBlockEntityType("dense_iron_furnace_catalyst_entity",
                    DenseIronFurnaceCatalystEntity::new,
                    ModBlocks.DENSE_IRON_FURNACE_CATALYST);
    public static final BlockEntityType<FurnaceEfficiencyEnhancerEntity> FURNACE_EFFICIENCER =
            RegisterBlockEntityType("furnace_efficiency_enhancer_entity",
                FurnaceEfficiencyEnhancerEntity::new,
                ModBlocks.FURNACE_EFFICIENCY_ENHANCER);
    public static final BlockEntityType<DenseFurnaceEfficiencyEnhancerEntity> DENSE_FURNACE_EFFICIENCER =
            RegisterBlockEntityType("dense_furnace_efficiency_enhancer_entity",
                DenseFurnaceEfficiencyEnhancerEntity::new,
                ModBlocks.DENSE_FURNACE_EFFICIENCY_ENHANCER);
    public static final BlockEntityType<SaplingAcceleratorEntity> SAPLING_ACCELERATOR =
            RegisterBlockEntityType("sapling_accelerator_entity",
                    SaplingAcceleratorEntity::new,
                    ModBlocks.SAPLING_ACCELERATOR);
    public static final BlockEntityType<DenseSaplingAcceleratorEntity> DENSE_SAPLING_ACCELERATOR =
            RegisterBlockEntityType("dense_sapling_accelerator_entity",
                    DenseSaplingAcceleratorEntity::new,
                    ModBlocks.DENSE_SAPLING_ACCELERATOR);
    public static final BlockEntityType<HopperAcceleratorEntity> HOPPER_ACCELERATOR =
            RegisterBlockEntityType("hopper_accelerator_entity",
                    HopperAcceleratorEntity::new,
                    ModBlocks.HOPPER_ACCELERATOR);

    private static <T extends BlockEntity> BlockEntityType<T> RegisterBlockEntityType(String name, FabricBlockEntityTypeBuilder.Factory<T> factory, net.minecraft.block.Block block){
        return Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(CrazyMod.MOD_ID, name),
                FabricBlockEntityTypeBuilder.create(factory, block).build());
    }
    public static void Initialize() {}
}
