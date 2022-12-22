package net.wdfeer.crazymod.block.entity;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.wdfeer.crazymod.block.ImplementedInventory;
import net.wdfeer.crazymod.ui.FueledBlockTickerScreenHandler;

public abstract class FueledBlockTickerEntity extends BlockTickerEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    public FueledBlockTickerEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    int fuelTime = 0;
    boolean canTick(){
        if (fuelTime <= 0){
            ItemStack stack = inventory.get(0);
            if (stack.isEmpty()) return false;

            int fuelTime = FuelRegistry.INSTANCE.get(stack.getItem());
            if (fuelTime > 0){
                stack.decrement(1);
                this.fuelTime += fuelTime;
                return true;
            } else return false;
        } else return true;
    }
    public static void tick(World world, BlockPos thisPos, BlockState thisState, FueledBlockTickerEntity instance){
        if (instance.canTick()) {
            instance.fuelTime--;
            BlockTickerEntity.tick(world, thisPos, thisState, instance);
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
        return new FueledBlockTickerScreenHandler(syncId, playerInventory, this);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, this.inventory);
        fuelTime = nbt.getInt("fuelTime");
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, this.inventory);
        nbt.putInt("fuelTime", fuelTime);
    }
}
