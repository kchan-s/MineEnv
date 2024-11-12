package com.example.examplemod.mc_103_custom_eventhandler;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.event.MovementInputUpdateEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class TheVoidHandler {
    //    @SubscribeEvent
    public static void onPlayerWalk(MovementInputUpdateEvent event) {
        //ServerPlayer player = Minecraft.getInstance().getSingleplayerServer().getPlayerList().getPlayers().get(0);
        Player player = Minecraft.getInstance().player;
        if (player != null) {
            Level level = player.level;
            Vec3 vec3 = player.position();
            BlockPos playerOnBlockPos = new BlockPos(vec3.x, vec3.y - 1, vec3.z);

            if (player.isOnGround()) {
                if (level.getBlockState(playerOnBlockPos).getBlock() != Blocks.AIR) {
                    for (int i = (int) Math.floor(vec3.y - 1); i >= -64; i--) {
                        BlockPos blockPos = new BlockPos(vec3.x, i, vec3.z);
                        level.setBlockAndUpdate(blockPos, Blocks.AIR.defaultBlockState());
                    }
//        BlockPos blockPos = new BlockPos(vec3.x, vec3.y - 1, vec3.z);
//        level.setBlockAndUpdate(blockPos, Blocks.AIR.defaultBlockState());
                }
            }
        }
    }
}
