package com.evo.evocore.network;

import com.evo.evocore.particle.MagicCircleBuilder;
import com.evo.evocore.particle.shapes.StarShape;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;


public record CirclePacket() implements CustomPacketPayload {


    public static final Type<CirclePacket> TYPE =
            new Type<>(
                    ResourceLocation.fromNamespaceAndPath(
                            "evocore",
                            "circle"
                    )
            );


    public static final StreamCodec<RegistryFriendlyByteBuf, CirclePacket> STREAM_CODEC =
            StreamCodec.unit(new CirclePacket());


    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }


    public static void sendToServer() {

        PacketDistributor.sendToServer(
                new CirclePacket()
        );

    }


    public static void handle(
            CirclePacket packet,
            IPayloadContext context
    ) {


        ServerPlayer player =
                (ServerPlayer) context.player();


        Vec3 position =
                player.position();


        MagicCircleBuilder.create(position)

                .ring(
                        3f,
                        ParticleTypes.END_ROD,
                        2f
                )

                .shape(
                        new StarShape(5)
                )

                .pulse(true)

                .fade(20, 20)

                .duration(120)

                .build();
    }
}