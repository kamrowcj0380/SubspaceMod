package com.ysp.subspacemod.datagen;

import com.ysp.subspacemod.SubspaceMod;
import com.ysp.subspacemod.block.ModBlocks;
import com.ysp.subspacemod.item.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import top.theillusivec4.curios.api.CuriosApi;

public class ModItemTagProvider extends ItemTagsProvider {

    private static final TagKey<Item> BELT = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(CuriosApi.MODID, "belt"));
    private static final TagKey<Item> HEAD = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(CuriosApi.MODID, "head"));
    private static final TagKey<Item> HANDS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(CuriosApi.MODID, "hands"));
    public ModItemTagProvider(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper helper) {
        super(generator, blockTags, SubspaceMod.MOD_ID, helper);
    }
    @Override
    protected void addTags() {
        tag(Tags.Items.ORES)
                .add(ModItems.RAW_SUBSPACE.get()
        );

        tag(BELT).add(
                ModItems.NANCY.get()
        );

        tag(HEAD).add(
                ModItems.QUAKE_PRO_GLASSES.get()
        );

        tag(HANDS).add(
                ModItems.OGRE_HANDS.get()
        );
    }

    @Override
    public String getName() {
        return "SubspaceMod Tags";
    }
}
