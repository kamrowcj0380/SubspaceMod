package com.ysp.subspacemod.datagen;

import com.ysp.subspacemod.SubspaceMod;
import com.ysp.subspacemod.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, SubspaceMod.MOD_ID, helper);
    }
    @Override
    protected void addTags() {
        //Blocks in this list are mineable with a pickaxe
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SUBSPACE_BLOCK.get())
                .add(ModBlocks.SUBSPACE_ORE.get())
                .add(ModBlocks.DEEPSLATE_SUBSPACE_ORE.get());
        //Blocks in this list need an iron tool to be mined
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SUBSPACE_BLOCK.get())
                .add(ModBlocks.SUBSPACE_ORE.get())
                .add(ModBlocks.DEEPSLATE_SUBSPACE_ORE.get());
        //Blocks in this list are recognized as ores
        tag(Tags.Blocks.ORES)
                .add(ModBlocks.SUBSPACE_ORE.get())
                .add(ModBlocks.DEEPSLATE_SUBSPACE_ORE.get());
    }

    @Override
    public String getName() {
        return "SubspaceMod Tags";
    }
}
