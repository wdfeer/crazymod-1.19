package net.wdfeer.crazymod.item.custom;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.wdfeer.crazymod.entity.StaffProjectile;
import net.wdfeer.crazymod.util.ModSounds;

public abstract class StaffItem extends ToolItem {
    public StaffItem(int durability) {
        super(new ToolMaterial() {
            @Override
            public int getDurability() {
                return durability;
            }
            @Override
            public float getMiningSpeedMultiplier() {
                return 0;
            }
            @Override
            public float getAttackDamage() {
                return 0;
            }
            @Override
            public int getMiningLevel() {
                return 0;
            }
            @Override
            public int getEnchantability() {
                return 20;
            }
            @Override
            public Ingredient getRepairIngredient() {
                return null;
            }
        }, new FabricItemSettings().group(ItemGroup.COMBAT));
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
