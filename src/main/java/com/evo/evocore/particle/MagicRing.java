package com.evo.evocore.particle;

import net.minecraft.core.particles.ParticleOptions;


public class MagicRing {

    private final float radius;
    private final ParticleOptions particle;
    private final float rotationSpeed;
    private final boolean clockwise;


    public MagicRing(
            float radius,
            ParticleOptions particle,
            float rotationSpeed
    ) {

        this.radius = radius;
        this.particle = particle;
        this.rotationSpeed = rotationSpeed;

        this.clockwise = rotationSpeed >= 0;
    }


    public float getRadius() {
        return radius;
    }


    public ParticleOptions getParticle() {
        return particle;
    }


    public float getRotationSpeed() {
        return rotationSpeed;
    }


    public boolean isClockwise() {
        return clockwise;
    }
}