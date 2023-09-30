package com.ysp.subspacemod.entity.client;

import com.ysp.subspacemod.SubspaceMod;
import com.ysp.subspacemod.entity.custom.AndrewEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public class AndrewRenderer extends HumanoidMobRenderer<AndrewEntity, AndrewModel> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(SubspaceMod.MOD_ID, "textures/entity/andrew.png");

    public AndrewRenderer(EntityRendererProvider.Context context) {
        super(context, new AndrewModel(context.bakeLayer(AndrewModel.ANDREW_LAYER)), 1f);
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation (AndrewEntity entity){
        return TEXTURE;
    }
}
