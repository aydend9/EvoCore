package com.evo.evocore.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;

public class BaseShovelItem extends ShovelItem {

    public BaseShovelItem(
            Tier tier,
            float attackDamage,
            float attackSpeed,
            Item.Properties properties
    ) {
        super(
                tier,
                properties.attributes(
                        ShovelItem.createAttributes(
                                tier,
                                attackDamage,
                                attackSpeed
                        )
                )
        );
    }
}