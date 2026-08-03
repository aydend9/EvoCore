package com.evo.evocore.client;

import com.evo.evocore.EvoCore;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(
        modid = EvoCore.MODID,
        bus = EventBusSubscriber.Bus.MOD
)
public class ClientItemRenderers {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {

    }
}