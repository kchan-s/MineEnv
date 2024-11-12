package com.example.examplemod.mc_103_custom_eventhandler;

import com.example.examplemod.ExampleMod;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = ExampleMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MyPickaxeJudgeHandler extends PickaxeItem {
    public MyPickaxeJudgeHandler() {
        super(Tiers.IRON, 3, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
    }

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        // ブロックを破壊したアイテムが自分のピッケルであるかを確認する
        if (event.getPlayer() != null && event.getPlayer().getMainHandItem().getItem() == ExampleMod.ITEM_PICKAXE) {
            Level level = (Level) event.getWorld();
            Player player = event.getPlayer();
            Random rand = new Random();
            int randomNumber = rand.nextInt(10);

            // ブロックを破壊したときの処理をここに記述する
            System.out.println("ブロックを破壊しました: " + event.getState().getBlock().getRegistryName());

            // 召喚させるモブを召喚
            LivingEntity entityMob = new Creeper(EntityType.CREEPER, level);
            // プレイヤーの位置の取得
            BlockPos pos = player.blockPosition();
            // プレイヤーの向いている方向に、プレイヤーの位置から、ー４ブロック先の位置を取得
            BlockPos pos2 = pos.relative(player.getDirection(), -4);
            //エンティティを召喚する場所を指定
            entityMob.setPos(pos2.getX(), pos2.getY(), pos2.getZ());

            //召喚
            if (!level.isClientSide) {
                if (randomNumber < 5)
                    ((ServerLevel) level).tryAddFreshEntityWithPassengers(entityMob);
            }
        }
    }
}