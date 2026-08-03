package com.evo.evocore.event;

import com.evo.evocore.effect.ModEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

@EventBusSubscriber
public class StellerflameEvents {

    @SubscribeEvent
    public static void onEntityTick(EntityTickEvent.Post event) {

        if (!(event.getEntity() instanceof LivingEntity entity))
            return;

        MobEffectInstance effect = entity.getEffect(ModEffects.STELLERFLAME);

        if (effect == null)
            return;

        if (entity.tickCount % 10 != 0)
            return;

        int amplifier = effect.getAmplifier();
        float damage = 0.25F * (amplifier + 1);

        DamageSource source = entity.level()
                .damageSources()
                .magic();

        entity.invulnerableTime = 0;
        entity.hurt(source, damage);
        entity.invulnerableTime = 0;
    }
}