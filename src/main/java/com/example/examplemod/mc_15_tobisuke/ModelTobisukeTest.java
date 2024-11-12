package com.example.examplemod.mc_15_tobisuke;// Made with Blockbench 4.8.1
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

public class ModelTobisukeTest<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "tobisuketest"), "main");
	private final ModelPart head;
	private final ModelPart arm_R;
	private final ModelPart arm_L;
	private final ModelPart body;

	public ModelTobisukeTest(ModelPart root) {
		this.head = root.getChild("head");
		this.arm_R = root.getChild("arm_R");
		this.arm_L = root.getChild("arm_L");
		this.body = root.getChild("body");
	}

	public static LayerDefinition createLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

//		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(-5, -5).addBox(-3.0F, -11.0F, -7.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 0).addBox(-1.5F, -7.0F, -8.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
//
//		PartDefinition arm_R = partdefinition.addOrReplaceChild("arm_R", CubeListBuilder.create().texOffs(-7, -7).addBox(4.5F, -5.0F, -7.0F, 1.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
//
//		PartDefinition arm_L = partdefinition.addOrReplaceChild("arm_L", CubeListBuilder.create().texOffs(-7, -7).addBox(-5.5F, -5.0F, -7.0F, 1.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
//
//		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(-11, -11).addBox(-4.5F, -6.0F, -7.5F, 9.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -6.0F, -7.5F, 9.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition arm_L = partdefinition.addOrReplaceChild("arm_L", CubeListBuilder.create().texOffs(26, 18).addBox(-5.5F, -5.0F, -7.0F, 1.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition arm_R = partdefinition.addOrReplaceChild("arm_R", CubeListBuilder.create().texOffs(16, 22).addBox(4.5F, -5.0F, -7.0F, 1.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -7.0F, -8.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 18).addBox(-3.0F, -11.0F, -7.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		arm_R.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		arm_L.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}