package com.evo.evocore.client;

import com.evo.evocore.EvoCore;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;


@EventBusSubscriber(
        modid = EvoCore.MODID,
        value = Dist.CLIENT,
        bus = EventBusSubscriber.Bus.MOD
)
public class ClientModEvents {


    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent event) {

        event.register(ModKeyBindings.BURST);
       // event.register(ModKeyBindings.TEST_CIRCLE);

    }
}