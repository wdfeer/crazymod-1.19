package net.wdfeer.crazymod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.wdfeer.crazymod.entity.AmethystStaffProjectile;
import net.wdfeer.crazymod.entity.StaffProjectile;

public class AmethystStaff extends StaffItem {
    public AmethystStaff() {
        super(120);
    }

    @Override
    public int getCooldown() {
        return 20;
    }

    @Override
    public StaffProjectile createProjectile(World world, PlayerEntity user) {
        return new AmethystStaffProjectile(user, world);
    }

    @Override
    public float getProjectileSpeed() {
        return 0.5f;
    }

    @Override
    public float getDivergence() {
        return 0.2f;
    }
}
