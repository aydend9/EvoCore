package com.evo.evocore.network;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import com.evo.evocore.EvoCore;

public record DoubleJumpPacket() implements CustomPacketPayload {
    public static final Type<DoubleJumpPacket> TYPE =
            new Type<>(ResourceLocation.fromNamespaceAndPath(EvoCore.MODID, "double_jump"));

    public static final StreamCodec<RegistryFriendlyByteBuf, DoubleJumpPacket> STREAM_CODEC =
            StreamCodec.unit(new DoubleJumpPacket());

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}