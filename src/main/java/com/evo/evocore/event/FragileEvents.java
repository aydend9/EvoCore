package com.evo.evocore.event;

import com.evo.evocore.EvoCore;
import com.evo.evocore.effect.ModEffects;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber(modid = EvoCore.MODID)
public class FragileEvents {

    @SubscribeEvent
    public static void increaseDamageTaken(LivingDamageEvent.Pre event) {

        LivingEntity target = event.getEntity();

        if (!target.hasEffect(ModEffects.FRAGILE)) {
            return;
        }

        int level = target.getEffect(ModEffects.FRAGILE).getAmplifier() + 1;

        float bonus = 1.0F + (level * 0.10F);

        event.setNewDamage(event.getNewDamage() * bonus);
    }
}