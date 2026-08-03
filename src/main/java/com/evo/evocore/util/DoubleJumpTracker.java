package com.evo.evocore.util;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DoubleJumpTracker {
    private static final Map<UUID, Integer> usedJumps = new HashMap<>();

    public static int getUsed(Player player) {
        return usedJumps.getOrDefault(player.getUUID(), 0);
    }

    public static void increment(Player player) {
        usedJumps.merge(player.getUUID(), 1, Integer::sum);
    }

    public static void reset(Player player) {
        usedJumps.remove(player.getUUID());
    }
}
