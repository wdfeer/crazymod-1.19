package net.wdfeer.crazymod.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.EndGatewayBlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class AmethystStaffProjectile extends ProjectileEntity {
    public AmethystStaffProjectile(LivingEntity owner, World world){
        super(ModEntityTypes.AMETHYST_STAFF, world);
        this.setOwner(owner);
    }
    public AmethystStaffProjectile(EntityType<AmethystStaffProjectile> type, World world) {
        super(type, world);
    }

    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.world.isClient) {
            this.kill();
        }
    }
    @Override
    protected boolean canHit(Entity entity) {
        return !isOwner(entity);
    }
    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), 10f);
    }
    @Override
    public void tick() {
        super.tick();
        for (int i = 0; i < 4; i++) {
            // From net.minecraft.entity.projectile.thrown.ThrownEntity.java
            HitResult hitResult = ProjectileUtil.getCollision(this, this::canHit);
            boolean bl = false;
            if (hitResult.getType() == HitResult.Type.BLOCK) {
                BlockPos blockPos = ((BlockHitResult)hitResult).getBlockPos();
                BlockState blockState = this.world.getBlockState(blockPos);
                if (blockState.isOf(Blocks.NETHER_PORTAL)) {
                    this.setInNetherPortal(blockPos);
                    bl = true;
                } else if (blockState.isOf(Blocks.END_GATEWAY)) {
                    BlockEntity blockEntity = this.world.getBlockEntity(blockPos);
                    if (blockEntity instanceof EndGatewayBlockEntity && EndGatewayBlockEntity.canTeleport(this)) {
                        EndGatewayBlockEntity.tryTeleportingEntity(this.world, blockPos, blockState, this, (EndGatewayBlockEntity)blockEntity);
                    }
                    bl = true;
                }
            }
            if (hitResult.getType() != HitResult.Type.MISS && !bl) {
                this.onCollision(hitResult);
            }
            this.checkBlockCollision();
            Vec3d vec3d = this.getVelocity();
            double d = this.getX() + vec3d.x;
            double e = this.getY() + vec3d.y;
            double f = this.getZ() + vec3d.z;
            this.updateRotation();
            this.setPosition(d, e, f);


            if (world.isClient){
                spawnParticleWithRandomVelocity(ParticleTypes.DRAGON_BREATH, world, getPos(), 1);
            }
        }
    }
    public static void spawnParticleWithRandomVelocity(ParticleEffect type, World world, Vec3d pos, float velocityScale){
        float vx = (world.random.nextFloat() - 0.5f) / 15f * velocityScale;
        float vy = (world.random.nextFloat() - 0.5f) / 15f * velocityScale;
        float vz = (world.random.nextFloat() - 0.5f) / 15f * velocityScale;
        world.addParticle(type, pos.x, pos.y, pos.z, vx, vy, vz);
    }
    @Override
    protected float getVelocityMultiplier() {
        return super.getVelocityMultiplier();
    }

    @Override
    public void checkDespawn() {
        if (!world.isClient && this.age > 60)
            this.kill();
    }


    @Override
    protected void initDataTracker() {}
}
