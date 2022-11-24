package net.wdfeer.crazymod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.wdfeer.crazymod.entity.EmeraldStaffProjectile;
import net.wdfeer.crazymod.entity.StaffProjectile;

public class EmeraldStaff extends StaffItem {
    public EmeraldStaff() {
        super(256);
    }

    @Override
    public int getCooldown() {
        return 17;
    }

    @Override
    public StaffProjectile createProjectile(World world, PlayerEntity user) {
        return new EmeraldStaffProjectile(user, world);
    }

    @Override
    public float getProjectileSpeed() {
        return 0.55f;
    }
}
