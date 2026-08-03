package com.evo.evocore.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public abstract class BaseWeaponItem extends Item {

    public BaseWeaponItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack,
                                TooltipContext context,
                                List<Component> tooltip,
                                TooltipFlag flag) {

        addStats(stack, tooltip);

        tooltip.add(Component.empty());

        tooltip.add(Component.literal("Evocore Weapon")
                .withStyle(ChatFormatting.DARK_GRAY));

        super.appendHoverText(stack, context, tooltip, flag);
    }

    protected abstract void addStats(ItemStack stack, List<Component> tooltip);
}