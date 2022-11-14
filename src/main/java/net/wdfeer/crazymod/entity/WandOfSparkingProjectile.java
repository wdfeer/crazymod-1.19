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
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class WandOfSparkingProjectile extends ProjectileEntity {
    public WandOfSparkingProjectile(LivingEntity owner, World world){
        super(ModEntityTypes.WAND_OF_SPARKING, world);
        this.setOwner(owner);
    }
    public WandOfSparkingProjectile(EntityType<WandOfSparkingProjectile> type, World world) {
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
        entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), 4f);
        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.setOnFireFor(10);
        }
    }
    @Override
    public void tick() {
        super.tick();

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
        this.setVelocity(vec3d.multiply(0.95f));
        if (!this.hasNoGravity()) {
            Vec3d vec3d2 = this.getVelocity();
            this.setVelocity(vec3d2.x, vec3d2.y - 0.01f, vec3d2.z);
        }
        this.setPosition(d, e, f);


        if (world.isClient)
            world.addParticle(ParticleTypes.FLAME, getX(), getY(), getZ(),0,0,0);
        else {
            if (this.isTouchingWater()){
                this.kill();
            }
        }
    }
    @Override
    public void checkDespawn() {
        if (!world.isClient && this.age > 20)
            this.kill();
    }


    @Override
    protected void initDataTracker() {}
}
