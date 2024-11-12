package com.example.examplemod.mc_100_tools;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemMyFireball extends Item {
    public ItemMyFireball() {
        super(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand pUsedHand) {
        double playerXRot = -Math.toRadians(player.getYRot());
        double playerYRot = -Math.toRadians(player.getXRot());
        if (!level.isClientSide) {
            EntityMyFireball entity = new EntityMyFireball(level, player, Math.sin(playerXRot), Math.sin(playerYRot), Math.cos(playerXRot), 5);

            entity.shootFromRotation(player, player.xRotO, player.yRotO, 0.0f, 1.5f, 1.0f);
            level.addFreshEntity(entity);
        }

        return super.use(level, player, pUsedHand);
    }
}