package com.ysp.subspacemod.item.custom;

import com.ysp.subspacemod.client.ShawnAviatorsOverlay;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class ShawnAviatorsItem extends Item implements ICurioItem {

    IGuiOverlay aviators = new ShawnAviatorsOverlay();
    public ShawnAviatorsItem(Properties pProperties) {
        super(pProperties);
    }

    //adds swiftness and unlucky effects while equipped
    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        if (!slotContext.entity().level.isClientSide && slotContext.entity().tickCount % 15 == 0) {
            slotContext.entity().addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 250, 0, false, false, true));
            slotContext.entity().addEffect(new MobEffectInstance(MobEffects.UNLUCK, 250, 2, false, false, false));
        }
    }
}
