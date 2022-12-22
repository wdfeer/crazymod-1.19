package net.wdfeer.crazymod.ui;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.wdfeer.crazymod.CrazyMod;

public class Screens {
    public static ScreenHandlerType<FueledBlockTickerScreenHandler> FUELED_BLOCK_TICKER_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier(CrazyMod.MOD_ID, "fueled_block_ticker"),
                    FueledBlockTickerScreenHandler::new);
    public static void Initialize(){}
    public static void InitializeClient() {
        HandledScreens.register(FUELED_BLOCK_TICKER_SCREEN_HANDLER, FueledBlockTickerScreen::new);
    }
}
