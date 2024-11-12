package com.example.examplemod.mc_101_different_color;

import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class EntityOriginalWitherSkeleton extends WitherSkeleton {

    public EntityOriginalWitherSkeleton(EntityType<? extends WitherSkeleton> entityType, Level level) {
        super(entityType, level);
    }

    // AIの設定を行うらしい。基本の行動を設定
    protected void registerGoals() {
        super.registerGoals();
    }

    // 体力とか速度とか攻撃力とか諸々設定できる。
    //java.lang.NullPointerException: Cannot invoke "net.minecraft.world.entity.ai.attributes.AttributeInstance.setBaseValue(double)" because the return value of "net.minecraft.world.entity.monster.WitherSkeleton.getAttribute(net.minecraft.world.entity.ai.attributes.Attribute)" is null
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.createMonsterAttributes();
//        return Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    // 持ち物
    @Override
    protected void populateDefaultEquipmentSlots(DifficultyInstance pDifficulty) {
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
    }
}
