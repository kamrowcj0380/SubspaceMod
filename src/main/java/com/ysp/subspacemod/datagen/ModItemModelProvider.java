package com.ysp.subspacemod.datagen;

import com.ysp.subspacemod.SubspaceMod;
import com.ysp.subspacemod.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, SubspaceMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.SUBSPACE);
        simpleItem(ModItems.RAW_SUBSPACE);
        simpleItem(ModItems.APPLE_PIPE);
        simpleItem(ModItems.OGRE_HANDS);
        simpleItem(ModItems.QUAKE_PRO_GLASSES);
        simpleItem(ModItems.NANCY);
        simpleItem(ModItems.SHAWN_PHONE);
        simpleItem(ModItems.PAINFUL_MAC_AND_CHEESE);


        withExistingParent(ModItems.SHAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    //creates json file for a regular item being held (ex. Apple)
    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
            new ResourceLocation("item/generated")).texture("layer0",
            new ResourceLocation(SubspaceMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    //creates json file for a handheld item (ex. Pickaxe)
    private ItemModelBuilder handheldItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(SubspaceMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}