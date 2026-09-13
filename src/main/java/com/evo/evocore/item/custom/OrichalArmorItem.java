package com.evo.evocore.item.custom;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;

public class OrichalArmorItem extends ArmorItem {

    private final ResourceLocation healthModifierId;

    public OrichalArmorItem(
            Holder<ArmorMaterial> material,
            Type type,
            Item.Properties properties,
            int durability,
            ResourceLocation healthModifierId
    ) {
        super(
                material,
                type,
                properties.durability(durability)
        );

        this.healthModifierId = healthModifierId;
    }

    public ResourceLocation getHealthModifierId() {
        return healthModifierId;
    }
}