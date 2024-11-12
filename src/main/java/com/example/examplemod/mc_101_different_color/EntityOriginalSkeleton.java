package com.example.examplemod.mc_101_different_color;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class EntityOriginalSkeleton extends AbstractSkeleton {
    public EntityOriginalSkeleton(EntityType<? extends AbstractSkeleton> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.createMonsterAttributes();
    }

    @Override
    protected SoundEvent getStepSound() {
        return null;
    }
}
