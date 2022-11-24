package net.wdfeer.crazymod.item.custom;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.wdfeer.crazymod.entity.StaffProjectile;
import net.wdfeer.crazymod.util.ModSounds;

public abstract class StaffItem extends Item {
    public StaffItem(int durability) {
        super(new FabricItemSettings().group(ItemGroup.COMBAT).maxDamage(durability));
    }
    public abstract int getCooldown();
    public abstract StaffProjectile createProjectile(World world, PlayerEntity user);
    public abstract float getProjectileSpeed();
    public float getDivergence() { return 1f; }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        var stack = user.getStackInHand(hand);
        if(!world.isClient()) {
            user.getItemCooldownManager().set(this, getCooldown());
            var projectile = createProjectile(world, user);
            projectile.setOwner(user);
            projectile.setPosition(user.getEyePos());
            projectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, getProjectileSpeed(), getDivergence());
            world.spawnEntity(projectile);
            stack.damage(1, user, (e) -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));

            world.playSound(null,
                    user.getBlockPos(),
                    ModSounds.MAGIC_STAFF_SOUND_EVENT,
                    SoundCategory.PLAYERS,
                    1f,
                    1f);
        }
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        return TypedActionResult.success(stack);
    }
}
