package com.ysp.subspacemod.item.custom;

import com.google.common.collect.Multimap;
import com.ysp.subspacemod.SubspaceMod;
import com.ysp.subspacemod.client.ShawnAviatorsOverlay;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;
import java.util.UUID;

public class ShawnAviatorsItem extends Item implements ICurioItem {

    //IGuiOverlay aviators = new ShawnAviatorsOverlay();
    public ShawnAviatorsItem(Properties pProperties) {
        super(pProperties);
    }

    //adds swiftness and unlucky effects while equipped
    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        if (!slotContext.entity().level.isClientSide && slotContext.entity().tickCount % 15 == 0) {
            slotContext.entity().addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 250, 0, false, false, true));
            //slotContext.entity().addEffect(new MobEffectInstance(MobEffects.UNLUCK, 250, 2, false, false, false));
        }
    }

    int luckModifier = -1000;
    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slot, UUID uuid, ItemStack stack) {
        //obtains the item attributes to modify
        Multimap<Attribute, AttributeModifier> playerAttributes = ICurioItem.super.getAttributeModifiers(slot, uuid, stack);

        //sets the damage attribute change
        playerAttributes.put(Attributes.LUCK, new AttributeModifier(uuid, new ResourceLocation(SubspaceMod.MOD_ID, "aviators_luck_boost").toString(), luckModifier, AttributeModifier.Operation.ADDITION));

        //returns the new attributes
        return playerAttributes;
    }

    @Override
    public List<Component> getAttributesTooltip(List<Component> tooltips, ItemStack stack) {
        tooltips.clear();
        return ICurioItem.super.getAttributesTooltip(tooltips, stack);
    }
}
