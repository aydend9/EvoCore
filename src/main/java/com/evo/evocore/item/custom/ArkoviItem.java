package com.evo.evocore.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class ArkoviItem extends SwordItem {

    public ArkoviItem(Tier tier, Properties properties) {
        super(tier, properties);
    }
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        if (target instanceof Player player && player.isBlocking()) {
            player.getCooldowns().addCooldown(Items.SHIELD, 100);
            player.stopUsingItem();
            player.level().broadcastEntityEvent(player, (byte) 30);
        }

        return super.hurtEnemy(stack, target, attacker);
    }
}
