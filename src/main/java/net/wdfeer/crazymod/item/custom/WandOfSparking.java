package net.wdfeer.crazymod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.wdfeer.crazymod.entity.StaffProjectile;
import net.wdfeer.crazymod.entity.WandOfSparkingProjectile;

public class WandOfSparking extends StaffItem {
    public WandOfSparking() {
        super(32);
    }

    @Override
    public int getCooldown() {
        return 13;
    }
    @Override
    public StaffProjectile createProjectile(World world, PlayerEntity user) {
        WandOfSparkingProjectile projectile = new WandOfSparkingProjectile(user, world);
        projectile.setOnFireFor(999999);
        return projectile;
    }
    @Override
    public float getProjectileSpeed() {
        return 0.4f;
    }
}
