package com.example.examplemod.mc_05_mysword;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;

public class ItemMySword extends SwordItem {
    public ItemMySword() {
        super(Tiers.IRON,
                3,
                -2.4F,
                (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT));
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof Player) {
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1200, 0));
        }
        return super.hurtEnemy(stack, target, attacker);
    }


    // 視線の先のブロック取得
//    @Override
//    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
//
//        HitResult hitResult = pPlayer.pick(20.0D, 0.0F, false);
//
//        if (hitResult.getType() == HitResult.Type.BLOCK) {
//            BlockPos blockPos = ((BlockHitResult) hitResult).getBlockPos();
//            BlockState blockState = pLevel.getBlockState(blockPos);
//            if (!pLevel.isClientSide) {
//                pPlayer.setPos(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ());
//            }
////            if (!pLevel.isClientSide && blockState.getBlock() == Blocks.GRASS_BLOCK) {
////                float explosiveRadius = 1.0f;
////                pLevel.explode(null, blockPos.getX(), blockPos.getY(), blockPos.getZ(), explosiveRadius, Explosion.BlockInteraction.BREAK);
////            }
//        }
//        return super.use(pLevel, pPlayer, pUsedHand);
//    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {

        BlockPos pos = playerIn.getOnPos();
        if (!level.isClientSide) {
            float explosiveRadius = 1.0f;
            level.explode(null, pos.getX(), pos.getY(), pos.getZ(),
                    explosiveRadius, Explosion.BlockInteraction.BREAK);
        }

        return super.use(level, playerIn, handIn);
    }
}
