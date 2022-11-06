package net.wdfeer.crazymod.util;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.wdfeer.crazymod.item.ModItems;
import net.wdfeer.crazymod.item.custom.CopperBow;

import java.util.function.BiFunction;

public class ModModelPredicateProvider {
    public static void registerModModels() {
        registerBow((BowItem)ModItems.COPPER_BOW,
                (stack, entity) -> CopperBow.getPullProgress(stack.getMaxUseTime() - entity.getItemUseTimeLeft()));
    }

    private static void registerBow(BowItem bow, BiFunction<ItemStack, LivingEntity, Float> getCharge) {
        ModelPredicateProviderRegistry.register(bow, new Identifier("pull"),
                (stack, world, entity, seed) -> {
                    if (entity == null) {
                        return 0.0f;
                    }
                    if (entity.getActiveItem() != stack) {
                        return 0.0f;
                    }
                    return getCharge.apply(stack,entity);
                });
        ModelPredicateProviderRegistry.register(bow, new Identifier("pulling"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem()
                        && entity.getActiveItem() == stack ? 1.0f : 0.0f);
    }
}
