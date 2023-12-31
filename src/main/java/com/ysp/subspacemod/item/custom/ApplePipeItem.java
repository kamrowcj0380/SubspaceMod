package com.ysp.subspacemod.item.custom;

import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import org.slf4j.Logger;


public class ApplePipeItem extends Item {
    public ApplePipeItem(Properties properties) {
        super(properties);
    }
    private final int PIPE_COOLDOWN = 100;
    private static final Logger LOGGER = LogUtils.getLogger();


    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        //Checks for the event to happen on the server, and only allows the item to be used while in the main hand
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND){
            //Applies a cooldown
            player.getCooldowns().addCooldown(this, PIPE_COOLDOWN);
            //Applies nausea 3 effect for 20 seconds
            player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 800, 2, false, false, true));
            //Applies strength 3 effect for 10 seconds
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 2, false, false, true));
            //Displays a cool message above the hotbar
            player.displayClientMessage(Component.literal("Bitchin..."), true);

            //plays a sound on use
            level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.FIRE_AMBIENT, SoundSource.NEUTRAL, 1.0F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));

            //get the item, then take one durability
            ItemStack itemStack = player.getItemInHand(hand);
            itemStack.hurtAndBreak(1, player, (entity) -> {
                entity.broadcastBreakEvent(hand);
            });
        }

        return super.use(level, player, hand);
    }
}
