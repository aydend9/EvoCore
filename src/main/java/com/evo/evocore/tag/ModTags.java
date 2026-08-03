package com.evo.evocore.tag;

import com.evo.evocore.EvoCore;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {

    public static final TagKey<Item> PULL_WEAPONS =
            ItemTags.create(ResourceLocation.fromNamespaceAndPath(EvoCore.MODID, "pull_weapons"));

}