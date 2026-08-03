package com.evo.evocore.particle;


import com.evo.evocore.particle.shapes.MagicShape;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;



public class MagicCircleRenderer {


    public static void render(
            ServerLevel level,
            MagicCircleEffect effect
    ) {


        for(MagicRing ring : effect.getRings()) {


            CircleMath.drawCircle(
                    level,
                    effect.getCenter(),
                    ring,
                    effect
            );

        }



        for(MagicShape shape : effect.getShapes()) {

            shape.draw(
                    level,
                    effect.getCenter(),
                    ParticleTypes.ENCHANT,
                    effect.getAge() * 0.2f,
                    3f
            );

        }

    }

}