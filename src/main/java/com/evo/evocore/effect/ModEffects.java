package com.evo.evocore.effect;

import com.evo.evocore.EvoCore;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModEffects {

    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(Registries.MOB_EFFECT, EvoCore.MODID);


    public static final DeferredHolder<MobEffect, MobEffect> FRAGILE =
            EFFECTS.register(
                    "fragile",
                    FragileEffect::new
            );
    public static final DeferredHolder<MobEffect, MobEffect> BLEED =
            EFFECTS.register(
                    "bleed",
                    BleedEffect::new
            );
    public static final DeferredHolder<MobEffect, MobEffect> STELLERFLAME =
            EFFECTS.register(
                    "stellerflame",
                    StellerflameEffect::new
            );


    public static void register(net.neoforged.bus.api.IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }
}