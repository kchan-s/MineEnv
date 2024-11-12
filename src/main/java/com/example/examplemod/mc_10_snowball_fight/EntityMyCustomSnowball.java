package com.example.examplemod.mc_10_snowball_fight;

import com.example.examplemod.ExampleMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class EntityMyCustomSnowball extends ThrowableItemProjectile {

    // Entityに当たった時のダメージ量
    private static final float DAMAGE = 2.0f;

    public EntityMyCustomSnowball(EntityType<? extends ThrowableItemProjectile> entityTypeIn, Level level) {
        super(entityTypeIn, level);
    }

    public EntityMyCustomSnowball(Level level, LivingEntity throwerIn) {
        super(ExampleMod.ENTITY_MY_CUSTOM_SNOWBALL, throwerIn, level);
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!level.isClientSide) {
            if (result.getType() == HitResult.Type.BLOCK) {
                BlockHitResult blockHitResult = (BlockHitResult) result;
                // 爆発
                float explosionRadius = 1.0f;
                BlockPos pos = blockHitResult.getBlockPos();
                level.explode(null, pos.getX(), pos.getY(), pos.getZ(), explosionRadius, Explosion.BlockInteraction.BREAK);
            }
        }
    }

    // テクスチャカスタム追記
    @Override
    protected Item getDefaultItem() {
        return ExampleMod.ITEM_MY_CUSTOM_SNOWBALL;
    }

}
