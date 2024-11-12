package com.example.examplemod.mc_101_different_color;

import com.example.examplemod.ExampleMod;
import net.minecraft.client.renderer.entity.AxolotlRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderAxolotlDif extends AxolotlRenderer {
    public RenderAxolotlDif(EntityRendererProvider.Context context) {
        super(context);
    }

    public static ResourceLocation axolotlDifTexture = new ResourceLocation(ExampleMod.MODID, "textures/entity/axolotl1.png");
    ;
    private static int time = 0;
    private static int number = 0;

    @Override
    public ResourceLocation getTextureLocation(Axolotl entity) {
        if (time != 80) {
            time++;
            return axolotlDifTexture;
        } else {
            switch (number) {
                case 0:
                    axolotlDifTexture = new ResourceLocation(ExampleMod.MODID, "textures/entity/axolotl1.png");
                    number++;
                    break;
                case 1:
                    axolotlDifTexture = new ResourceLocation(ExampleMod.MODID, "textures/entity/axolotl2.png");
                    number++;
                    break;
                case 2:
                    axolotlDifTexture = new ResourceLocation(ExampleMod.MODID, "textures/entity/axolotl3.png");
                    number++;
                    break;
                case 3:
                    axolotlDifTexture = new ResourceLocation(ExampleMod.MODID, "textures/entity/axolotl4.png");
                    number++;
                    break;
                case 4:
                    axolotlDifTexture = new ResourceLocation(ExampleMod.MODID, "textures/entity/axolotl5.png");
                    number++;
                    break;
                case 5:
                    axolotlDifTexture = new ResourceLocation(ExampleMod.MODID, "textures/entity/axolotl6.png");
                    number++;
                    break;
                case 6:
                    axolotlDifTexture = new ResourceLocation(ExampleMod.MODID, "textures/entity/axolotl7.png");
                    number = 0;
                    break;
            }
            time = 0;
            return axolotlDifTexture;
        }
    }
}


