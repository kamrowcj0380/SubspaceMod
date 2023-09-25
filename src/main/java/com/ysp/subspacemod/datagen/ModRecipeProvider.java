package com.ysp.subspacemod.datagen;

import com.ysp.subspacemod.block.ModBlocks;
import com.ysp.subspacemod.item.ModItems;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(DataGenerator output) {
        super(output);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer){
        //creates a recipe for raw subspace to smelt into subspace
        oreSmelting(consumer, List.of(ModItems.RAW_SUBSPACE.get()), ModItems.SUBSPACE.get(), 0.7f, 200, "subspace");

        //creates a recipe for a subspace block making 9 subspace and 9 subspace making a subspace block
        nineBlockStorageRecipes(consumer, ModItems.SUBSPACE.get(), ModBlocks.SUBSPACE_BLOCK.get());
    }
}
