package com.evo.evocore.event;

import com.evo.evocore.EvoCore;
import com.evo.evocore.util.DoubleJumpTracker;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber(modid = EvoCore.MODID)
public class ServerPlayerEvents {

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        if (event.getEntity().onGround()) {
            DoubleJumpTracker.reset(event.getEntity());
        }
    }
}