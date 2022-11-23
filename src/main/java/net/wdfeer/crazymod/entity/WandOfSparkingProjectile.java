package net.wdfeer.crazymod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class WandOfSparkingProjectile extends StaffProjectile {
    public WandOfSparkingProjectile(LivingEntity owner, World world){
        super(ModEntityTypes.WAND_OF_SPARKING, world);
        this.setOwner(owner);
    }
    public WandOfSparkingProjectile(EntityType<WandOfSparkingProjectile> type, World world) {
        super(type, world);
    }

    @Override
    public float getDamage() {
        return 4f;
    }

    @Override
    public int getExtraTicks() {
        return 2;
    }

    @Override
    public void visualTick() {
        spawnParticleWithRandomVelocity(ParticleTypes.FLAME, world, getPos(), 0.5f);
    }

    @Override
    public void postTick() {
        if (!world.isClient && this.touchingWater){
            this.kill();
        }
        if (!this.hasNoGravity()) {
            Vec3d vec3d2 = this.getVelocity();
            this.setVelocity(vec3d2.x, vec3d2.y - 0.0025f, vec3d2.z);
        }
    }
    @Override
    public void onHit(LivingEntity entity) {
        entity.setOnFireFor(10);
    }
    @Override
    public void checkDespawn() {
        if (!world.isClient && this.age > 20)
            this.kill();
    }
}
