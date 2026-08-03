package com.evo.evocore.util;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.particles.ParticleTypes;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BurstTrailTracker {

    private static final Map<UUID, Integer> PLAYERS = new HashMap<>();


    public static void add(ServerPlayer player) {
        PLAYERS.put(player.getUUID(), 30);
    }


    public static void tick(ServerLevel level) {

        PLAYERS.replaceAll((uuid, ticks) -> ticks - 1);

        PLAYERS.entrySet().removeIf(entry -> {

            ServerPlayer player =
                    level.getServer()
                            .getPlayerList()
                            .getPlayer(entry.getKey());

            if (player != null) {

                level.sendParticles(
                        ParticleTypes.CLOUD,
                        player.getX(),
                        player.getY(),
                        player.getZ(),
                        20,
                        0.2,
                        0.2,
                        0.2,
                        0.02
                );
            }

            return entry.getValue() <= 0;
        });
    }
}