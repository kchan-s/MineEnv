package com.example.examplemod.mc_102_flower;

import com.example.examplemod.ExampleMod;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemOpenUmbrella extends Item {
    public ItemOpenUmbrella() {
        super(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
    }

//    int[][][] tofuHouse = {
//            {
//                    {2, 1, 1, 2, 2},
//                    {2, 1, 1, 1, 2},
//                    {2, 1, 1, 1, 2},
//                    {2, 1, 1, 1, 2},
//                    {2, 2, 2, 2, 2}
//            },
//            {
//                    {2, 1, 1, 2, 2},
//                    {2, 1, 1, 1, 2},
//                    {2, 1, 1, 1, 2},
//                    {2, 1, 1, 1, 2},
//                    {2, 2, 2, 2, 2}
//            },
//            {
//                    {2, 2, 2, 2, 2},
//                    {2, 1, 1, 1, 2},
//                    {2, 1, 1, 1, 2},
//                    {2, 1, 1, 1, 2},
//                    {2, 2, 2, 2, 2}
//            },
//            {
//                    {2, 2, 2, 2, 2},
//                    {2, 2, 2, 2, 2},
//                    {2, 2, 2, 2, 2},
//                    {2, 2, 2, 2, 2},
//                    {2, 2, 2, 2, 2}
//            }
//    };

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {

        AreaEffectCloud areaeffectcloud = new AreaEffectCloud(level, playerIn.getX() + 10, playerIn.getY() + 3, playerIn.getZ()); //生成する座標
        areaeffectcloud.setRadius(2.5F); //半径
        areaeffectcloud.setDuration(100); //生成時間
        areaeffectcloud.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 100, 5)); //付与する効果
        level.addFreshEntity(areaeffectcloud); //ワールドに雲をスポーン

        AreaEffectCloud areaeffectcloud1 = new AreaEffectCloud(level, playerIn.getX() + 10, playerIn.getY() + 2, playerIn.getZ()); //生成する座標
        areaeffectcloud1.setRadius(2.5F); //半径
        areaeffectcloud1.setDuration(100); //生成時間
        areaeffectcloud1.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 100, 5)); //付与する効果
        level.addFreshEntity(areaeffectcloud1); //ワールドに雲をスポーン

        AreaEffectCloud areaeffectcloud2 = new AreaEffectCloud(level, playerIn.getX() + 10, playerIn.getY() + 1, playerIn.getZ()); //生成する座標
        areaeffectcloud2.setRadius(2.5F); //半径
        areaeffectcloud2.setDuration(100); //生成時間
        areaeffectcloud2.addEffect(new MobEffectInstance(MobEffects.BAD_OMEN, 100, 5)); //付与する効果
        level.addFreshEntity(areaeffectcloud2); //ワールドに雲をスポーン

        AreaEffectCloud areaeffectcloud3 = new AreaEffectCloud(level, playerIn.getX() + 10, playerIn.getY(), playerIn.getZ()); //生成する座標
        areaeffectcloud3.setRadius(2.5F); //半径
        areaeffectcloud3.setDuration(100); //生成時間
        areaeffectcloud3.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 100, 5)); //付与する効果
        level.addFreshEntity(areaeffectcloud3); //ワールドに雲をスポーン

//        AreaEffectCloud areaeffectcloud4 = new AreaEffectCloud(level, playerIn.getX()+10, playerIn.getY()-1, playerIn.getZ()); //生成する座標
//        areaeffectcloud4.setRadius(2.5F); //半径
//        areaeffectcloud4.setDuration(100); //生成時間
//        areaeffectcloud4.addEffect(new MobEffectInstance(MobEffects.LUCK, 100, 5)); //付与する効果
//        level.addFreshEntity(areaeffectcloud4); //ワールドに雲をスポーン
//
//        AreaEffectCloud areaeffectcloud5 = new AreaEffectCloud(level, playerIn.getX()+10, playerIn.getY()-2, playerIn.getZ()); //生成する座標
//        areaeffectcloud5.setRadius(2.5F); //半径
//        areaeffectcloud5.setDuration(100); //生成時間
//        areaeffectcloud5.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 100, 5)); //付与する効果
//        level.addFreshEntity(areaeffectcloud5); //ワールドに雲をスポーン
//
//        AreaEffectCloud areaeffectcloud6 = new AreaEffectCloud(level, playerIn.getX()+10, playerIn.getY()-3, playerIn.getZ()); //生成する座標
//        areaeffectcloud6.setRadius(2.5F); //半径
//        areaeffectcloud6.setDuration(100); //生成時間
//        areaeffectcloud6.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 100, 5)); //付与する効果
//        level.addFreshEntity(areaeffectcloud6); //ワールドに雲をスポーン

//        for (int y = 0; y < tofuHouse.length; y++) {
//            for (int x = 0; x < tofuHouse[y].length; x++) {
//                for (int z = 0; z < tofuHouse[y][x].length; z++) {
//                    switch (tofuHouse[y][x][z]) {
//                        case 1 -> level.setBlockAndUpdate(playerIn.getOnPos().offset(x, y-10, z), Blocks.DIAMOND_BLOCK.defaultBlockState());
//                        case 2 -> level.setBlockAndUpdate(playerIn.getOnPos().offset(x, y-10, z), Blocks.GOLD_BLOCK.defaultBlockState());
//                        case 3 -> level.setBlockAndUpdate(playerIn.getOnPos().offset(x, y-10, z), Blocks.IRON_BLOCK.defaultBlockState());
//                    }
//                }
//            }
//        }

        playerIn.setItemInHand(handIn, new ItemStack(ExampleMod.ITEM_UMBRELLA));
        return super.use(level, playerIn, handIn);
    }
}
