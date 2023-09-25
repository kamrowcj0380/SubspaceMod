package com.ysp.subspacemod.datagen;

import com.ysp.subspacemod.SubspaceMod;
import com.ysp.subspacemod.block.ModBlocks;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, SubspaceMod.MOD_ID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SUBSPACE_BLOCK);
        blockWithItem(ModBlocks.SUBSPACE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SUBSPACE_ORE);

    }

    //creates json files for both the block itself and the block held in the players hand
    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlock(blockRegistryObject.get());
        simpleBlockItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
