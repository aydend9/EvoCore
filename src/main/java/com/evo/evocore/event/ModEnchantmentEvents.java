package com.evo.evocore.event;

import com.evo.evocore.EvoCore;
import com.evo.evocore.enchantment.ModEnchantments;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;

import java.util.List;

@EventBusSubscriber(modid = EvoCore.MODID)
public class ModEnchantmentEvents {

    @SubscribeEvent
    public static void onAttack(AttackEntityEvent event) {
        Player player = event.getEntity();
        Level level = player.level();
        if (level.isClientSide) return;

        ItemStack weapon = player.getMainHandItem();
        var registry = level.registryAccess().registryOrThrow(Registries.ENCHANTMENT);
        Holder<net.minecraft.world.item.enchantment.Enchantment> cleave =
                registry.getHolderOrThrow(ModEnchantments.Cleave);

        int lvl = weapon.getEnchantmentLevel(cleave);
        if (lvl <= 0) return;

        Entity primaryTarget = event.getTarget();
        double radius = 2.0 + (lvl * 0.5);
        float cleaveDamage = 2.0F + lvl;
        double arcDegrees = 90;

        AABB area = primaryTarget.getBoundingBox().inflate(radius);
        List<LivingEntity> nearby = level.getEntitiesOfClass(LivingEntity.class, area,
                e -> e != primaryTarget && e != player && e.isAlive());

        for (LivingEntity target : nearby) {
            if (isInArc(player, target, arcDegrees)) {
                target.hurt(player.damageSources().playerAttack(player), cleaveDamage);
            }
        }

        spawnCleaveParticles((ServerLevel) level, player, radius, arcDegrees, lvl);
    }

    private static boolean isInArc(Player player, Entity target, double arcDegrees) {
        Vec3 look = player.getLookAngle().normalize();
        Vec3 toTarget = target.position().subtract(player.position()).normalize();
        double angle = Math.toDegrees(Math.acos(look.dot(toTarget)));
        return angle <= arcDegrees / 2.0;
    }

    private static void spawnCleaveParticles(ServerLevel level, Player player, double radius, double arcDegrees, int lvl) {
        Vec3 center = player.position().add(0, player.getBbHeight() / 2, 0);
        double lookYaw = Math.toRadians(-player.getYRot());

        int pointsPerLevel = 6;
        int totalPoints = pointsPerLevel * lvl;

        for (int i = 0; i < totalPoints; i++) {
            double t = (double) i / (totalPoints - 1);
            double angleOffset = Math.toRadians(-arcDegrees / 2.0 + arcDegrees * t);
            double finalAngle = lookYaw + angleOffset;

            double x = center.x + Math.sin(finalAngle) * radius;
            double z = center.z + Math.cos(finalAngle) * radius;
            double y = center.y + (level.random.nextDouble() - 0.5) * 0.5;

            level.sendParticles(ParticleTypes.WHITE_SMOKE, x, y, z, 1, 0, 0, 0, 0);
        }
    }
}