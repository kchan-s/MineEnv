package com.example.examplemod.mc_103_custom_eventhandler;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ItemTossHandler {
    @SubscribeEvent
    public static void onItemToss(ItemTossEvent event) {
        Player player = event.getPlayer();
        ItemStack itemstack = event.getEntityItem().getItem();

        Level level = player.level;

        Vec3 vec3 = player.position();
        BlockPos blockPos = new BlockPos(vec3.x, vec3.y - 1, vec3.z);

        level.setBlockAndUpdate(blockPos, Blocks.LAVA.defaultBlockState());
    }
}
