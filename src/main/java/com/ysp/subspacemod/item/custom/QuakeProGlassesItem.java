package com.ysp.subspacemod.item.custom;

import com.google.common.collect.Multimap;
import com.ysp.subspacemod.SubspaceMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeMod;
import org.checkerframework.checker.units.qual.A;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.UUID;

public class QuakeProGlassesItem extends Item implements ICurioItem {
    public QuakeProGlassesItem(Properties pProperties) {
        super(pProperties);
    }
    //defines reach increase
    int reachIncrease = 2;
    //defines attack range increase
    int attackRangeIncrease = 1;
    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slot, UUID uuid, ItemStack stack) {
        //obtains the item attributes to modify
        Multimap<Attribute, AttributeModifier> playerAttributes = ICurioItem.super.getAttributeModifiers(slot, uuid, stack);

        //checks if reach distance is applied to the entity, then adds modifier
        if(ForgeMod.REACH_DISTANCE.isPresent()){
            playerAttributes.put(ForgeMod.REACH_DISTANCE.get(), new AttributeModifier(uuid, new ResourceLocation(SubspaceMod.MOD_ID, "quake_pro_reach_boost").toString(), reachIncrease, AttributeModifier.Operation.ADDITION));
        }

        //checks if attack range is applied to the entity, then adds modifier
        if(ForgeMod.ATTACK_RANGE.isPresent()){
            playerAttributes.put(ForgeMod.ATTACK_RANGE.get(), new AttributeModifier(uuid, new ResourceLocation(SubspaceMod.MOD_ID, "quake_pro_attack_reach_boost").toString(), attackRangeIncrease, AttributeModifier.Operation.ADDITION));
        }

        //returns the new attributes
        return playerAttributes;
    }
}
