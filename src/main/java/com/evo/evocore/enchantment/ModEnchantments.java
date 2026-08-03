package com.evo.evocore.enchantment;

import com.evo.evocore.EvoCore;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.Enchantment;

public class ModEnchantments {
    public static final ResourceKey<Enchantment> Cleave = ResourceKey.create(
            Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(EvoCore.MODID, "cleave")
    );
    public static final ResourceKey<Enchantment> DOUBLE_JUMP = ResourceKey.create(
            Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(EvoCore.MODID, "double_jump")
    );
    public static final ResourceKey<Enchantment> VITALITY = ResourceKey.create(
            Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(EvoCore.MODID, "vitality")
    );
    public static final ResourceKey<Enchantment> BURST =
            ResourceKey.create(
                    Registries.ENCHANTMENT,
                    ResourceLocation.fromNamespaceAndPath(EvoCore.MODID, "burst"
                    )
            );
}