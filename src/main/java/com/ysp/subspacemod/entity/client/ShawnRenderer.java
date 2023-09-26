package com.ysp.subspacemod.entity.client;

import com.ysp.subspacemod.SubspaceMod;
import com.ysp.subspacemod.entity.custom.ShawnEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public class ShawnRenderer extends HumanoidMobRenderer<ShawnEntity, ShawnModel> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(SubspaceMod.MOD_ID, "textures/entity/shawn.png");

    public ShawnRenderer(EntityRendererProvider.Context context) {
        super(context, new ShawnModel(context.bakeLayer(ShawnModel.SHAWN_LAYER)), 1f);
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation (ShawnEntity entity){
        return TEXTURE;
    }
}
