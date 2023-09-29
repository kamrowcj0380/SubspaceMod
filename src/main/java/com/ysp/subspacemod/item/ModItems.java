package com.ysp.subspacemod.item;

import com.ysp.subspacemod.SubspaceMod;
import com.ysp.subspacemod.entity.ModEntityTypes;
import com.ysp.subspacemod.item.custom.ApplePipeItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
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
    public static final RegistryObject<Item> ANDREW_SOUL = ITEMS.register("andrew_soul", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SUBSPACE_TAB)));
    public static final RegistryObject<Item> ANGELO_SOUL = ITEMS.register("angelo_soul", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SUBSPACE_TAB)));
    public static final RegistryObject<Item> CONNOR_SOUL = ITEMS.register("connor_soul", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SUBSPACE_TAB)));
    public static final RegistryObject<Item> JEVAN_SOUL = ITEMS.register("jevan_soul", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SUBSPACE_TAB)));
    public static final RegistryObject<Item> SHAWN_SOUL = ITEMS.register("shawn_soul", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SUBSPACE_TAB)));
    public static final RegistryObject<Item> TANNER_SOUL = ITEMS.register("tanner_soul", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SUBSPACE_TAB)));
    public static final RegistryObject<Item> WILL_SOUL = ITEMS.register("will_soul", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SUBSPACE_TAB)));
    public static final RegistryObject<Item> OGRE_HANDS = ITEMS.register("ogre_hands",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SUBSPACE_TAB)));
    public static final RegistryObject<Item> QUAKE_PRO_GLASSES = ITEMS.register("quake_pro_glasses",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SUBSPACE_TAB).stacksTo(1)));
    public static final RegistryObject<Item> NANCY = ITEMS.register("nancy",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SUBSPACE_TAB).stacksTo(1)));
    public static final RegistryObject<Item> SHAWN_PHONE = ITEMS.register("shawn_phone",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SUBSPACE_TAB).stacksTo(1)));
    public static final RegistryObject<Item> PAINFUL_MAC_AND_CHEESE = ITEMS.register("painful_mac_and_cheese",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SUBSPACE_TAB).stacksTo(1)));


    //Adds an apple pipe item with a max stack of 1
    public static final RegistryObject<Item> APPLE_PIPE = ITEMS.register("apple_pipe",
            () -> new ApplePipeItem(new Item.Properties().tab(ModCreativeModeTab.SUBSPACE_TAB).stacksTo(1)));

    //Creates spawn egg for shawn mob
    public static final RegistryObject<Item> SHAWN_EGG = ITEMS.register("shawn_egg", () -> new ForgeSpawnEggItem(ModEntityTypes.SHAWN, 0xff0000, 0x00ff00, new Item.Properties().tab(ModCreativeModeTab.SUBSPACE_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
