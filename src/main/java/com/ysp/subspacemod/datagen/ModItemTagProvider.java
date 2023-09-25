package com.ysp.subspacemod.datagen;

import com.ysp.subspacemod.SubspaceMod;
import com.ysp.subspacemod.block.ModBlocks;
import com.ysp.subspacemod.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper helper) {
        super(generator, blockTags, SubspaceMod.MOD_ID, helper);
    }
    @Override
    protected void addTags() {
        tag(Tags.Items.ORES)
                .add(ModItems.RAW_SUBSPACE.get());
    }

    @Override
    public String getName() {
        return "SubspaceMod Tags";
    }
}
