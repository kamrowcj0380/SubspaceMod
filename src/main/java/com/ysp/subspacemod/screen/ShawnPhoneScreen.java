package com.ysp.subspacemod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.ysp.subspacemod.SubspaceMod;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

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
        this.addRenderableWidget(new Button(1, 1, 50, 50, Component.literal("Look at memes"), (p_93726_) -> this.lookAtMemes()));

    }

    public void lookAtMemes(){
        try{
            Desktop.getDesktop().browse(new URI("https://reddit.com"));
        } catch (IOException | URISyntaxException e) {
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
