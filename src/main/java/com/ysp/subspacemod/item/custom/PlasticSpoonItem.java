package com.ysp.subspacemod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class PlasticSpoonItem extends Item implements ICurioItem {
    public PlasticSpoonItem(Properties pProperties) {
        super(pProperties);
    }

    //applies the luck effect to the player while item is equipped
    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        if (!slotContext.entity().level.isClientSide && slotContext.entity().tickCount % 15 == 0) {
            slotContext.entity().addEffect(new MobEffectInstance(MobEffects.LUCK, 250, 0, false, false, true));
        }
    }
}
