package com.evo.evocore.item.custom;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;

public class BaseAxeItem extends AxeItem {

    public BaseAxeItem(
            Tier tier,
            float attackDamage,
            float attackSpeed,
            Item.Properties properties
    ) {
        super(
                tier,
                properties.attributes(
                        AxeItem.createAttributes(
                                tier,
                                attackDamage,
                                attackSpeed
                        )
                )
        );
    }
}