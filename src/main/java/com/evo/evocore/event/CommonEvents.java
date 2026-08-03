package com.evo.evocore.event;

import com.evo.evocore.util.BurstTrailTracker;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

@EventBusSubscriber
public class CommonEvents {

    @SubscribeEvent
    public static void onServerTick(ServerTickEvent.Post event) {
        BurstHandler.tickCooldowns(event.getServer().overworld());
        for (var level : event.getServer().getAllLevels()) {
            BurstTrailTracker.tick(level);
        }
    }
}