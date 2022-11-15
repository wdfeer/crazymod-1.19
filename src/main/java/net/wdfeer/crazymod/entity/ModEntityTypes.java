package net.wdfeer.crazymod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.wdfeer.crazymod.CrazyMod;

public class ModEntityTypes {
    public static final EntityType<WandOfSparkingProjectile> WAND_OF_SPARKING = register("wand_of_sparking_projectile",
            FabricEntityTypeBuilder.<WandOfSparkingProjectile>create(SpawnGroup.MISC, WandOfSparkingProjectile::new)
                    .dimensions(EntityDimensions.fixed(0.35F, 0.35F)));
    public static final EntityType<AmethystStaffProjectile> AMETHYST_STAFF = register("amethyst_staff_projectile",
            FabricEntityTypeBuilder.<AmethystStaffProjectile>create(SpawnGroup.MISC, AmethystStaffProjectile::new)
                    .dimensions(EntityDimensions.fixed(0.35F, 0.35F)));
    public static <T extends Entity> EntityType<T> register(String id, FabricEntityTypeBuilder<T> type) {
        return Registry.register(Registry.ENTITY_TYPE, new Identifier(CrazyMod.MOD_ID, id), type.build());
    }
    public static void Initialize(){}
}
