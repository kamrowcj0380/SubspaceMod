package com.ysp.subspacemod.datagen;

import com.ysp.subspacemod.SubspaceMod;
import com.ysp.subspacemod.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
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
        simpleItem(ModItems.SHAWN_AVIATORS);
        simpleItem(ModItems.NANCY);
        simpleItem(ModItems.SHAWN_PHONE);
        simpleItem(ModItems.PAINFUL_MAC_AND_CHEESE);
        simpleItem(ModItems.PUZZLE_CUBE);
        simpleItem(ModItems.PLASTIC_SPOON);

        simpleItem(ModItems.ANDREW_SOUL);
        simpleItem(ModItems.ANGELO_SOUL);
        simpleItem(ModItems.CONNOR_SOUL);
        simpleItem(ModItems.JEVAN_SOUL);
        simpleItem(ModItems.SHAWN_SOUL);
        simpleItem(ModItems.TANNER_SOUL);
        simpleItem(ModItems.WILL_SOUL);

        simpleItem(ModItems.TRIP_HAT);
        simpleItem(ModItems.ROSENDALE_SHIRT);
        simpleItem(ModItems.CHURCH_PANTS);
        simpleItem(ModItems.CLOWN_SHOES);


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