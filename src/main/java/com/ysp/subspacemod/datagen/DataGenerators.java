package com.ysp.subspacemod.datagen;

import com.ysp.subspacemod.SubspaceMod;
import com.ysp.subspacemod.datagen.loot.ModLootTableProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SubspaceMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        generator.addProvider(event.includeServer(), new ModRecipeProvider(generator));
        generator.addProvider(event.includeServer(), new ModLootTableProvider(generator));
        ModBlockTagProvider blockTags = new ModBlockTagProvider(generator, event.getExistingFileHelper());
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new ModItemTagProvider(generator, blockTags, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(generator, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(generator, event.getExistingFileHelper()));
    }
}
