package com.ysp.subspacemod.screen;

import com.ysp.subspacemod.item.ModItems;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public class ShawnPhoneMenu extends AbstractContainerMenu {
    //client constructor
    public ShawnPhoneMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
        this(id, inv);
    }
    //server constructor
    public ShawnPhoneMenu(int id, Inventory inv){
        super(ModMenuTypes.SHAWN_PHONE_MENU.get(), id);
    }


    @Override
    public ItemStack quickMoveStack(Player p_38941_, int p_38942_) {
        return null;
    }

    //checks that the player is holding shawns phone item
    @Override
    public boolean stillValid(Player player) {
        if(player.getMainHandItem().is(ModItems.SHAWN_PHONE.get())){
            return true;
        }
        else{
            return false;
        }
    }
}
