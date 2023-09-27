package com.ysp.subspacemod.datagen.loot;

import com.ysp.subspacemod.block.ModBlocks;
import com.ysp.subspacemod.item.ModItems;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;


public class ModBlockLoot extends BlockLoot {
    @Override
    protected void addTables() {
        //Blocks that drop themselves when broken
        dropSelf(ModBlocks.SUBSPACE_BLOCK.get());

        //Blocks that drop other items
        add(ModBlocks.SUBSPACE_ORE.get(), (block) -> createOreDrop(block, ModItems.RAW_SUBSPACE.get()));
        add(ModBlocks.DEEPSLATE_SUBSPACE_ORE.get(), (block) -> createOreDrop(block, ModItems.RAW_SUBSPACE.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
