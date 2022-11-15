package net.wdfeer.crazymod.item.custom;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.wdfeer.crazymod.entity.AmethystStaffProjectile;

public class AmethystStaff extends Item {
    public AmethystStaff() {
        super(new FabricItemSettings().group(ItemGroup.COMBAT).maxDamage(360));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        var stack = user.getStackInHand(hand);
        if(!world.isClient()) {
            user.getItemCooldownManager().set(this, 25);
            var projectile = new AmethystStaffProjectile(user, world);
            projectile.setOwner(user);
            projectile.setPosition(user.getEyePos());
            projectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 0.5f, 0.2f);
            world.spawnEntity(projectile);
            stack.damage(1, user, (e) -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        }
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        return TypedActionResult.success(stack);
    }
}
