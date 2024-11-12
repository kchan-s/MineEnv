package com.example.examplemod.mc_103_custom_eventhandler;

import com.example.examplemod.ExampleMod;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EnderEventHandle {
    @SubscribeEvent
    public void EnderEventHandle(LivingHurtEvent event) {
        if (event.getEntityLiving() instanceof Player) {
            Player player = (Player) event.getEntityLiving();
            if (player.getMainHandItem().getItem() == ExampleMod.ITEM_MAGIC_STICK) {
                event.setCanceled(true);
            }
        }
    }
}