package com.example.examplemod.mc_15_tobisuke;

import com.example.examplemod.ExampleMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderTobisuke extends MobRenderer<EntityTobisuke, ModelTobisukeTest<EntityTobisuke>> {
    public static final ResourceLocation[] TOBISUKE_LOCATIONS =
            new ResourceLocation[]{
                    new ResourceLocation(ExampleMod.MODID, "textures/entity/tobisuke_wing.png"),
                    new ResourceLocation(ExampleMod.MODID, "textures/entity/transparent_tobisuke_yellow.png"),
                    new ResourceLocation(ExampleMod.MODID, "textures/entity/transparent_tobisuke_orange.png"),
                    new ResourceLocation(ExampleMod.MODID, "textures/entity/transparent_tobisuke_green.png"),
                    new ResourceLocation(ExampleMod.MODID, "textures/entity/transparent_tobisuke_blue.png"),
                    new ResourceLocation(ExampleMod.MODID, "textures/entity/transparent_tobisuke_purple.png")
            };

    //    private static ResourceLocation tobisukeTexture
//            = new ResourceLocation(ExampleMod.MODID, "textures/entity/transparent_tobisuke_pink.png");
    public static final ModelLayerLocation modelLayerLocation =
            new ModelLayerLocation(new ResourceLocation(ExampleMod.MODID, "tobisuke"), "tobisuke");


    public RenderTobisuke(EntityRendererProvider.Context context) {
        super(context, new ModelTobisukeTest<>(context.bakeLayer(modelLayerLocation)), 0.5f);
    }

    private static int count = 0;
    private static int number = 0;

    @Override
    public ResourceLocation getTextureLocation(EntityTobisuke entity) {
//        if (count != 30) {
//            count++;
//            return tobisukeTexture;
//        } else {
//            switch (number) {
//                case 0:
//                    tobisukeTexture = new ResourceLocation(ExampleMod.MODID, "textures/entity/tobisuke_white.png");
//                    number++;
//                    break;
//                case 1:
//                    tobisukeTexture = new ResourceLocation(ExampleMod.MODID, "textures/entity/tobisuke_pink.png");
//                    number++;
//                    break;
//                case 2:
//                    tobisukeTexture = new ResourceLocation(ExampleMod.MODID, "textures/entity/tobisuke_hpink.png");
//                    number++;
//                    break;
//                case 3:
//                    tobisukeTexture = new ResourceLocation(ExampleMod.MODID, "textures/entity/tobisuke_orange.png");
//                    number++;
//                    break;
//                case 4:
//                    tobisukeTexture = new ResourceLocation(ExampleMod.MODID, "textures/entity/tobisuke_creem.png");
//                    number++;
//                    break;
//                case 5:
//                    tobisukeTexture = new ResourceLocation(ExampleMod.MODID, "textures/entity/tobisuke_rime.png");
//                    number++;
//                    break;
//                case 6:
//                    tobisukeTexture = new ResourceLocation(ExampleMod.MODID, "textures/entity/tobisuke_green.png");
//                    number++;
//                    break;
//                case 7:
//                    tobisukeTexture = new ResourceLocation(ExampleMod.MODID, "textures/entity/tobisuke_sky.png");
//                    number++;
//                    break;
//                case 8:
//                    tobisukeTexture = new ResourceLocation(ExampleMod.MODID, "textures/entity/tobisuke_mblue.png");
//                    number++;
//                    break;
//                case 9:
//                    tobisukeTexture = new ResourceLocation(ExampleMod.MODID, "textures/entity/tobisuke_blue.png");
//                    number++;
//                    break;
//                case 10:
//                    tobisukeTexture = new ResourceLocation(ExampleMod.MODID, "textures/entity/tobisuke_purple.png");
//                    number = 0;
//                    break;
//            }
//            count = 0;
//            return tobisukeTexture;
//        }
        return TOBISUKE_LOCATIONS[entity.getVariant()];
        //return TOBISUKE_LOCATIONS[0];
    }
}
