package com.example.examplemod.mc_104_advancement;

import com.google.common.collect.ImmutableList;
import net.minecraft.advancements.Advancement;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.advancements.*;

import java.util.List;
import java.util.function.Consumer;

public class CustomAdvancementProvider extends AdvancementProvider {

    private final List<Consumer<Consumer<Advancement>>> tabs = ImmutableList.of(new CustomAdvancements());

    public CustomAdvancementProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void registerAdvancements(Consumer<Advancement> consumer, net.minecraftforge.common.data.ExistingFileHelper fileHelper) {
        for (Consumer<Consumer<Advancement>> consumer1 : this.tabs) {
            consumer1.accept(consumer);
        }
    }
}
