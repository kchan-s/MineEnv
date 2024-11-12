package com.example.examplemod.mc_03_magicstick;

import com.example.examplemod.ExampleMod;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import javax.annotation.Nullable;
import java.util.List;

public class ItemMagicStick extends Item {

//    int weatherCount = 0;

    private static final IntegerProperty COUNT = IntegerProperty.create("count", 0, 2);

    public ItemMagicStick() {
        super(new Item.Properties().tab(ExampleMod.ORIGINAL_TAB).fireResistant());
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        Level level = pTarget.level;
        BlockPos spawnPos = pTarget.blockPosition();

        LivingEntity entity, entity2;
        if (pTarget instanceof Zombie) {
            entity = new Chicken(EntityType.CHICKEN, level);
            entity.setPos(spawnPos.getX(), spawnPos.getY(), spawnPos.getZ());

            if (!pTarget.level.isClientSide) {
                ServerLevel serverLevel = (ServerLevel) pTarget.level;
                serverLevel.tryAddFreshEntityWithPassengers(entity);
                serverLevel.removeEntity(pTarget);
            }
        } else {
            Axolotl axolotl = EntityType.AXOLOTL.create(level);
            Cat cat = EntityType.CAT.create(level);

            if (axolotl != null) {
                axolotl.moveTo(spawnPos, 0.0F, 0.0F);
                axolotl.finalizeSpawn((ServerLevel) level, level.getCurrentDifficultyAt(spawnPos), MobSpawnType.NATURAL, null, null);
            }

            if (cat != null) {
                cat.moveTo(spawnPos, 0.0F, 0.0F); // Fix MC-147659: Some witch huts spawn the incorrect cat
                cat.finalizeSpawn((ServerLevel) level, level.getCurrentDifficultyAt(spawnPos), MobSpawnType.NATURAL, (SpawnGroupData) null, (CompoundTag) null);
            }

            if (!pTarget.level.isClientSide) {
                ServerLevel serverLevel = (ServerLevel) pTarget.level;
                serverLevel.tryAddFreshEntityWithPassengers(axolotl);
                serverLevel.tryAddFreshEntityWithPassengers(cat);
                serverLevel.removeEntity(pTarget);
            }
        }

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    // 1-18 アイテムクリックで天候変化
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {

//        if (weatherCount < 2) {
//            weatherCount++;
//        } else {
//            weatherCount = 0;
//        }
//
//        if (!level.isClientSide) {
//            switch (weatherCount) {
//                case 0 -> ((ServerLevel) level).setWeatherParameters(0, 1000, true, false);
//                case 1 -> ((ServerLevel) level).setWeatherParameters(1000, 0, false, true);
//                case 2 -> ((ServerLevel) level).setWeatherParameters(0, 1000, true, true);
//            }
//        }
//        if (playerIn.isInWater()) {
//
//            ItemStack itemstack = new ItemStack(Items.ENDER_PEARL, 1);
//            ThrownEnderpearl thrownenderpearl = new ThrownEnderpearl(level, playerIn);
//            thrownenderpearl.setItem(itemstack);
//            thrownenderpearl.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot(), 0.0F, 1.5F, 1.0F);
//            level.addFreshEntity(thrownenderpearl);
//        }

        return super.use(level, playerIn, handIn);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        Component component1 = new TextComponent("");
        Component component2 = new TextComponent("§bゆるゆるゆる");

        pTooltipComponents.add(1, component1);
        pTooltipComponents.add(2, component2);
    }
}