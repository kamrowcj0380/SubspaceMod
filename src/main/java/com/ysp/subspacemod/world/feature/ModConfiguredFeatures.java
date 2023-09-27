package com.ysp.subspacemod.world.feature;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.ysp.subspacemod.SubspaceMod;
import com.ysp.subspacemod.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, SubspaceMod.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_SUBSPACE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SUBSPACE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_SUBSPACE_ORE.get().defaultBlockState())
    ));

    /*
    ******* Implementation for nether spawns, also can use target(new BlockMatchTest(Blocks.END_STONE), ModBlocks... for end *******

    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_SUBSPACE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.SUBSPACE_ORE.get().defaultBlockState()) ));

    * */

    public static final RegistryObject<ConfiguredFeature<?, ?>> SUBSPACE_ORE = CONFIGURED_FEATURES.register("subspace_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_SUBSPACE_ORES.get(), 15)));
    //last number in line above is the vein size



    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
