package com.evo.evocore.particle;

import net.minecraft.server.level.ServerLevel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MagicCircleManager {

    private static final List<MagicCircleEffect> ACTIVE = new ArrayList<>();

    private MagicCircleManager() {
    }

    public static void add(MagicCircleEffect effect) {
        ACTIVE.add(effect);
    }

    public static void tick(ServerLevel level) {

        Iterator<MagicCircleEffect> iterator = ACTIVE.iterator();

        while (iterator.hasNext()) {

            MagicCircleEffect effect = iterator.next();

            MagicCircleRenderer.render(level, effect);

            effect.tick();

            if (effect.isFinished()) {
                iterator.remove();
            }
        }
    }
}