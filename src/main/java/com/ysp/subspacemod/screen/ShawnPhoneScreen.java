package com.ysp.subspacemod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.ysp.subspacemod.SubspaceMod;
import net.minecraft.Util;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ShawnPhoneScreen extends AbstractContainerScreen<ShawnPhoneMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(SubspaceMod.MOD_ID, "textures/gui/shawn_phone_gui.png");

    public ShawnPhoneScreen(ShawnPhoneMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
    }

    @Override
    protected void init() {
        super.init();
        //adds a button
        this.addRenderableWidget(new Button(this.leftPos + 5, this.topPos + 15, imageWidth - 10, imageHeight / 10, Component.literal("Look at memes"), (pOnPress) -> this.lookAtMemes()));
        this.addRenderableWidget(new Button(this.leftPos + 5, this.topPos + 30, imageWidth - 10, imageHeight / 10, Component.literal("Read Manga"), (pOnPress) -> this.readManga()));

    }

    public void lookAtMemes() {
        try {
            if (Util.getPlatform() == Util.OS.WINDOWS) {
                Util.OS.WINDOWS.openUri(new URI("https://reddit.com"));
            }
        } catch(URISyntaxException e){
                throw new RuntimeException(e);
            }
        }


    public void readManga() {
        try {
            if (Util.getPlatform() == Util.OS.WINDOWS) {
                Util.OS.WINDOWS.openUri(new URI("https://www.viz.com/shonenjump"));
            }
        } catch(URISyntaxException e){
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void renderBg(PoseStack stack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0f, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(stack, x, y, 0, 0, imageWidth, imageHeight);
    }

    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, mouseX, mouseY, delta);
        renderTooltip(pPoseStack, mouseX, mouseY);
    }
}
