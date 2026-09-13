package com.evo.evocore.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item;

import java.util.List;

public abstract class BaseWeaponItem extends SwordItem {

    public BaseWeaponItem(
            Tier tier,
            float attackDamage,
            float attackSpeed,
            Item.Properties properties
    ) {
        super(
                tier,
                properties.attributes(
                        SwordItem.createAttributes(
                                tier,
                                attackDamage,
                                attackSpeed
                        )
                )
        );
    }

    @Override
    public void appendHoverText(
            ItemStack stack,
            TooltipContext context,
            List<Component> tooltip,
            TooltipFlag flag
    ) {
        if (Screen.hasShiftDown()) {
            tooltip.add(
                    Component.literal("Evocore Weapon")
                            .withStyle(ChatFormatting.GOLD)
            );

            addStats(stack, tooltip);

        } else {
            tooltip.add(
                    Component.literal("Hold ")
                            .append(
                                    Component.literal("Shift")
                                            .withStyle(ChatFormatting.YELLOW)
                            )
                            .append(" for more info.")
                            .withStyle(ChatFormatting.GRAY)
            );
        }

        super.appendHoverText(stack, context, tooltip, flag);
    }

    protected abstract void addStats(
            ItemStack stack,
            List<Component> tooltip
    );
}