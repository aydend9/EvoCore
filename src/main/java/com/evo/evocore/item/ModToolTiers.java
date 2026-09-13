package com.evo.evocore.item;

import com.evo.evocore.tag.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {

    public static final Tier ORICHALCUM = new SimpleTier(

            ModTags.BLOCK.INCORRECT_FOR_ORICHALCUM_TOOL,


            1980,


            9.0F,


            4.0F,


            18,

            () -> Ingredient.of(ModItems.ORICHALCUM_INGOT.get())
    );
}