package com.example.examplemod.mc_100_tools;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.Optional;

public class ItemMonsterBall extends Item {
    public ItemMonsterBall() {
        super(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        // CompoundTagの設定
        CompoundTag tag = new CompoundTag();
        pTarget.save(tag);
        CompoundTag stackTag = pAttacker.getMainHandItem().getOrCreateTag();
        stackTag.put("mob", tag);

        // 捕まえる処理
        if (!pTarget.level.isClientSide) {
            ServerLevel serverLevel = (ServerLevel) pTarget.level;
            pTarget.setRemoved(Entity.RemovalReason.DISCARDED);
            pAttacker.sendMessage(new TextComponent("Mobを捕まえた！"), pAttacker.getUUID());
        }

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.getMainHandItem();
        Entity entity;

        // CompoundTagにentityが保存されていればentityをそのMOBにする
        try {
            CompoundTag tag = stack.getTag().getCompound("mob");
            Optional<EntityType<?>> optEntityType = EntityType.by(tag);
            entity = optEntityType.get().create(level);
        } catch (Exception e) {
            entity = null;
            stack.setTag(null);
        }

        // 視線の先のブロック取得(視線の先のブロックに召喚する)
        HitResult hitResult = playerIn.pick(4.0D, 0.0F, false);
        if (hitResult.getType() == HitResult.Type.BLOCK) {
            BlockPos blockPos = ((BlockHitResult) hitResult).getBlockPos();
            // entity召喚 yは埋まるので+1してください
            if (entity != null) {
                entity.moveTo(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ());
                if (level instanceof ServerLevel) {
                    ((ServerLevel) level).addFreshEntityWithPassengers(entity);
                }
                stack.setTag(null);
            }
        }

        return super.use(level, playerIn, handIn);
    }
}