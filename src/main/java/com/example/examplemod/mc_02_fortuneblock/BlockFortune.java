package com.example.examplemod.mc_02_fortuneblock;

import com.example.examplemod.ExampleMod;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

import java.util.Random;

public class BlockFortune extends Block {
    public BlockFortune() {
        super(Block.Properties.of(Material.STONE).strength(5f).noOcclusion());
    }

    @Override
    public void attack(BlockState state, Level level, BlockPos pos, Player player) {

        Random random = new Random();
        int randomNumber = random.nextInt(5);

        ItemStack stack = new ItemStack(Items.PAPER);
        stack.setHoverName(new TextComponent("大吉"));
        ItemEntity itemEntity = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), stack);
        itemEntity.setDefaultPickUpDelay();
        level.addFreshEntity(itemEntity);

        String message = "料金 : ダイヤモンド1個";

        ItemStack heldItem = player.getMainHandItem();
        if (heldItem.getItem() == Items.DIAMOND) {
            heldItem.setCount(heldItem.getCount() - 1);
            if (randomNumber == 0) {
                message = "大当たり";
                if (!level.isClientSide) {
                    ItemStack stack1 = new ItemStack(ExampleMod.ITEM_MY_SWORD);
                    ItemEntity itemEntity1 = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), stack1);
                    itemEntity1.setDefaultPickUpDelay();
                    level.addFreshEntity(itemEntity1);

                    ItemStack stack2 = new ItemStack(ExampleMod.ITEM_MAGIC_STICK);
                    ItemEntity itemEntity2 = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), stack2);
                    itemEntity2.setDefaultPickUpDelay();
                    level.addFreshEntity(itemEntity2);
                }
            } else if (randomNumber == 1) {
                message = "当たり";
            } else if (randomNumber == 2) {
                message = "~~~~";
            } else if (randomNumber == 3) {
                message = "はずれ";
            } else if (randomNumber == 4) {
                message = "悲しい";
            }
        }

        if (!level.isClientSide) {
            player.sendMessage(new TextComponent(message), player.getUUID());
        }
    }
}
