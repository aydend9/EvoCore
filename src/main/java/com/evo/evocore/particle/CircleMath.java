package com.evo.evocore.particle;


import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.Vec3;


public class CircleMath {


    private CircleMath() {

    }


    public static void drawCircle(
            ServerLevel level,
            Vec3 center,
            MagicRing ring,
            MagicCircleEffect effect
    ) {

        float radius = ring.getRadius();


        if(effect.shouldPulse()) {

            radius += Math.sin(
                    effect.getAge() * 0.15
            ) * 0.15;

        }


        double rotation =
                effect.getAge()
                        *
                        ring.getRotationSpeed();



        float fade =
                effect.getFadeMultiplier();


        int particleAmount =
                (int)(360 * fade);


        for(int i = 0; i < particleAmount; i += 5) {


            double angle =
                    Math.toRadians(
                            i + rotation
                    );


            double x =
                    Math.cos(angle)
                            *
                            radius;


            double z =
                    Math.sin(angle)
                            *
                            radius;



            level.sendParticles(
                    ring.getParticle(),
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