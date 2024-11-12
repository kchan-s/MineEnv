package com.example.examplemod.mc_101_different_color;

import com.example.examplemod.ExampleMod;
import net.minecraft.client.renderer.entity.CatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Cat;

public class RenderOriginalCat extends CatRenderer {
    private static ResourceLocation originalCatTexture
            = new ResourceLocation(ExampleMod.MODID, "textures/entity/original_cat.png");

    public RenderOriginalCat(EntityRendererProvider.Context context) {
        super((context));
    }

    @Override
    public ResourceLocation getTextureLocation(Cat entity) {
        return originalCatTexture;
    }
}
