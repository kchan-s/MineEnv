package com.example.examplemod.mc_103_custom_eventhandler;

import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class NoSoundHandler {
    @SubscribeEvent
    public static void changeSound(PlaySoundEvent event) {
//        ServerPlayer player = Minecraft.getInstance().getSingleplayerServer().getPlayerList().getPlayers().get(0);
//        Player clientPlayer = Minecraft.getInstance().player;
//        if (clientPlayer != null) {
//            Level level = clientPlayer.getLevel();
//            MinecraftServer minecraftServer = level.getServer();
//            List<ServerPlayer> list = new ArrayList((Collection) minecraftServer.getPlayerList());
//            Item blockItem = Registry.ITEM.get(ExampleMod.BLOCK_MYBLOCK.getRegistryName());
//
//            for (ServerPlayer player : list) {
//                if (player == null) {
//                    return;
//                } else {
//                    player.addEffect(new MobEffectInstance(MobEffects.POISON, 200, 0));
//                }
//            }
//        if (player != null && player.getMainHandItem().getItem() == blockItem) {
//            String name = event.getName();
//            if (name.equals("block.stone.place")) {
//                event.setSound(null);
//            }
//            System.out.println(name);

//            if (name.contains("firework")) {
////                event.setSound(SimpleSoundInstance.forUI(soundEvent, 1.0f));
//                event.setSound(null);
//            } else if (name.equals("shot_sound")) {
//                SoundEvent soundEvent = new SoundEvent(new ResourceLocation(MODID, "crossbow_shot"));
//                event.setSound(SimpleSoundInstance.forUI(soundEvent, 1.0f));
//                System.out.println("a");
//            } else if (name.contains("crossbow")) {
//                event.setSound(null);
//            }
//        }
//        }
    }
}
