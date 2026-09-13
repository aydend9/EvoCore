package com.evo.evocore.event;

import com.evo.evocore.item.custom.OrichalArmorItem;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;

@EventBusSubscriber(modid = "evocore")
public class ArmorAttributeEvents {

    @SubscribeEvent
    public static void onItemAttributeModifier(ItemAttributeModifierEvent event) {

        if (!(event.getItemStack().getItem() instanceof OrichalArmorItem armor)) {
            return;
        }

        event.addModifier(
                Attributes.MAX_HEALTH,
                new AttributeModifier(
                        armor.getHealthModifierId(),
                        1.0,
                        AttributeModifier.Operation.ADD_VALUE
                ),
                EquipmentSlotGroup.bySlot(armor.getType().getSlot())
        );
    }
}