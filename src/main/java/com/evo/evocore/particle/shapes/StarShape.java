package com.evo.evocore.particle.shapes;


import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.Vec3;


public class StarShape implements MagicShape {


    private final int points;


    public StarShape(int points) {

        this.points = points;

    }



    @Override
    public void draw(
            ServerLevel level,
            Vec3 center,
            ParticleOptions particle,
            float rotation,
            float size
    ) {


        int vertices = points * 2;


        Vec3[] positions =
                new Vec3[vertices];
        for(int i = 0; i < vertices; i++) {


            double radius =
                    (i % 2 == 0)
                            ? size
                            : size * 0.45;



            double angle =
                    Math.toRadians(
                            rotation +
                                    (360.0 / vertices) * i
                    );



            positions[i] =
                    new Vec3(
                            Math.cos(angle) * radius,
                            0,
                            Math.sin(angle) * radius
                    );

        }
        for(int i = 0; i < vertices; i++) {


            int next =
                    (i + 1) % vertices;



            drawLine(
                    level,
                    center,
                    particle,
                    positions[i],
                    positions[next]
            );

        }

        if(points == 5) {


            for(int i = 0; i < vertices; i += 2) {


                int next =
                        (i + 4) % vertices;



                drawLine(
                        level,
                        center,
                        particle,
                        positions[i],
                        positions[next]
                );

            }

        }

    }





    private void drawLine(
            ServerLevel level,
            Vec3 center,
            ParticleOptions particle,
            Vec3 start,
            Vec3 end
    ) {


        double distance =
                start.distanceTo(end);



        /*
         * Lower density prevents
         * particle stacking.
         */
        int steps =
                Math.max(
                        2,
                        (int)(distance * 4)
                );



        for(int i = 0; i <= steps; i++) {


            double percent =
                    (double) i / steps;



            double x =
                    start.x +
                            (end.x - start.x)
                                    * percent;



            double z =
                    start.z +
                            (end.z - start.z)
                                    * percent;



            level.sendParticles(
                    particle,
                    center.x + x,
                    center.y + 0.05,
                    center.z + z,
                    1,
                    0.01,
                    0.01,
                    0.01,
                    0
            );

        }

    }

}