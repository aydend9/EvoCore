package com.evo.evocore.item.custom;

import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;

public class BaseHoeItem extends HoeItem {

    public BaseHoeItem(
            Tier tier,
            float attackDamage,
            float attackSpeed,
            Item.Properties properties
    ) {
        super(
                tier,
                properties.attributes(
                        HoeItem.createAttributes(
                                tier,
                                attackDamage,
                                attackSpeed
                        )
                )
        );
    }
}