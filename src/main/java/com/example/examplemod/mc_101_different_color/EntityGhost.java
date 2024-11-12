package com.example.examplemod.mc_101_different_color;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class EntityGhost extends Monster {
    public EntityGhost(EntityType<? extends Monster> entityTypeIn, Level level) {
        super(entityTypeIn, level);
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.3d)
                .add(Attributes.MAX_HEALTH, 8.0d)
                .add(Attributes.ATTACK_DAMAGE, 2.0d);
    }
}
