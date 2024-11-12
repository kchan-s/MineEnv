package com.example.examplemod.mc_100_tools;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;

public class MyAxeItem extends AxeItem {
    public MyAxeItem() {
        super(Tiers.IRON, 6.0F, -3.1F, (new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    }
}
