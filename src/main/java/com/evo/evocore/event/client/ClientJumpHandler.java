package com.evo.evocore.event.client;

import com.evo.evocore.EvoCore;
import com.evo.evocore.network.DoubleJumpPacket;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;

@EventBusSubscriber(modid = EvoCore.MODID, value = Dist.CLIENT)
public class ClientJumpHandler {

    private static boolean wasJumpDown = false;
    private static int ticksAirborne = 0;
    private static final int GRACE_PERIOD = 4;

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        var mc = Minecraft.getInstance();
        var player = mc.player;
        if (player == null) return;

        boolean jumpDown = mc.options.keyJump.isDown();
        boolean justPressed = jumpDown && !wasJumpDown;
        wasJumpDown = jumpDown;

        if (player.onGround()) {
            ticksAirborne = 0;
        } else {
            ticksAirborne++;
        }

        boolean pastGracePeriod = ticksAirborne > GRACE_PERIOD;

        if (justPressed && !player.onGround() && pastGracePeriod && !player.getAbilities().flying) {
            net.neoforged.neoforge.network.PacketDistributor.sendToServer(new DoubleJumpPacket());
        }
    }
}