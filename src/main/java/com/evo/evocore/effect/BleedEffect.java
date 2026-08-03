package com.evo.evocore.effect;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class BleedEffect extends MobEffect {

    public BleedEffect() {
        super(MobEffectCategory.HARMFUL,
                0x8B0000);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {

        if (entity instanceof ServerPlayer player) {
            player.causeFoodExhaustion(1.0F + amplifier * 0.5F);
        }

        return true;
    }
    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration % 5 == 0;
    }
}