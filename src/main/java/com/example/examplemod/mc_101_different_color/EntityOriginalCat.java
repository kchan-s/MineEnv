package com.example.examplemod.mc_101_different_color;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.level.Level;


public class EntityOriginalCat extends Cat {
    public EntityOriginalCat(EntityType<? extends Cat> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes();
    }
}
