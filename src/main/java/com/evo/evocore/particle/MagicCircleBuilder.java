package com.evo.evocore.particle;


import com.evo.evocore.particle.shapes.MagicShape;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.phys.Vec3;


public class MagicCircleBuilder {


    private final MagicCircleEffect effect;



    private MagicCircleBuilder(Vec3 position) {

        effect = new MagicCircleEffect(
                position,
                120
        );


    }



    public static MagicCircleBuilder create(Vec3 position) {

        return new MagicCircleBuilder(position);

    }




    public MagicCircleBuilder ring(
            float radius,
            ParticleOptions particle,
            float speed
    ) {

        effect.addRing(
                new MagicRing(
                        radius,
                        particle,
                        speed
                )
        );


        return this;
    }
    public MagicCircleBuilder fade(
            int fadeIn,
            int fadeOut
    ) {

        effect.setFadeTimes(
                fadeIn,
                fadeOut
        );

        return this;
    }




    public MagicCircleBuilder pulse(boolean value) {

        effect.setPulse(value);

        return this;

    }



    public MagicCircleBuilder star(
            int points,
            float radius
    ) {

        effect.createStar(
                points,
                radius
        );


        return this;

    }



    public MagicCircleBuilder duration(int ticks) {

        effect.setDuration(ticks);

        return this;

    }




    public MagicCircleEffect build() {

        MagicCircleManager.add(effect);

        return effect;

    }
    public MagicCircleBuilder shape(
            MagicShape shape
    ) {

        effect.addShape(shape);

        return this;

    }

}