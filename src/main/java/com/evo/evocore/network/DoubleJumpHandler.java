package com.evo.evocore.network;

import com.evo.evocore.enchantment.ModEnchantments;
import com.evo.evocore.util.DoubleJumpTracker;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.phys.Vec3;

public class DoubleJumpHandler {

    public static void handle(Player player) {
        if (!(player instanceof ServerPlayer serverPlayer)) return;

        ItemStack boots = serverPlayer.getItemBySlot(EquipmentSlot.FEET);
        var registry = serverPlayer.level().registryAccess().registryOrThrow(Registries.ENCHANTMENT);
        Holder<Enchantment> doubleJump = registry.getHolderOrThrow(ModEnchantments.DOUBLE_JUMP);

        int lvl = boots.getEnchantmentLevel(doubleJump);
        if (lvl <= 0) return;

        int used = DoubleJumpTracker.getUsed(serverPlayer);
        if (used >= lvl) return;

        DoubleJumpTracker.increment(serverPlayer);

        Vec3 v = serverPlayer.getDeltaMovement();

        double horizontalX = v.x;
        double horizontalZ = v.z;

        if (serverPlayer.isSprinting()) {
            Vec3 look = serverPlayer.getLookAngle();
            double boostStrength = 0.25;
            horizontalX += look.x * boostStrength;
            horizontalZ += look.z * boostStrength;
        }

        serverPlayer.setDeltaMovement(horizontalX, 0.6, horizontalZ);
        serverPlayer.hasImpulse = true;


        ServerLevel level = serverPlayer.serverLevel();

        level.sendParticles(
                ParticleTypes.CLOUD,
                serverPlayer.getX(),
                serverPlayer.getY() - 0.5,
                serverPlayer.getZ(),
                15,
                0.2,
                0.1,
                0.2,
                0.05
        );

        serverPlayer.connection.send(
                new ClientboundSetEntityMotionPacket(serverPlayer)
        );
    }
}