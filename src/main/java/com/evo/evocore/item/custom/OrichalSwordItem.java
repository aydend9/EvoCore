package com.evo.evocore.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

import java.util.List;

public class OrichalSwordItem extends BaseWeaponItem {

    public OrichalSwordItem(Tier tier, Item.Properties properties) {
        super(tier, 3.0F, -2.4F, properties);
    }

    @Override
    protected void addStats(ItemStack stack, List<Component> tooltip) {
        tooltip.add(
                Component.literal("Orichalcum Weapon")
        );
    }
}

