package com.example.examplemod.mc_101_different_color;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class EntityOriginalCreeper extends Creeper {
    public EntityOriginalCreeper(EntityType<? extends Creeper> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.createMonsterAttributes();
    }
}
