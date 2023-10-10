package com.ysp.subspacemod.util;

import com.ysp.subspacemod.SubspaceMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class ModTags {

    public static class Biomes {
        public static final TagKey<Biome> HAS_OGRE_CAVE = TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(SubspaceMod.MOD_ID, "has_structure/ogre_cave"));
    }
}
