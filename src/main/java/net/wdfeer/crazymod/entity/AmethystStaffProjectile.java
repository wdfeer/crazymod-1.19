package net.wdfeer.crazymod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;

public class AmethystStaffProjectile extends StaffProjectile {
    public AmethystStaffProjectile(LivingEntity owner, World world) {
        super(ModEntityTypes.AMETHYST_STAFF, owner, world);
    }
    public AmethystStaffProjectile(EntityType<AmethystStaffProjectile> type, World world) {
        super(type, world);
    }

    @Override
    public float getDamage() {
        return 10f;
    }

    @Override
    public int getExtraTicks() {
        return 3;
    }

    @Override
    public void visualTick() {
        spawnParticleWithRandomVelocity(ParticleTypes.DRAGON_BREATH, world, getPos(), 1);
    }
}
