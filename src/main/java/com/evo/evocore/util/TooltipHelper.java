package com.evo.evocore.util;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

public class TooltipHelper {

    public static Component damage(String text) {
        return Component.literal(text)
                .withStyle(ChatFormatting.RED);
    }

    public static Component passive(String text) {
        return Component.literal(text)
                .withStyle(ChatFormatting.GOLD);
    }

    public static Component effect(String text) {
        return Component.literal(text)
                .withStyle(ChatFormatting.YELLOW);
    }

    public static Component flavor(String text) {
        return Component.literal(text)
                .withStyle(ChatFormatting.GRAY);
    }

    public static Component rarity(String text) {
        return Component.literal(text)
                .withStyle(ChatFormatting.AQUA);
    }
}