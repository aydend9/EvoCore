package com.evo.evocore.item;

import com.evo.evocore.EvoCore;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;

public class ModArmorMaterials {

    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS =
            DeferredRegister.create(Registries.ARMOR_MATERIAL, EvoCore.MODID);

    public static final Holder<ArmorMaterial> ORICHALCUM =
            ARMOR_MATERIALS.register("orichalcum", () -> new ArmorMaterial(


                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),

                    15,

                    SoundEvents.ARMOR_EQUIP_DIAMOND,

                    () -> Ingredient.of(ModItems.ORICHALCUM_INGOT.get()),

                    java.util.List.of(
                            new ArmorMaterial.Layer(
                                    EvoCore.id("orichalcum")
                            )
                    ),

                    2.0F,

                    0.0f
            ));

}