package net.wdfeer.crazymod.block.entity;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.wdfeer.crazymod.CrazyMod;
import net.wdfeer.crazymod.block.ImplementedInventory;
import net.wdfeer.crazymod.block.custom.FueledBlockTicker;
import net.wdfeer.crazymod.ui.FueledBlockTickerScreenHandler;

public abstract class FueledBlockTickerEntity extends BlockTickerEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    public FueledBlockTickerEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    int fuelTime = 1;
    int burnTime = 0;
    PropertyDelegate burnTimePercentDelegate = new PropertyDelegate() {
        @Override
        public int get(int index) {
            return burnTime * 100 / fuelTime;
        }
        @Override
        public void set(int index, int value) {
            CrazyMod.LOGGER.error("Tried setting the value of burnTimePercentDelegate which is read-only");
        }
        @Override
        public int size() {
            return 1;
        }
    };
    boolean canTick(){
        if (burnTime <= 0){
            ItemStack stack = inventory.get(0);
            if (stack.isEmpty()) return false;

            int fuelTime = FuelRegistry.INSTANCE.get(stack.getItem());
            if (fuelTime > 0){
                stack.decrement(1);
                this.burnTime += fuelTime;
                this.fuelTime = fuelTime;
                this.markDirty();
                return true;
            } else return false;
        } else return true;
    }
    public static void tick(World world, BlockPos pos, BlockState state, FueledBlockTickerEntity instance){
        if (instance.canTick()) {
            BlockTickerEntity.tick(world, pos, state, instance);

            state = state.with(FueledBlockTicker.LIT, instance.burnTime > 0);
            world.setBlockState(pos, state, Block.NOTIFY_ALL);

            instance.burnTime--;
        }
    }

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(1, ItemStack.EMPTY);
    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    //These Methods are from the NamedScreenHandlerFactory Interface
    //createMenu creates the ScreenHandler itself
    //getDisplayName will Provide its name which is normally shown at the top
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        //We provide *this* to the screenHandler as our class Implements Inventory
        //Only the Server has the Inventory at the start, this will be synced to the client in the ScreenHandler
        return new FueledBlockTickerScreenHandler(syncId, playerInventory, this, burnTimePercentDelegate);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, this.inventory);
        burnTime = nbt.getInt("burnTime");
        fuelTime = nbt.getInt("fuelTime");
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, this.inventory);
        nbt.putInt("burnTime", burnTime);
        nbt.putInt("fuelTime", fuelTime);
    }
}
