package com.example.examplemod.mc_101_different_color;// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class ModelGhost<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "modelghost"), "main");
    private final ModelPart body;

    public ModelGhost(ModelPart root) {
        this.body = root.getChild("body");
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -13.0F, 0.0F, 12.0F, 10.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(30, 17).addBox(-5.0F, -15.0F, 0.0F, 8.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(30, 24).addBox(-4.0F, -16.0F, 0.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 30).addBox(-6.0F, -3.0F, 0.0F, 12.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 23).addBox(-5.0F, -2.0F, 0.0F, 12.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 16).addBox(-4.0F, -1.0F, 0.0F, 12.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(30, 10).addBox(-6.0F, -14.0F, 0.0F, 10.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}