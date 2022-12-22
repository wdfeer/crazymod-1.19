package net.wdfeer.crazymod.ui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.wdfeer.crazymod.CrazyMod;

public class FueledBlockTickerScreen extends HandledScreen<FueledBlockTickerScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(CrazyMod.MOD_ID, "textures/gui/container/fueled_block_ticker.png");
        
    public FueledBlockTickerScreen(FueledBlockTickerScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
        
    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);

        if (handler.getFuelProgressPercent() > 0) {
            int percent = handler.getFuelProgressPercent();
            int burn = 12 * percent / 100;
            this.drawTexture(matrices, this.x + 81, this.y + 55 + 12 - burn, 176, 12 - burn, 14, burn + 1);
        }
    }
        
    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }
        
    @Override
    protected void init() {
        super.init();
        // Center the title
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }
}

