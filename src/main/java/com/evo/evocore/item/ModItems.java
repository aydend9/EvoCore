package com.evo.evocore.item;

import com.evo.evocore.EvoCore;
import com.evo.evocore.item.custom.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items WEAPONS =
            DeferredRegister.createItems(EvoCore.MODID);

    public static final DeferredItem<Item> EVOCORE_LOGO = WEAPONS.register(
            "evocore_logo",
            () -> new Item(new Item.Properties())
    );
    public static final DeferredItem<Item> WRAPPED_STICK = WEAPONS.register(
            "wrapped_stick",
            () -> new Item(new Item.Properties())
    );
    public static final DeferredItem<Item> Diamond_Scythe = WEAPONS.register(
            "diamond_scythe",
            () -> new ScytheItem(
                    Tiers.DIAMOND,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(Tiers.DIAMOND, 3, -2.4F)
                    )
            )
    );
    public static final DeferredItem<Item> Stone_Scythe = WEAPONS.register(
            "stone_scythe",
            () -> new ScytheItem(
                    Tiers.STONE,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(Tiers.STONE, 3, -2.4F)
                    )
            )
    );
    public static final DeferredItem<Item> Wood_Scythe = WEAPONS.register(
            "wood_scythe",
            () -> new ScytheItem(
                    Tiers.WOOD,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(Tiers.WOOD, 3, -2.4F)
                    )
            )
    );
    public static final DeferredItem<Item> Iron_Scythe = WEAPONS.register(
            "iron_scythe",
            () -> new ScytheItem(
                    Tiers.IRON,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(Tiers.IRON, 3, -2.4F)
                    )
            )
    );
    public static final DeferredItem<Item> Gold_Scythe = WEAPONS.register(
            "gold_scythe",
            () -> new ScytheItem(
                    Tiers.GOLD,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(Tiers.GOLD, 3, -2.4F)
                    )
            )
    );
    public static final DeferredItem<Item> Netherite_Scythe = WEAPONS.register(
            "netherite_scythe",
            () -> new ScytheItem(
                        Tiers.NETHERITE,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(Tiers.NETHERITE, 3, -2.4F)
                    )
            )
    );
    public static final DeferredItem<Item> Wood_Katana = WEAPONS.register(
            "wood_katana",
            () -> new KatanaItem(
                    Tiers.WOOD,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(Tiers.WOOD, 2, -2.0F)
                    )
            )
    );
    public static final DeferredItem<Item> Stone_Katana = WEAPONS.register(
            "stone_katana",
            () -> new KatanaItem(
                    Tiers.STONE,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(Tiers.STONE, 2, -2.0F)
                    )
            )
    );
    public static final DeferredItem<Item> Iron_Katana = WEAPONS.register(
            "iron_katana",
            () -> new KatanaItem(
                    Tiers.IRON,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(Tiers.IRON, 2, -2.0F)
                    )
            )
    );
    public static final DeferredItem<Item> Gold_Katana = WEAPONS.register(
            "gold_katana",
            () -> new KatanaItem(
                    Tiers.GOLD,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(Tiers.GOLD, 2, -2.0F)
                    )
            )
    );
    public static final DeferredItem<Item> Diamond_Katana = WEAPONS.register(
            "diamond_katana",
            () -> new KatanaItem(
                    Tiers.DIAMOND,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(Tiers.DIAMOND, 2, -2.0F)
                    )
            )
    );
    public static final DeferredItem<Item> Netherite_Katana = WEAPONS.register(
            "netherite_katana",
            () -> new KatanaItem(
                    Tiers.NETHERITE,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(Tiers.NETHERITE, 2, -2.0F)
                    )
            )
    );
    public static final DeferredItem<Item> Wood_Rapier = WEAPONS.register(
            "wood_rapier",
            () -> new SwordItem(
                    Tiers.WOOD,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(Tiers.WOOD, 2, -2.0F)
                    )
            )
    );
    public static final DeferredItem<Item> Stone_Rapier = WEAPONS.register(
            "stone_rapier",
            () -> new SwordItem(
                    Tiers.STONE,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(Tiers.STONE, 2, -2.0F)
                    )
            )
    );
    public static final DeferredItem<Item> Iron_Rapier = WEAPONS.register(
            "iron_rapier",
            () -> new SwordItem(
                    Tiers.IRON,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(Tiers.IRON, 2, -2.0F)
                    )
            )
    );
    public static final DeferredItem<Item> Gold_Rapier = WEAPONS.register(
            "gold_rapier",
            () -> new SwordItem(
                    Tiers.GOLD,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(Tiers.GOLD, 2, -2.0F)
                    )
            )
    );
    public static final DeferredItem<Item> Diamond_Rapier = WEAPONS.register(
            "diamond_rapier",
            () -> new SwordItem(
                    Tiers.DIAMOND,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(Tiers.DIAMOND, 2, -2.0F)
                    )
            )
    );
    public static final DeferredItem<Item> Netherite_Rapier = WEAPONS.register(
            "netherite_rapier",
            () -> new SwordItem(
                    Tiers.NETHERITE,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(Tiers.NETHERITE, 2, -2.0F)
                    )
            )
    );
    public static final DeferredItem<Item> Wood_Dagger = WEAPONS.register(
            "wood_dagger",
            () -> new DaggerItem(
                    Tiers.WOOD,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(Tiers.WOOD, 1, -2.0F)
                    )
            )
    );
    public static final DeferredItem<Item> Stone_Dagger = WEAPONS.register(
            "stone_dagger",
            () -> new DaggerItem(
                    Tiers.STONE,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(Tiers.STONE, 1, -2.0F)
                    )
            )
    );
    public static final DeferredItem<Item> Iron_Dagger = WEAPONS.register(
            "iron_dagger",
            () -> new DaggerItem(
                    Tiers.IRON,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(Tiers.IRON, 1, -2.0F)
                    )
            )
    );
    public static final DeferredItem<Item> Gold_Dagger = WEAPONS.register(
            "gold_dagger",
            () -> new DaggerItem(
                    Tiers.GOLD,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(Tiers.GOLD, 1, -2.0F)
                    )
            )
    );
    public static final DeferredItem<Item> Diamond_Dagger = WEAPONS.register(
            "diamond_dagger",
            () -> new DaggerItem(
                    Tiers.DIAMOND,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(Tiers.DIAMOND, 1, -2.0F)
                    )
            )
    );
    public static final DeferredItem<Item> NETHERITE_Dagger = WEAPONS.register(
            "netherite_dagger",
            () -> new DaggerItem(
                    Tiers.NETHERITE,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(Tiers.NETHERITE, 1, -2.0F)
                    )
            )
    );
    public static final DeferredItem<Item> TS_PMO_SWORD = WEAPONS.register(
            "ts_pmo_sword",
            () -> new SwordItem(
                    Tiers.NETHERITE,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(Tiers.NETHERITE, 5, -2.0F)
                    )
            )
    );
    public static final DeferredItem<Item> Odelkovi = WEAPONS.register(
            "odelkovi",
            () -> new OdelkoviItem(
                    Tiers.NETHERITE,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(Tiers.NETHERITE, 7, -2.0F)
                    )
            )
    );
    public static final DeferredItem<Item> Arkovi = WEAPONS.register(
            "arkovi",
            () -> new ArkoviItem(
                    Tiers.NETHERITE,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(Tiers.NETHERITE, 7, -2.0F)
                    )
            )
    );
    public static void register(IEventBus modEventBus) {
        WEAPONS.register(modEventBus);
    }
}