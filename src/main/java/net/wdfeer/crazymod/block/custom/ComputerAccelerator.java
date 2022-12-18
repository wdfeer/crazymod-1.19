package net.wdfeer.crazymod.block.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.wdfeer.crazymod.block.BlockData;
import net.wdfeer.crazymod.block.BlockModelType;
import net.wdfeer.crazymod.block.ModBlockEntityTypes;
import net.wdfeer.crazymod.block.ModBlocks;
import net.wdfeer.crazymod.block.entity.AdvancedComputerAcceleratorEntity;
import net.wdfeer.crazymod.block.entity.ComputerAcceleratorEntity;
import net.wdfeer.crazymod.util.TextLine;
import org.jetbrains.annotations.Nullable;

public class ComputerAccelerator extends ModBlockWithEntity {
    protected ComputerAccelerator() {
        super(FabricBlockSettings.of(Material.STONE).strength(5f, 30f).requiresTool());
    }

    @Override
    public BlockEntityType<? extends ComputerAcceleratorEntity> getBlockEntityType() {
        return blockEntityType;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, getBlockEntityType(), ComputerAcceleratorEntity::tick);
    }

    public static Block instance;
    public static BlockEntityType<ComputerAcceleratorEntity> blockEntityType;
    public static void Initialize(){
        boolean computerCraftLoaded = FabricLoader.getInstance().isModLoaded("computercraft");
        boolean devEnv = FabricLoader.getInstance().isDevelopmentEnvironment();
        if (!computerCraftLoaded && !devEnv)
            return;
        instance = ModBlocks.RegisterBlock("computer_accelerator",
                new ComputerAccelerator(),
                new BlockData(BlockModelType.CubeTopSameBottom),
                ItemGroup.DECORATIONS,
                new TextLine[]{new TextLine("Range: 3x3x3", Formatting.GRAY), new TextLine("Speed: +1x", Formatting.GRAY)});
        blockEntityType = ModBlockEntityTypes.RegisterBlockEntityType("computer_accelerator_entity",
                ComputerAcceleratorEntity::new,
                instance);

        AdvancedComputerAccelerator.instance = ModBlocks.RegisterBlock("advanced_computer_accelerator",
                new AdvancedComputerAccelerator(),
                new BlockData(BlockModelType.CubeTopSameBottom),
                ItemGroup.DECORATIONS,
                new TextLine[]{new TextLine("Range: 5x5x5", Formatting.GRAY), new TextLine("Speed: +2x", Formatting.GRAY)});
        AdvancedComputerAccelerator.blockEntityType = ModBlockEntityTypes.RegisterBlockEntityType("advanced_computer_accelerator_entity",
                AdvancedComputerAcceleratorEntity::new,
                AdvancedComputerAccelerator.instance);
    }
}
