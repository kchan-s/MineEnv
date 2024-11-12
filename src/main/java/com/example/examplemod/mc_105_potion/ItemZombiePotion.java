package com.example.examplemod.mc_105_potion;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class ItemZombiePotion extends Item {
    public ItemZombiePotion() {
        super(new Item.Properties().food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.5f)
                .alwaysEat()
                .build()
        ).tab(CreativeModeTab.TAB_FOOD));
    }

//    @Override
//    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity player) {
//        player.addEffect(new MobEffectInstance(ExampleMod.POTION_ZOMBIE, 1200, 1));
//
//        Vec3 pos = player.position();
//        Random rand = new Random();
//
//        int random = rand.nextInt(10);
//        LivingEntity entity;
//        entity = new Zombie(EntityType.ZOMBIE, level);
//        entity.setPos(pos.x + random, pos.y, pos.z + random);
//
//        if (!level.isClientSide) {
//            ((ServerLevel) level).tryAddFreshEntityWithPassengers(entity);
//        }
//
//        return super.finishUsingItem(stack, level, player);
//    }
}
