package com.evo.evocore.particle.shapes;


import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.Vec3;
import net.minecraft.core.particles.ParticleOptions;


public class CircleShape implements MagicShape {


    @Override
    public void draw(
            ServerLevel level,
            Vec3 center,
            ParticleOptions particle,
            float rotation,
            float size
    ) {


        for(int i = 0; i < 360; i += 5) {


            double angle =
                    Math.toRadians(i + rotation);



            double x =
                    Math.cos(angle)
                            * size;


            double z =
                    Math.sin(angle)
                            * size;



            level.sendParticles(
                    particle,
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