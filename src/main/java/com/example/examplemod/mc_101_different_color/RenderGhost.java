package com.example.examplemod.mc_101_different_color;

import com.example.examplemod.ExampleMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderGhost extends MobRenderer<EntityGhost, ModelGhost<EntityGhost>> {
    public static final ResourceLocation[] GHOST_LOCATIONS =
            new ResourceLocation[]{
                    new ResourceLocation(ExampleMod.MODID, "textures/entity/ghost.png"),
                    new ResourceLocation(ExampleMod.MODID, "textures/entity/ghost_transparent.png")
            };

    public static final ModelLayerLocation modelLayerLocation =
            new ModelLayerLocation(new ResourceLocation(ExampleMod.MODID, "ghost"), "ghost");

    public RenderGhost(EntityRendererProvider.Context context) {
        super(context, new ModelGhost<>(context.bakeLayer(modelLayerLocation)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityGhost entity) {
        ServerPlayer player = Minecraft.getInstance().getSingleplayerServer().getPlayerList().getPlayers().get(0);
        ServerLevel level = player.getLevel();
        if (level.isNight()) {
            return GHOST_LOCATIONS[1];
        } else {
            return GHOST_LOCATIONS[0];
        }
    }
}
