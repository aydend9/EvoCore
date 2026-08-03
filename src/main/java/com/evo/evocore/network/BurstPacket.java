package com.evo.evocore.network;

import com.evo.evocore.event.BurstHandler;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record BurstPacket() implements CustomPacketPayload {

    public static final Type<BurstPacket> TYPE =
            new Type<>(ResourceLocation.fromNamespaceAndPath(
                    "evocore",
                    "burst"
            ));

    public static final StreamCodec<RegistryFriendlyByteBuf, BurstPacket> STREAM_CODEC =
            StreamCodec.unit(new BurstPacket());


    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }


    public static void sendToServer() {
        PacketDistributor.sendToServer(new BurstPacket());
    }


    public static void handle(
            BurstPacket packet,
            IPayloadContext context
    ) {
        ServerPlayer player = (ServerPlayer) context.player();

        BurstHandler.burst(player);
    }
}