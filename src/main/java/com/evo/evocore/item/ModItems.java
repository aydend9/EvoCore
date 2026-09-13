package com.evo.evocore.item;

import com.evo.evocore.EvoCore;
import com.evo.evocore.item.custom.*;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items WEAPONS =
            DeferredRegister.createItems(EvoCore.MODID);
    public static final DeferredRegister.Items ORICHALCUM =
            DeferredRegister.createItems(EvoCore.MODID);

    public static final DeferredItem<Item> EVOCORE_LOGO = WEAPONS.register(
            "evocore_logo",
            () -> new Item(new Item.Properties())
    );
    public static final DeferredItem<Item> WRAPPED_STICK = WEAPONS.register(
            "wrapped_stick",
            () -> new Item(new Item.Properties())
    );
    public static final DeferredItem<Item> ORICHALCUM_INGOT = ORICHALCUM.register(
            "orichalcum_ingot",
            () -> new Item(new Item.Properties())
    );
    public static final DeferredItem<Item> ORICHALCUM_SCRAP = ORICHALCUM.register(
            "orichalcum_scrap",
            () -> new Item(new Item.Properties())
    );
    public static final DeferredHolder<Item, Item> ORICHAL_HELMET =
            ORICHALCUM.register("orichal_helmet", () -> new OrichalArmorItem(
                    ModArmorMaterials.ORICHALCUM,
                    ArmorItem.Type.HELMET,
                    new Item.Properties().stacksTo(1),
                    353,
                    EvoCore.id("orichal_helmet_health")
            ));

    public static final DeferredHolder<Item, Item> ORICHAL_CHESTPLATE =
            ORICHALCUM.register("orichal_chestplate", () -> new OrichalArmorItem(
                    ModArmorMaterials.ORICHALCUM,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().stacksTo(1),
                    532,
                    EvoCore.id("orichal_chestplate_health")
            ));

    public static final DeferredHolder<Item, Item> ORICHAL_LEGGINGS =
            ORICHALCUM.register("orichal_leggings", () -> new OrichalArmorItem(
                    ModArmorMaterials.ORICHALCUM,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Properties().stacksTo(1),
                    494,
                    EvoCore.id("orichal_leggings_health")
            ));

    public static final DeferredHolder<Item, Item> ORICHAL_BOOTS =
            ORICHALCUM.register("orichal_boots", () -> new OrichalArmorItem(
                    ModArmorMaterials.ORICHALCUM,
                    ArmorItem.Type.BOOTS,
                    new Item.Properties().stacksTo(1),
                    359,
                    EvoCore.id("orichal_boots_health")
            ));
    
    public static final DeferredItem<Item> ORICHALCUM_Katana = WEAPONS.register(
            "orichal_katana",
            () -> new KatanaItem(
                    ModToolTiers.ORICHALCUM,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(ModToolTiers.ORICHALCUM, 2, -2.0F)
                    )
            )
    );
    public static final DeferredItem<Item> ORICHALCUM_DAGGER = WEAPONS.register(
            "orichal_dagger",
            () -> new DaggerItem(
                    ModToolTiers.ORICHALCUM,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(ModToolTiers.ORICHALCUM, 2, -2.0F)
                    )
            )
    );
    public static final DeferredItem<Item> ORICHAL_Scythe = WEAPONS.register(
            "orichal_scythe",
            () -> new ScytheItem(
                    ModToolTiers.ORICHALCUM,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(ModToolTiers.ORICHALCUM, 3, -2.4F)
                    )
            )
    );
    public static final DeferredItem<Item> ORICHAL_SWORD =
            WEAPONS.register(
                    "orichal_sword",
                    () -> new OrichalSwordItem(
                            ModToolTiers.ORICHALCUM,
                            new Item.Properties()
                    )
            );
    public static final DeferredItem<Item> ORICHAL_PICKAXE =
            WEAPONS.register(
                    "orichal_pickaxe",
                    () -> new PickaxeItem(
                            ModToolTiers.ORICHALCUM,
                            new Item.Properties().attributes(
                                    PickaxeItem.createAttributes(
                                            ModToolTiers.ORICHALCUM,
                                            1,
                                            -2.8F
                                    )
                            )
                    )
            );

    public static final DeferredItem<Item> ORICHAL_AXE =
            WEAPONS.register(
                    "orichal_axe",
                    () -> new AxeItem(
                            ModToolTiers.ORICHALCUM,
                            new Item.Properties().attributes(
                                    AxeItem.createAttributes(
                                            ModToolTiers.ORICHALCUM,
                                            6,
                                            -3.1F
                                    )
                            )
                    )
            );

    public static final DeferredItem<Item> ORICHAL_SHOVEL =
            WEAPONS.register(
                    "orichal_shovel",
                    () -> new ShovelItem(
                            ModToolTiers.ORICHALCUM,
                            new Item.Properties().attributes(
                                    ShovelItem.createAttributes(
                                            ModToolTiers.ORICHALCUM,
                                            1.5F,
                                            -3.0F
                                    )
                            )
                    )
            );

    public static final DeferredItem<Item> ORICHAL_HOE =
            WEAPONS.register(
                    "orichal_hoe",
                    () -> new HoeItem(
                            ModToolTiers.ORICHALCUM,
                            new Item.Properties().attributes(
                                    HoeItem.createAttributes(
                                            ModToolTiers.ORICHALCUM,
                                            0,
                                            -3.0F
                                    )
                            )
                    )
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