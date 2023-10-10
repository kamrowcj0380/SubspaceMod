package com.ysp.subspacemod.datagen.loot;

import com.ysp.subspacemod.SubspaceMod;
import com.ysp.subspacemod.item.ModItems;
import net.minecraft.data.loot.ChestLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class ModChestLoot extends ChestLoot {
    public static final ResourceLocation OGRE_CAVE = new ResourceLocation(SubspaceMod.MOD_ID, "chests/ogre_cave");

    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(OGRE_CAVE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(2, 6))
                        .add(LootItem.lootTableItem(ModItems.OGRE_HANDS.get()).setWeight(8))
                        .add(LootItem.lootTableItem(Items.IRON_PICKAXE).setWeight(8))
                        .add(LootItem.lootTableItem(Items.STRING).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 6))))
                        .add(LootItem.lootTableItem(Items.IRON_INGOT).setWeight(6).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                        .add(LootItem.lootTableItem(Items.BREAD).setWeight(4).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                        .add(LootItem.lootTableItem(Items.BONE).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                        .add(LootItem.lootTableItem(Items.REDSTONE).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(8, 12))))));
        super.accept(consumer);
    }
}
