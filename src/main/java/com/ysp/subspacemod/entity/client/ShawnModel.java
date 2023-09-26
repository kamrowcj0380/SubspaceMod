package com.ysp.subspacemod.entity.client;

import com.ysp.subspacemod.SubspaceMod;
import com.ysp.subspacemod.entity.custom.ShawnEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.resources.ResourceLocation;

public class ShawnModel extends HumanoidModel<ShawnEntity> {
    public static final String BODY = "body";
    public static ModelLayerLocation SHAWN_LAYER = new ModelLayerLocation(new ResourceLocation(SubspaceMod.MOD_ID, "shawn"), BODY);

    public static LayerDefinition createBodyLayer(){
        MeshDefinition meshDefinition = createMesh(CubeDeformation.NONE, 0.6f);
        return LayerDefinition.create(meshDefinition, 64, 32);
    }
    public ShawnModel(ModelPart part) {
        super(part);
    }
}
