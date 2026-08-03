package com.evo.evocore.event;

import com.evo.evocore.enchantment.ModEnchantments;
import com.evo.evocore.util.BurstTrailTracker;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.phys.Vec3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class BurstHandler {

    private static final Map<UUID, Integer> COOLDOWNS = new HashMap<>();


    public static void tickCooldowns(ServerLevel level) {
        Iterator<Map.Entry<UUID, Integer>> iterator = COOLDOWNS.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<UUID, Integer> entry = iterator.next();

            int time = entry.getValue() - 1;

            if (time <= 0) {
                ServerPlayer player = level.getServer().getPlayerList().getPlayer(entry.getKey());

                if (player != null) {
                    player.level().playSound(
                            null,
                            player.getX(),
                            player.getY(),
                            player.getZ(),
                            SoundEvents.EXPERIENCE_ORB_PICKUP,
                            SoundSource.PLAYERS,
                            1.0F,
                            1.5F
                    );
                }

                iterator.remove();
            } else {
                entry.setValue(time);
            }
        }
    }


    public static void burst(ServerPlayer player) {

        if (COOLDOWNS.containsKey(player.getUUID()))
            return;


        ItemStack leggings =
                player.getItemBySlot(EquipmentSlot.LEGS);


        Holder<net.minecraft.world.item.enchantment.Enchantment> burst =
                player.level()
                        .registryAccess()
                        .registryOrThrow(Registries.ENCHANTMENT)
                        .getHolderOrThrow(ModEnchantments.BURST);


        int level =
                EnchantmentHelper.getItemEnchantmentLevel(
                        burst,
                        leggings
                );


        if (level <= 0)
            return;


        Vec3 look = player.getLookAngle();


        double power = 1.5 + (level * 0.25);



        player.push(
                look.x * power,
                look.y * power,
                look.z * power
        );

        player.hurtMarked = true;

        BurstTrailTracker.add(player);


        player.level().playSound(
                null,
                player.getX(),
                player.getY(),
                player.getZ(),
                SoundEvents.BREEZE_WIND_CHARGE_BURST.value(),
                SoundSource.PLAYERS,
                1.5F,
                1.5F
        );


        ServerLevel serverLevel = player.serverLevel();

        serverLevel.sendParticles(
                ParticleTypes.CLOUD,
                player.getX(),
                player.getY(),
                player.getZ(),
                25,
                0.3,
                0.3,
                0.3,
                0.1
        );


        COOLDOWNS.put(
                player.getUUID(),
                100
        );
    }
}