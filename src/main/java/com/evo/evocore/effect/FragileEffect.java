package com.evo.evocore.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class FragileEffect extends MobEffect {

    public FragileEffect() {
        super(
                MobEffectCategory.HARMFUL,
                0x8B0000
        );
    }
}