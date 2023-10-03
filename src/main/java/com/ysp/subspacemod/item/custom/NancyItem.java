package com.ysp.subspacemod.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class NancyItem extends Item {
    public NancyItem(Properties pProperties) {
        super(pProperties);
    }

    //Method for lighting entity on fire when right clicked on
    @Override
    public InteractionResult interactLivingEntity(ItemStack pStack, Player pPlayer, LivingEntity pInteractionTarget, InteractionHand pUsedHand) {
        if(pUsedHand == InteractionHand.MAIN_HAND){
            pInteractionTarget.setSecondsOnFire(8);

            //get the item, then take one durability
            ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);
            itemStack.hurtAndBreak(1, pPlayer, (entity) -> {
                entity.broadcastBreakEvent(pUsedHand);
            });

        }

        return super.interactLivingEntity(pStack, pPlayer, pInteractionTarget, pUsedHand);
    }
}
