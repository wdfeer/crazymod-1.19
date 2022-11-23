package net.wdfeer.crazymod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;

public class EmeraldStaffProjectile extends StaffProjectile {
    public EmeraldStaffProjectile(LivingEntity owner, World world) {
        super(ModEntityTypes.EMERALD_STAFF, owner, world);
    }
    public EmeraldStaffProjectile(EntityType<EmeraldStaffProjectile> type, World world) {
        super(type, world);
    }

    @Override
    public float getDamage() {
        return 13f;
    }

    @Override
    public int getExtraTicks() {
        return 3;
    }

    @Override
    public void visualTick() {
        spawnParticleWithRandomVelocity(ParticleTypes.HAPPY_VILLAGER, world, getPos(), 4f);
    }
}
