package com.ysp.subspacemod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Random;

public class PuzzleCubeItem extends Item {

    private final int PIPE_COOLDOWN = 500;
    public PuzzleCubeItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        //Checks for the event to happen on the server, and only allows the item to be used while in the main hand
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND){

            //Applies a cooldown
            player.getCooldowns().addCooldown(this, PIPE_COOLDOWN);

            //Applies a random potion effect from a preselected list
            player.addEffect(PickPotionEffect());

            //get the item, then take one durability
            ItemStack itemStack = player.getItemInHand(hand);
            itemStack.hurtAndBreak(1, player, (entity) -> {
                entity.broadcastBreakEvent(hand);
            });
        }

        return super.use(level, player, hand);
    }

    private MobEffectInstance PickPotionEffect(){
        //picks a random number between 1 and 4 to determine the effect
        Random random = new Random();
        int num = random.ints(1, 5).findFirst().getAsInt();

        //takes the random number and returns an effect based on what it is
        switch(num){
            case 1:
                return new MobEffectInstance(MobEffects.ABSORPTION, 4800, 1, false, false, false);
            case 2:
                return new MobEffectInstance(MobEffects.DARKNESS, 1400, 0, false, false, false);
            case 3:
                return new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 4800, 1, false, false, false);
            case 4:
                return new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1400, 1, false, false, false);
            case 5:
                return new MobEffectInstance(MobEffects.INVISIBILITY, 1400, 0, false, false, false);
            default:
                return new MobEffectInstance(MobEffects.INVISIBILITY, 1400, 0, false, false, false);
        }
    }
}
