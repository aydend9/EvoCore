package com.evo.evocore.network;

import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public class ModNetworking {

    public static void register(RegisterPayloadHandlersEvent event) {

        PayloadRegistrar registrar =
                event.registrar("1");

        registrar.playToServer(
                BurstPacket.TYPE,
                BurstPacket.STREAM_CODEC,
                BurstPacket::handle
        );
    }
}