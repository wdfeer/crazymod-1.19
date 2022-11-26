package net.wdfeer.crazymod.item.custom;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.wdfeer.crazymod.toolmaterial.CopperMaterial;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CopperBow extends BowItem {
    public CopperBow() {
        super(new FabricItemSettings().group(ItemGroup.COMBAT).maxDamage(CopperMaterial.INSTANCE.getDurability()));
    }
    public final float FREE_SHOT_CHANCE = 0.75f;
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        TitaniumDrill.addTooltipLine(tooltip, (int)(FREE_SHOT_CHANCE * 100f) + "% chance not to consume ammo", Formatting.GRAY);
    }
    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(Items.COPPER_INGOT);
    }
    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        float charge;
        if (!(user instanceof PlayerEntity player)) {
            return;
        }
        if ((charge = CopperBow.getPullProgress(this.getMaxUseTime(stack) - remainingUseTicks)) < 0.25f) {
            return;
        }
        shoot(stack, world, (PlayerEntity) user, charge);
        if (!player.getAbilities().creativeMode)
            stack.damage(1, user, e -> e.sendToolBreakStatus(user.preferredHand));
    }
    void shoot(ItemStack stack, World world, PlayerEntity player, float charge){
        float damageMult = 0.8f * charge;
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
            boolean freeShot = bl2 ||
                    (player.getAbilities().creativeMode &&
                            (arrowStack.isOf(Items.SPECTRAL_ARROW) || arrowStack.isOf(Items.TIPPED_ARROW))) ||
                    Random.create().nextFloat() < FREE_SHOT_CHANCE;
            if (!freeShot){
                arrowStack.decrement(1);
                if (arrowStack.isEmpty()) {
                    player.getInventory().removeOne(arrowStack);
                }
            }

            int k;
            ArrowItem arrowItem = (ArrowItem)(arrowStack.getItem() instanceof ArrowItem ? arrowStack.getItem() : Items.ARROW);
            PersistentProjectileEntity projectile = arrowItem.createArrow(world, arrowStack, player);
            projectile.setDamage(projectile.getDamage() * damageMult);
            projectile.setVelocity(player, player.getPitch(), player.getYaw(), 0.0f, 2f * (0.4f + charge * 0.6f), 1.0f);
            int powerLvl;
            if ((powerLvl = EnchantmentHelper.getLevel(Enchantments.POWER, stack)) > 0) {
                projectile.setDamage(projectile.getDamage() + (double)powerLvl * 0.75 + 0.25);
            }
            if ((k = EnchantmentHelper.getLevel(Enchantments.PUNCH, stack)) > 0) {
                projectile.setPunch(k);
            }
            if (EnchantmentHelper.getLevel(Enchantments.FLAME, stack) > 0) {
                projectile.setOnFireFor(100);
            }
            stack.damage(1, player, p -> p.sendToolBreakStatus(player.getActiveHand()));
            if (freeShot){
                projectile.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
            }
            world.spawnEntity(projectile);
        }
        world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0f, 1.0f / (world.getRandom().nextFloat() * 0.4f + 1.2f) + charge * 0.5f);
        player.incrementStat(Stats.USED.getOrCreateStat(this));
    }
    public static float getPullProgress(int useTicks) {
        float progress = (float)useTicks / 15f;
        if (progress > 1.0f) {
            progress = 1.0f;
        }
        return progress;
    }
    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 48000;
    }

}
