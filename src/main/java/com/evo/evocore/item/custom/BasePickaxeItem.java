package com.evo.evocore.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class BasePickaxeItem extends PickaxeItem {

    public BasePickaxeItem(
            Tier tier,
            float attackDamage,
            float attackSpeed,
            Item.Properties properties
    ) {
        super(
                tier,
                properties.attributes(
                        PickaxeItem.createAttributes(
                                tier,
                                attackDamage,
                                attackSpeed
                        )
                )
        );
    }
}