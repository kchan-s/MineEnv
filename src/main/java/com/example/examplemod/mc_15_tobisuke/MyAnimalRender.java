package com.example.examplemod.mc_15_tobisuke;

import com.example.examplemod.ExampleMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MyAnimalRender extends MobRenderer<MyAnimalEntity, MyAnimalModel<MyAnimalEntity>> {

    private static final ResourceLocation myAnimalTexture =
            new ResourceLocation(ExampleMod.MODID, "textures/entity/my_animal.png");

    public static final ModelLayerLocation modelLayerLocation =
            new ModelLayerLocation(new ResourceLocation(ExampleMod.MODID, "my_animal"), "my_animal");

    public MyAnimalRender(EntityRendererProvider.Context context) {
        super(context, new MyAnimalModel<>(context.bakeLayer(modelLayerLocation)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(MyAnimalEntity entity) {
        return myAnimalTexture;
    }
}
