package com.ysp.subspacemod.entity;

import com.ysp.subspacemod.SubspaceMod;
import com.ysp.subspacemod.entity.custom.ShawnEntity;
import com.ysp.subspacemod.entity.custom.AndrewEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    //Note: All new entities must have their attributes set or the game will crash when it spawns.
    //Call its 'setAttributes' method in the Mod Events class
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SubspaceMod.MOD_ID);

    //Registers shawn mob with same size attributes as a zombie
    public static final RegistryObject<EntityType<ShawnEntity>> SHAWN =
            ENTITY_TYPES.register("shawn", () -> EntityType.Builder.of(ShawnEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.95f).build(new ResourceLocation(SubspaceMod.MOD_ID, "shawn").toString()));

    public static final RegistryObject<EntityType<AndrewEntity>> ANDREW =
            ENTITY_TYPES.register("andrew", () -> EntityType.Builder.of(AndrewEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.95f).build(new ResourceLocation(SubspaceMod.MOD_ID, "andrew").toString()));


    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
