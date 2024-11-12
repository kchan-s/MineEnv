package com.example.examplemod.mc_100_tools;

import net.minecraft.world.item.*;

public class MyPickaxeItem extends PickaxeItem {
    public MyPickaxeItem() {
        super(Tiers.IRON, 1, -2.8F, (new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    }
}
