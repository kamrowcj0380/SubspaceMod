package com.ysp.subspacemod.event;

import com.ysp.subspacemod.SubspaceMod;
import com.ysp.subspacemod.entity.ModEntityTypes;
import com.ysp.subspacemod.entity.custom.ShawnEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


public class ModEvents {
    @Mod.EventBusSubscriber(modid = SubspaceMod.MOD_ID)
    public static class ForgeEvents {

    }
    @Mod.EventBusSubscriber(modid = SubspaceMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents{
        @SubscribeEvent
        //Sets attributes for the shawn entity
        public static void entityAttributeEvent(EntityAttributeCreationEvent event){
            event.put(ModEntityTypes.SHAWN.get(), ShawnEntity.setAttributes());
        }
    }
}
