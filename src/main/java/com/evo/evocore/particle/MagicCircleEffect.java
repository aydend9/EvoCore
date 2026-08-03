package com.evo.evocore.particle;


import com.evo.evocore.particle.shapes.MagicShape;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;


public class MagicCircleEffect {

    private final List<MagicShape> shapes =
            new ArrayList<>();

    private int fadeInTime = 20;

    private int fadeOutTime = 20;


    private final Vec3 center;


    private int duration;


    private int age;



    private final List<MagicRing> rings =
            new ArrayList<>();


    private boolean pulse;



    private boolean star;


    private int starPoints;


    private float starRadius;



    public MagicCircleEffect(
            Vec3 center,
            int duration
    )
    {

        this.center = center;
        this.duration = duration;

    }
    public int getFadeInTime() {
        return fadeInTime;
    }


    public int getFadeOutTime() {
        return fadeOutTime;
    }


    public void setFadeTimes(
            int fadeIn,
            int fadeOut
    ) {
        this.fadeInTime = fadeIn;
        this.fadeOutTime = fadeOut;
    }



    public void tick() {

        age++;

    }



    public boolean isFinished() {

        return age >= duration;

    }



    public Vec3 getCenter() {

        return center;

    }



    public int getAge() {

        return age;

    }



    public int getDuration() {

        return duration;

    }



    public void setDuration(int duration) {

        this.duration = duration;

    }



    public List<MagicRing> getRings() {

        return rings;

    }



    public void addRing(MagicRing ring) {

        rings.add(ring);

    }



    public boolean shouldPulse() {

        return pulse;

    }



    public void setPulse(boolean pulse) {

        this.pulse = pulse;

    }



    public void createStar(
            int points,
            float radius
    ) {

        this.star = true;

        this.starPoints = points;

        this.starRadius = radius;

    }



    public boolean hasStar() {

        return star;

    }



    public int getStarPoints() {

        return starPoints;

    }



    public float getStarRadius() {

        return starRadius;

    }
    public float getFadeMultiplier() {

        if(age < fadeInTime) {

            return (float) age / fadeInTime;

        }

        if(age > duration - fadeOutTime) {


            int remaining =
                    duration - age;

            return (float) remaining / fadeOutTime;

        }
        return 1f;
    }
    public void addShape(MagicShape shape) {

        shapes.add(shape);

    }


    public List<MagicShape> getShapes() {

        return shapes;

    }

}