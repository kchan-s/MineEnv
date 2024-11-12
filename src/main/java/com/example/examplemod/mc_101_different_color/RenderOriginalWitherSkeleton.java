package com.example.examplemod.mc_101_different_color;

import com.example.examplemod.ExampleMod;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.WitherSkeletonRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.AbstractSkeleton;

public class RenderOriginalWitherSkeleton extends WitherSkeletonRenderer {
    private static ResourceLocation originalWitherSkeletonTexture
            = new ResourceLocation(ExampleMod.MODID, "textures/entity/original_wither_skeleton.png");

    public RenderOriginalWitherSkeleton(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(AbstractSkeleton entity) {
        return originalWitherSkeletonTexture;
    }
}
