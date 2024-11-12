package com.example.examplemod.mc_15_tobisuke;

import com.example.examplemod.ExampleMod;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TobisukeRenderer extends MobRenderer<EntityTobisuke2, EntityModel<EntityTobisuke2>> {
    private final EntityModel<EntityTobisuke2> modelA = this.getModel();
    private final EntityModel<EntityTobisuke2> modelB;

    public static final ModelLayerLocation modelLayerLocation1 =
            new ModelLayerLocation(new ResourceLocation(ExampleMod.MODID, "tobisuke_original"), "tobisuke_original");
    public static final ModelLayerLocation modelLayerLocation2 =
            new ModelLayerLocation(new ResourceLocation(ExampleMod.MODID, "tobisuke_wing"), "tobisuke_wing");

    public TobisukeRenderer(EntityRendererProvider.Context context) {
        super(context, new ModelOriginalTobisuke<>(context.bakeLayer(modelLayerLocation1)), 0.5F);
        this.modelB = new ModelTobisukeWing<>(context.bakeLayer(modelLayerLocation2));
        this.addLayer(new TobisukePatternLayer(this, context.getModelSet()));
    }

    public ResourceLocation getTextureLocation(EntityTobisuke2 entity) {
        return entity.getBaseTextureLocation();
    }

    public void render(EntityTobisuke2 pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        this.model = pEntity.getBaseVariant() == 0 ? this.modelA : this.modelB;
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
