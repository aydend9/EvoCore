package com.evo.evocore.event;

import com.evo.evocore.EvoCore;
import com.evo.evocore.enchantment.ModEnchantments;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber(modid = EvoCore.MODID)
public class PlayerAttributeEvents {

    private static final ResourceLocation SAFE_FALL_ID =
            ResourceLocation.fromNamespaceAndPath(EvoCore.MODID, "double_jump_safe_fall");

    @SubscribeEvent
    public static void playerTick(PlayerTickEvent.Post event) {

        Player player = event.getEntity();
        if (player.level().isClientSide()) {
            return;
        }

        ItemStack boots = player.getItemBySlot(EquipmentSlot.FEET);
        Holder<Enchantment> doubleJump =
                player.level()
                        .registryAccess()
                        .registryOrThrow(Registries.ENCHANTMENT)
                        .getHolderOrThrow(ModEnchantments.DOUBLE_JUMP);

        int level = EnchantmentHelper.getItemEnchantmentLevel(doubleJump, boots);

        AttributeInstance attribute = player.getAttribute(Attributes.SAFE_FALL_DISTANCE);

        if (attribute == null) {
            return;
        }
        attribute.removeModifier(SAFE_FALL_ID);
        if (level > 0) {
            attribute.addTransientModifier(
                    new AttributeModifier(
                            SAFE_FALL_ID,
                            level * 3.0,
                            AttributeModifier.Operation.ADD_VALUE
                    )
            );
        }
    }
}