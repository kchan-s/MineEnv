package com.example.examplemod.mc_100_tools;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;

public class MyHoeItem extends HoeItem {
    public MyHoeItem() {
        super(Tiers.IRON, -2, -1.0F, (new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    }
}
