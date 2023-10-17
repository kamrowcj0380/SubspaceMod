package com.ysp.subspacemod.item.custom;

import com.google.common.collect.Multimap;
import com.ysp.subspacemod.SubspaceMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.UUID;

public class OgreHandsItem extends Item implements ICurioItem {
    public OgreHandsItem(Properties pProperties) {
        super(pProperties);
    }

    //defines damage bonus when equipped
    int damageBonus = 1;
    //defines knockback bonus when equipped
    int knockbackBonus = 2;

    //while this item is equipped, apply a damage bonus
    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slot, UUID uuid, ItemStack stack) {
        //obtains the item attributes to modify
        Multimap<Attribute, AttributeModifier> playerAttributes = ICurioItem.super.getAttributeModifiers(slot, uuid, stack);

        //sets the damage attribute change
        playerAttributes.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(uuid, new ResourceLocation(SubspaceMod.MOD_ID, "ogre_hands_damage_boost").toString(), damageBonus, AttributeModifier.Operation.ADDITION));

        //sets the knockback attribute change
        playerAttributes.put(Attributes.ATTACK_KNOCKBACK,  new AttributeModifier(uuid, new ResourceLocation(SubspaceMod.MOD_ID, "ogre_hands_knockback_boost").toString(),knockbackBonus, AttributeModifier.Operation.ADDITION));

        //returns the new attributes
        return playerAttributes;
    }
}
