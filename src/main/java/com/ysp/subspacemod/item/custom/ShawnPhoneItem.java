package com.ysp.subspacemod.item.custom;

import com.ysp.subspacemod.screen.ShawnPhoneMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

public class ShawnPhoneItem extends Item implements MenuProvider {
    public ShawnPhoneItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        //Checks for the event to happen on the server, and only allows the item to be used while in the main hand
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND){
            NetworkHooks.openScreen((ServerPlayer) player, this);
        }

        return super.use(level, player, hand);
    }


    @Override
    public Component getDisplayName() {
        return Component.literal("Shawn's Phone");
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return new ShawnPhoneMenu(id, inv);
    }
}
