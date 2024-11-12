package com.example.examplemod.mc_102_flower;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class Hydrangea extends FlowerBlock {
    public Hydrangea() {
        // 第一引数がこの花を材料に怪しげなシチューを作って食べた時の効果、第二引数が時間
        super(MobEffects.POISON, 12, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS));
    }
}
