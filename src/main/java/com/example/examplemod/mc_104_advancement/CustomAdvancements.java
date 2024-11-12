package com.example.examplemod.mc_104_advancement;

import com.example.examplemod.ExampleMod;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.*;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class CustomAdvancements implements Consumer<Consumer<Advancement>> {
    public void accept(Consumer<Advancement> consumer) {
        // FrameType.TASK → 通常の進捗
        // FrameType.GOAL → 目標
        // FrameType.CHALLENGE → 挑戦
        // show_toast → 進捗達成時に右上にトースト通知を出すか
        // announce_to_chat → 達成時にチャットに通知するか
        // hidden → 元々は非表示かどうか
        // 背景 透明な部分は全部黒になる
        Advancement advancement =
                Advancement.Builder.advancement()
                        .display(ExampleMod.BLOCK_MYBLOCK, new TranslatableComponent("advancements.custom.root.title"), new TranslatableComponent("advancements.custom.root.description"), new ResourceLocation("textures/blocks/upa.png"), FrameType.TASK, false, false, false)
                        .addCriterion("myblock", InventoryChangeTrigger.TriggerInstance.hasItems(ExampleMod.BLOCK_MYBLOCK))
                        .save(consumer, "custom/root");
        Advancement.Builder.advancement()
                .parent(advancement)
                .display(ExampleMod.BLOCK_FORTUNE, new TranslatableComponent("advancements.custom.block_fortune.title"), new TranslatableComponent("advancements.custom.block_fortune.description"), (ResourceLocation) null, FrameType.TASK, true, true, false)
                .addCriterion("fortune", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ExampleMod.BLOCK_FORTUNE).build()))
                .save(consumer, "custom/block_fortune");
        Advancement advancement1 =
                Advancement.Builder.advancement()
                        .parent(advancement)
                        .display(ExampleMod.ITEM_MAGIC_STICK, new TranslatableComponent("advancements.custom.magic_stick.title"), new TranslatableComponent("advancements.custom.magic_stick.description"), (ResourceLocation) null, FrameType.TASK, true, true, false)
                        .addCriterion("magic_stick", InventoryChangeTrigger.TriggerInstance.hasItems(ExampleMod.ITEM_MAGIC_STICK))
                        .save(consumer, "custom/magic_stick");
        Advancement advancement2 =
                Advancement.Builder.advancement()
                        .parent(advancement)
                        .display(ExampleMod.ITEM_HI_POTION, new TranslatableComponent("advancements.custom.hi_potion.title"), new TranslatableComponent("advancements.custom.hi_potion.description"), (ResourceLocation) null, FrameType.TASK, true, true, false)
                        .addCriterion("hi_potion", InventoryChangeTrigger.TriggerInstance.hasItems(ExampleMod.ITEM_HI_POTION))
                        .save(consumer, "custom/hi_potion");
        Advancement.Builder.advancement()
                .parent(advancement1)
                .display(ExampleMod.BULL_SPAWN_EGG, new TranslatableComponent("advancements.custom.enchant_item.title"), new TranslatableComponent("advancements.custom.enchant_item.description"), (ResourceLocation) null, FrameType.GOAL, true, true, false)
                .rewards(AdvancementRewards.Builder.experience(50))
                .addCriterion("killed_entity_bull", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(ExampleMod.ENTITY_BULL)))
                .save(consumer, "custom/killed_entity_bull");
        Advancement.Builder.advancement()
                .parent(advancement2)
                .display(Items.NETHERITE_INGOT, new TranslatableComponent("advancements.custom.netherite_ingot.title"), new TranslatableComponent("advancements.custom.netherite_ingot.description"), (ResourceLocation) null, FrameType.CHALLENGE, true, true, true)
                .addCriterion("netherite_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.NETHERITE_INGOT))
                .save(consumer, "custom/netherite_ingot");
    }
}
