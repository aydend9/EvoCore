package com.evo.evocore.item.custom;

import com.evo.evocore.effect.ModEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;

import java.util.List;

public class DaggerItem extends SwordItem {

    public DaggerItem(Tier tier, Item.Properties properties) {
        super(tier, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack,
                             LivingEntity target,
                             LivingEntity attacker) {

        if (!target.level().isClientSide()) {

            if (attacker instanceof Player player) {

                if (!player.getCooldowns().isOnCooldown(stack.getItem())) {
                    target.addEffect(new MobEffectInstance(
                            ModEffects.BLEED,
                            80,
                            1
                    ));
                    player.getCooldowns().addCooldown(stack.getItem(), 100);
                }
            }
        }
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public void appendHoverText(ItemStack stack,
                                Item.TooltipContext context,
                                List<Component> tooltip,
                                TooltipFlag flag) {

        if (Screen.hasShiftDown()) {
            tooltip.add(Component.literal("Ability")
                    .withStyle(ChatFormatting.GOLD));

            tooltip.add(Component.literal("• Inflicts Bleed II for 4 seconds.")
                    .withStyle(ChatFormatting.DARK_RED));

            tooltip.add(Component.literal("• 5 second cooldown.")
                    .withStyle(ChatFormatting.DARK_GRAY));
        } else {
            tooltip.add(Component.literal("Hold ")
                    .append(Component.literal("Shift").withStyle(ChatFormatting.YELLOW))
                    .append(" for more info.")
                    .withStyle(ChatFormatting.GRAY));
        }

        super.appendHoverText(stack, context, tooltip, flag);
    }
}