package com.example.examplemod.mc_15_tobisuke;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.ApiStatus;

public class MyAnimalEntity extends Animal {

    private static final EntityDataAccessor<Float> DATA_HEALTH_ID =
            SynchedEntityData.defineId(MyAnimalEntity.class, EntityDataSerializers.FLOAT);

    public MyAnimalEntity(EntityType<? extends Animal> entityTypeIn, Level level) {
        super(entityTypeIn, level);
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    @Override
    protected void customServerAiStep() {
        this.entityData.set(DATA_HEALTH_ID, getHealth());
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        ;
        this.entityData.define(DATA_HEALTH_ID, getHealth());
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.3d)
                .add(Attributes.MAX_HEALTH, 8.0d)
                .add(Attributes.ATTACK_DAMAGE, 2.0d);
    }
}
