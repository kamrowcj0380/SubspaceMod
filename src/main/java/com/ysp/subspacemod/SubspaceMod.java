package com.ysp.subspacemod;

import com.mojang.logging.LogUtils;
import com.ysp.subspacemod.block.ModBlocks;
import com.ysp.subspacemod.entity.ModEntityTypes;
import com.ysp.subspacemod.entity.client.ShawnModel;
import com.ysp.subspacemod.entity.client.ShawnRenderer;
import com.ysp.subspacemod.entity.custom.ShawnEntity;
import com.ysp.subspacemod.item.ModItems;
import com.ysp.subspacemod.world.feature.ModConfiguredFeatures;
import com.ysp.subspacemod.world.feature.ModPlacedFeatures;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SubspaceMod.MOD_ID)
public class SubspaceMod
{
    public static final String MOD_ID = "subspacemod";
    private static final Logger LOGGER = LogUtils.getLogger();
    public SubspaceMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        //items and blocks
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        //features
        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);

        //entities
        ModEntityTypes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntityTypes.SHAWN.get(), ShawnRenderer::new);
        }

        @SubscribeEvent
        public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
            event.registerLayerDefinition(ShawnModel.SHAWN_LAYER, ShawnModel::createBodyLayer);
        }

        @SubscribeEvent
        public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event){
            event.registerEntityRenderer(ModEntityTypes.SHAWN.get(), ShawnRenderer::new);
        }
    }
}
