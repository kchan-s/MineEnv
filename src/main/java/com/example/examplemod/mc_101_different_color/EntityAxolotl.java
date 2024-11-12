package com.example.examplemod.mc_101_different_color;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.level.Level;

public class EntityAxolotl extends Axolotl {
    public EntityAxolotl(EntityType<? extends Axolotl> p_149105_, Level p_149106_) {
        super(p_149105_, p_149106_);
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes();
    }


}