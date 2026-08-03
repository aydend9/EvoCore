package com.evo.evocore.event;

import com.evo.evocore.EvoCore;
import com.evo.evocore.item.ModItems;
import com.evo.evocore.tag.ModTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingKnockBackEvent;

@EventBusSubscriber(modid = EvoCore.MODID)
    public class ModItemEvents {

    @SubscribeEvent
    public static void onKnockback(LivingKnockBackEvent event) {
        LivingEntity target = event.getEntity();

        if (target.getLastHurtByMob() instanceof Player attacker
                && attacker.getMainHandItem().is(ModTags.PULL_WEAPONS)) {

            event.setRatioX(event.getOriginalRatioX() * -0.5D);
            event.setRatioZ(event.getOriginalRatioZ() * -0.5D);
        }
    }
}