package com.evo.evocore.event;

import com.evo.evocore.particle.MagicCircleManager;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.LevelTickEvent;

@EventBusSubscriber
public class ServerEvents {

    @SubscribeEvent
    public static void onLevelTick(LevelTickEvent.Post event) {

        if (!(event.getLevel() instanceof ServerLevel serverLevel)) {
            return;
        }

        MagicCircleManager.tick(serverLevel);
    }
}