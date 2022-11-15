package net.wdfeer.crazymod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EmptyEntityRenderer;
import net.wdfeer.crazymod.entity.ModEntityTypes;

public class CrazyClientMod implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(ModEntityTypes.WAND_OF_SPARKING, EmptyEntityRenderer::new);
		EntityRendererRegistry.register(ModEntityTypes.AMETHYST_STAFF, EmptyEntityRenderer::new);
	}
}