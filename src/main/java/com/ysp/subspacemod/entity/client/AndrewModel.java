package com.ysp.subspacemod.entity.client;

import com.ysp.subspacemod.SubspaceMod;
import com.ysp.subspacemod.entity.custom.AndrewEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.resources.ResourceLocation;

public class AndrewModel extends HumanoidModel<AndrewEntity> {
    public static final String BODY = "body";
    public static ModelLayerLocation ANDREW_LAYER = new ModelLayerLocation(new ResourceLocation(SubspaceMod.MOD_ID, "andrew"), BODY);

    public static LayerDefinition createBodyLayer(){
        MeshDefinition meshDefinition = createMesh(CubeDeformation.NONE, 0.6f);
        return LayerDefinition.create(meshDefinition, 64, 32);
    }
    public AndrewModel(ModelPart part) {
        super(part);
    }
}
