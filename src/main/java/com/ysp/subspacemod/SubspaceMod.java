package com.ysp.subspacemod;

import com.mojang.logging.LogUtils;
import com.ysp.subspacemod.block.ModBlocks;
import com.ysp.subspacemod.entity.ModEntityTypes;
import com.ysp.subspacemod.entity.client.ShawnModel;
import com.ysp.subspacemod.entity.client.ShawnRenderer;
import com.ysp.subspacemod.entity.client.AndrewModel;
import com.ysp.subspacemod.entity.client.AndrewRenderer;
import com.ysp.subspacemod.item.ModItems;
import com.ysp.subspacemod.screen.ModMenuTypes;
import com.ysp.subspacemod.screen.ShawnPhoneScreen;
import com.ysp.subspacemod.util.ModItemProperties;
import com.ysp.subspacemod.world.feature.ModConfiguredFeatures;
import com.ysp.subspacemod.world.feature.ModPlacedFeatures;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

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

        ModMenuTypes.register(modEventBus);


        //clientEvent stuff
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        modEventBus.addListener(this::commonSetup);

        //calls method for making curios slots available
        modEventBus.addListener(this::enqueueIMC);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        ModItemProperties.addCustomItemProperties();
    }

    //loads curios slots to be available to the player
    public void enqueueIMC(final InterModEnqueueEvent event){
        SlotTypePreset[] types = {SlotTypePreset.HEAD, SlotTypePreset.HANDS, SlotTypePreset.BELT};
        for (SlotTypePreset type : types){
            InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE, () -> type.getMessageBuilder().build());
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntityTypes.SHAWN.get(), ShawnRenderer::new);
            EntityRenderers.register(ModEntityTypes.ANDREW.get(), AndrewRenderer::new);

            MenuScreens.register(ModMenuTypes.SHAWN_PHONE_MENU.get(), ShawnPhoneScreen::new);

        }

        //registers new entity skin layers
        @SubscribeEvent
        public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
            event.registerLayerDefinition(ShawnModel.SHAWN_LAYER, ShawnModel::createBodyLayer);
            event.registerLayerDefinition(AndrewModel.ANDREW_LAYER, AndrewModel::createBodyLayer);
        }

        //registers renderers for new entites
        @SubscribeEvent
        public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event){
            event.registerEntityRenderer(ModEntityTypes.SHAWN.get(), ShawnRenderer::new);
            event.registerEntityRenderer(ModEntityTypes.ANDREW.get(), AndrewRenderer::new);
        }

        //adds reach distance and attack range attributes from forge to the player so they can be modified
        @SubscribeEvent
        public static void onEntityAttributeModificationEvent(final EntityAttributeModificationEvent event){
            event.add(EntityType.PLAYER, ForgeMod.REACH_DISTANCE.get());
            event.add(EntityType.PLAYER, ForgeMod.ATTACK_RANGE.get());
        }
    }
}
