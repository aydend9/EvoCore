package com.evo.evocore;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.Vec3;

public class MagicCircle {

    public static void spawn(ServerLevel level, Vec3 center, int age) {

        double radius = 2.0;

        for (int i = 0; i < 360; i += 5) {

            double angle = Math.toRadians(i + age * 4);

            double x = Math.cos(angle) * radius;
            double z = Math.sin(angle) * radius;

            level.sendParticles(
                    ParticleTypes.END_ROD,
                    center.x + x,
                    center.y,
                    center.z + z,
                    1,
                    0,
                    0,
                    0,
                    0
            );
        }
    }
}