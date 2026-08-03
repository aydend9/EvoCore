package com.evo.evocore.particle.shapes;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.Vec3;
import net.minecraft.core.particles.ParticleOptions;

public interface MagicShape {


    void draw(
            ServerLevel level,
            Vec3 center,
            ParticleOptions particle,
            float rotation,
            float size
    );

}