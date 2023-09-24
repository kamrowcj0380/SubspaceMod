package com.ysp.subspacemod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab SUBSPACE_TAB = new CreativeModeTab("subspacetab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.SUBSPACE.get());
        }
    };
}
