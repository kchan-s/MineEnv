package com.example.examplemod.mc_15_tobisuke;

import com.example.examplemod.ExampleMod;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.UUID;

public class EntityTobisuke2 extends TamableAnimal {

    private static final EntityDataAccessor<Float> DATA_HEALTH_ID
            = SynchedEntityData.defineId(EntityTobisuke2.class, EntityDataSerializers.FLOAT);
    // 色を管理するためのID
    private static final EntityDataAccessor<Integer> DATA_VARIANT_ID
            = SynchedEntityData.defineId(EntityTobisuke2.class, EntityDataSerializers.INT);

    private static final ResourceLocation[] BASE_TEXTURE_LOCATIONS = new ResourceLocation[]{new ResourceLocation(ExampleMod.MODID, "textures/entity/transparent_tobisuke_pink.png"), new ResourceLocation(ExampleMod.MODID, "textures/entity/transparent_tobisuke_blue.png")};

    public EntityTobisuke2(EntityType<? extends TamableAnimal> entityTypeIn, Level level) {
        super(entityTypeIn, level);
        this.setTame(false);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();

        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4f));
        this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0d, 10.0f, 2.0f, false));
        this.goalSelector.addGoal(7, new BreedGoal(this, 1.0d));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0d));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0f));
        this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setAlertOthers());
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.3d)
                .add(Attributes.MAX_HEALTH, 8.0d)
                .add(Attributes.ATTACK_DAMAGE, 2.0d);
    }

    @Override
    protected void customServerAiStep() {
        this.entityData.set(DATA_HEALTH_ID, getHealth());
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_VARIANT_ID, 0);
        // 追記
        this.entityData.define(DATA_HEALTH_ID, getHealth());
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        // nextInt()にはテクスチャの数を記述
        this.setVariant(this.random.nextInt(2));
        if (pSpawnData == null) {
            pSpawnData = new AgeableMob.AgeableMobGroupData(false);
        }
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mate) {
        EntityTobisuke entityTobisuke = ExampleMod.ENTITY_TOBISUKE.create(level);
        UUID uuid = this.getOwnerUUID();
        if (uuid != null) {
            entityTobisuke.setOwnerUUID(uuid);
            entityTobisuke.setTame(true);
        }

        return entityTobisuke;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.getItem() == Items.APPLE;
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return !isTame() && tickCount > 2400;
    }

    @Override
    public InteractionResult mobInteract(Player playerIn, InteractionHand hand) {
        if (!isTame() && isFood(this.useItem)) {
            if (!playerIn.getAbilities().instabuild) {
                this.useItem.setCount(this.useItem.getCount());
            }
            if (!this.level.isClientSide) {
                this.setTame(true);
                navigation.stop();
                setTarget(null);
                this.setOrderedToSit(true);
                this.setHealth(20.0f);
                this.setOwnerUUID(playerIn.getUUID());
                this.spawnTamingParticles(true);
                this.level.broadcastEntityEvent(this, (byte) 7);
            }
            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(playerIn, hand);
    }

    // 現在の色のIDを取得する
    public int getVariant() {
        return Mth.clamp(this.entityData.get(DATA_VARIANT_ID), 0, 1);
//        return this.entityData.get(DATA_VARIANT_ID);
    }

    // 色のIDを設定する
    public void setVariant(int pVariant) {
        this.entityData.set(DATA_VARIANT_ID, pVariant);
    }

    // CompoundTagで色のIDを保存する
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("Variant", this.getVariant());
    }

    // CompoundTagから保存したIDを読み出す
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setVariant(pCompound.getInt("Variant"));
    }


    public static int getBaseVariant(int pVariant) {
        return Math.min(pVariant & 255, 1);
    }

    public int getBaseVariant() {
        return getBaseVariant(this.getVariant());
    }

    public ResourceLocation getBaseTextureLocation() {
        return BASE_TEXTURE_LOCATIONS[getBaseVariant(this.getVariant())];
    }
}