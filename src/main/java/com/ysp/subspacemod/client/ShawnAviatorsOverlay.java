package com.ysp.subspacemod.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.ysp.subspacemod.SubspaceMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class ShawnAviatorsOverlay implements IGuiOverlay {

    public static final ResourceLocation SHAWN_AVIATORS_OVERLAY_LOCATION = new ResourceLocation(SubspaceMod.MOD_ID, "textures/misc/shawn_aviators_overlay");

    @Override
    public void render(ForgeGui gui, PoseStack poseStack, float partialTick, int screenWidth, int screenHeight) {
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, SHAWN_AVIATORS_OVERLAY_LOCATION);
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.vertex(0.0D, (double)screenHeight, -90.0D).uv(0.0F, 1.0F).endVertex();
        bufferbuilder.vertex((double)screenWidth, (double)screenHeight, -90.0D).uv(1.0F, 1.0F).endVertex();
        bufferbuilder.vertex((double)screenWidth, 0.0D, -90.0D).uv(1.0F, 0.0F).endVertex();
        bufferbuilder.vertex(0.0D, 0.0D, -90.0D).uv(0.0F, 0.0F).endVertex();
        tesselator.end();
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    }
}
