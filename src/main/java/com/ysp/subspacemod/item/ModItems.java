package com.ysp.subspacemod.item;

import com.ysp.subspacemod.SubspaceMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SubspaceMod.MOD_ID);

    //add items
    public static final RegistryObject<Item> SUBSPACE = ITEMS.register("subspace",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SUBSPACE_TAB)));
    public static final RegistryObject<Item> RAW_SUBSPACE = ITEMS.register("raw_subspace",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SUBSPACE_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
