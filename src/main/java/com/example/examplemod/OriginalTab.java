package com.example.examplemod;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class OriginalTab extends CreativeModeTab {
    public OriginalTab() {
        super("OriginalTab");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(Items.GOLD_BLOCK);
    }
}