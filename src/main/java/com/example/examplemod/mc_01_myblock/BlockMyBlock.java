package com.example.examplemod.mc_01_myblock;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;


import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class BlockMyBlock extends Block {
    public BlockMyBlock() {
        super(Block.Properties.of(Material.STONE).strength(3f).noCollission().requiresCorrectToolForDrops()
                .lightLevel((pLightEmission -> 15)));
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState blockState, Entity entityIn) {
        super.stepOn(level, pos, blockState, entityIn);

        ArrowItem itemArrow = new ArrowItem(new Item.Properties());
        if (entityIn instanceof Villager) {
            if (!level.isClientSide) {
                Arrow arrow = (Arrow) itemArrow.createArrow(level, ((Villager) entityIn).getMainHandItem(), (LivingEntity) entityIn);
                arrow.shootFromRotation(entityIn, entityIn.xRotO, entityIn.yRotO, 0.0f, 3.0f, 2.0f);
                level.addFreshEntity(arrow);
            }
        }

        if (!(entityIn instanceof Player)) {
            return;
        }

        level.scheduleTick(pos, this, 20);

    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, Random rand) {
        super.tick(state, level, pos, rand);

        level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        Component component1 = new TextComponent("");
        Component component2 = new TextComponent("§bマイブロックだよ");

        pTooltip.add(1, component1);
        pTooltip.add(2, component2);
    }
}