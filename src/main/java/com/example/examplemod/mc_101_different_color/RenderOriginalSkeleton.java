package com.example.examplemod.mc_101_different_color;

import com.example.examplemod.ExampleMod;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.AbstractSkeleton;

public class RenderOriginalSkeleton extends SkeletonRenderer {
    private static ResourceLocation originalSkeletonTexture
            = new ResourceLocation(ExampleMod.MODID, "textures/entity/original_skeleton.png");

    public RenderOriginalSkeleton(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(AbstractSkeleton entity) {
        return originalSkeletonTexture;
    }
}
