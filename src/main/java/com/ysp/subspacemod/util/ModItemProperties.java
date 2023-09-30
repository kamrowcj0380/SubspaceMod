package com.ysp.subspacemod.util;

import com.mojang.logging.LogUtils;
import com.ysp.subspacemod.SubspaceMod;
import com.ysp.subspacemod.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.slf4j.Logger;

import java.util.concurrent.atomic.AtomicBoolean;

public class ModItemProperties {
    private static final Logger LOGGER = LogUtils.getLogger();

    public static void addCustomItemProperties() {
        setupApplePipe(ModItems.APPLE_PIPE.get());
    }

    private static void setupApplePipe(Item item) {
        ItemProperties.register(item, new ResourceLocation(SubspaceMod.MOD_ID, "using_pipe"), (stack, level, living, id) -> {
            //TODO: find a way to implement the line below for a non-bow related item.
            // && living.isUsingItem() && living.getUseItem() == stack
            return living != null && living.isHolding(item) ? 1.0f : 0.0f;
        });
    }
}

