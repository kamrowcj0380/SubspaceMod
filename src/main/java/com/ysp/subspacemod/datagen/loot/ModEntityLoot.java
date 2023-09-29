package com.ysp.subspacemod.datagen.loot;

import com.ysp.subspacemod.entity.ModEntityTypes;
import com.ysp.subspacemod.item.ModItems;
import net.minecraft.data.loot.EntityLoot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Iterator;
import java.util.stream.Stream;

public class ModEntityLoot extends EntityLoot {
    @Override
    protected void addTables() {
        //Gives the shawn entity a loot table
        add(ModEntityTypes.SHAWN.get(), LootTable.lootTable()
                //Chance to drop shawn's soul
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(ModItems.SHAWN_SOUL.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));
                //Guaranteed drop of subspace item
                //.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(ModItems.SUBSPACE.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1, 1)))));

    }

    @Override
    protected Iterable<EntityType<?>> getKnownEntities() {
        Stream<? extends EntityType<?>> stream = ModEntityTypes.ENTITY_TYPES.getEntries().stream().map(RegistryObject::get);
        return () -> (Iterator<EntityType<?>>) stream.iterator();
    }
}
