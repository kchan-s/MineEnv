package com.example.examplemod.mc_15_tobisuke;

import com.example.examplemod.ExampleMod;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TobisukePatternLayer extends RenderLayer<EntityTobisuke2, EntityModel<EntityTobisuke2>> {
    private final ModelOriginalTobisuke<EntityTobisuke2> modelA;
    private final ModelTobisukeWing<EntityTobisuke2> modelB;

    public static final ModelLayerLocation modelLayerLocation1 =
            new ModelLayerLocation(new ResourceLocation(ExampleMod.MODID, "tobisuke_original"), "tobisuke_original");
    public static final ModelLayerLocation modelLayerLocation2 =
            new ModelLayerLocation(new ResourceLocation(ExampleMod.MODID, "tobisuke_wing"), "tobisuke_wing");


    public TobisukePatternLayer(RenderLayerParent<EntityTobisuke2, EntityModel<EntityTobisuke2>> entityModel, EntityModelSet entityModelSet) {
        super(entityModel);
        this.modelA = new ModelOriginalTobisuke<>(entityModelSet.bakeLayer(modelLayerLocation1));
        this.modelB = new ModelTobisukeWing<>(entityModelSet.bakeLayer(modelLayerLocation2));
    }

    public void render(PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight, EntityTobisuke2 pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        EntityModel<EntityTobisuke2> entityModel = (pLivingEntity.getBaseVariant() == 0 ? this.modelA : this.modelB);
        renderColoredCutoutModel(entityModel, pLivingEntity.getBaseTextureLocation(), pMatrixStack, pBuffer, pPackedLight, pLivingEntity,1.0f, 1.0f, 1.0f);
    }
}