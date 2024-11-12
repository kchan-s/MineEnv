package com.example.examplemod.mc_102_flower;

import com.example.examplemod.ExampleMod;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemUmbrella extends Item {
    public ItemUmbrella() {
        super(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
        playerIn.setItemInHand(handIn, new ItemStack(ExampleMod.ITEM_OPEN_UMBRELLA));
        return super.use(level, playerIn, handIn);
    }
}
