package net.wdfeer.crazymod;

import net.fabricmc.api.ModInitializer;

import net.wdfeer.crazymod.block.ModBlocks;
import net.wdfeer.crazymod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrazyMod implements ModInitializer {
	public static final String MOD_ID = "crazymod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.Initialize();
		ModBlocks.Initialize();
	}
}