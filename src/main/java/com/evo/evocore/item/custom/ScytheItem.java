package com.evo.evocore.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;

import java.util.List;

public class ScytheItem extends SwordItem {

    public ScytheItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack,
                                Item.TooltipContext context,
                                List<Component> tooltip,
                                TooltipFlag flag) {

        if (Screen.hasShiftDown()) {
            tooltip.add(Component.literal("Passive")
                    .withStyle(ChatFormatting.GOLD));

            tooltip.add(Component.literal("• Reversed Knockback When Used.")
                    .withStyle(ChatFormatting.DARK_RED));
        } else {
            tooltip.add(Component.literal("Hold ")
                    .append(Component.literal("Shift").withStyle(ChatFormatting.YELLOW))
                    .append(" for more info.")
                    .withStyle(ChatFormatting.GRAY));
        }

        super.appendHoverText(stack, context, tooltip, flag);
    }
}