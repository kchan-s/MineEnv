package com.example.examplemod.mc_100_tools;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tiers;

public class MyShovelItem extends ShovelItem {
    public MyShovelItem() {
        super(Tiers.IRON, 1.5F, -3.0F, (new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    }
}
