package com.example.examplemod.mc_101_different_color;

import com.example.examplemod.ExampleMod;
import net.minecraft.client.renderer.entity.CreeperRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Creeper;

public class RenderOriginalCreeper extends CreeperRenderer {
    public static ResourceLocation originalCreeperTexture
            = new ResourceLocation(ExampleMod.MODID, "textures/entity/original_creeper.png");

    public RenderOriginalCreeper(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(Creeper entity) {
        return originalCreeperTexture;
    }
}
