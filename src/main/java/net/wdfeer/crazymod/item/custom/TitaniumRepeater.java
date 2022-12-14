package net.wdfeer.crazymod.item.custom;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;
import net.wdfeer.crazymod.item.ModItems;
import net.wdfeer.crazymod.toolmaterial.TitaniumMaterial;

public class TitaniumRepeater extends BowItem {
    public TitaniumRepeater() {
        super(new FabricItemSettings().fireproof().group(ItemGroup.COMBAT).maxDamage(TitaniumMaterial.INSTANCE.getDurability()));
    }
    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }
    @Override
    public int getEnchantability() {
        return TitaniumMaterial.INSTANCE.getEnchantability();
    }
    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(ModItems.TITANIUM_INGOT);
    }
    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        float charge;
        if (!(user instanceof PlayerEntity player)) {
            return;
        }
        if ((charge = TitaniumRepeater.getPullProgress(this.getMaxUseTime(stack) - remainingUseTicks)) < 1f) {
            return;
        }
        shoot(stack, world, player, charge);
        if (!player.getAbilities().creativeMode)
            stack.damage(1, user, e -> e.sendToolBreakStatus(user.preferredHand));
        user.stopUsingItem();
    }
    @Override
    public boolean isUsedOnRelease(ItemStack stack) {
        return false;
    }
    void shoot(ItemStack stack, World world, PlayerEntity player, float charge){
        float damageMult = 0.85f;
        boolean infiniteAmmo = player.getAbilities().creativeMode || EnchantmentHelper.getLevel(Enchantments.INFINITY, stack) > 0;
        ItemStack arrowStack = player.getArrowType(stack);
        if (arrowStack.isEmpty() && !infiniteAmmo) {
            return;
        }
        if (arrowStack.isEmpty()) {
            arrowStack = new ItemStack(Items.ARROW);
        }
        boolean bl2 = infiniteAmmo && arrowStack.isOf(Items.ARROW);
        if (!world.isClient) {
            int k;
            ArrowItem arrowItem = (ArrowItem)(arrowStack.getItem() instanceof ArrowItem ? arrowStack.getItem() : Items.ARROW);
            PersistentProjectileEntity projectile = arrowItem.createArrow(world, arrowStack, player);
            projectile.setDamage(projectile.getDamage() * damageMult);
            projectile.setVelocity(player, player.getPitch(), player.getYaw(), 0.0f, 2.25f, 1.0f);
            projectile.setCritical(true);
            int powerLvl;
            if ((powerLvl = EnchantmentHelper.getLevel(Enchantments.POWER, stack)) > 0) {
                projectile.setDamage(projectile.getDamage() + (double)powerLvl * 0.5 + 0.5);
            }
            if ((k = EnchantmentHelper.getLevel(Enchantments.PUNCH, stack)) > 0) {
                projectile.setPunch(k);
            }
            if (EnchantmentHelper.getLevel(Enchantments.FLAME, stack) > 0) {
                projectile.setOnFireFor(100);
            }
            stack.damage(1, player, p -> p.sendToolBreakStatus(player.getActiveHand()));
            if (bl2 || player.getAbilities().creativeMode && (arrowStack.isOf(Items.SPECTRAL_ARROW) || arrowStack.isOf(Items.TIPPED_ARROW))) {
                projectile.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
            }
            world.spawnEntity(projectile);
        }
        world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0f, 1.0f / (world.getRandom().nextFloat() * 0.4f + 1.2f) + charge * 0.5f);
        if (!bl2 && !player.getAbilities().creativeMode) {
            arrowStack.decrement(1);
            if (arrowStack.isEmpty()) {
                player.getInventory().removeOne(arrowStack);
            }
        }
        player.incrementStat(Stats.USED.getOrCreateStat(this));
    }
    public static float getPullProgress(int useTicks) {
        float progress = (float)useTicks / 10f;
        if ((progress = (progress * progress + progress * 2.0f) / 3.0f) > 1.0f) {
            progress = 1.0f;
        }
        return progress;
    }
    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 24000;
    }
    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {}
}
