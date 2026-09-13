package com.evo.evocore.item;

import com.evo.evocore.EvoCore;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EvoCore.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EVOCORE_TAB =
            CREATIVE_MODE_TABS.register("evocore", () ->
                    CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.evocore"))
                            .icon(() -> new ItemStack(ModItems.EVOCORE_LOGO.get()))
                            .displayItems((parameters, output) -> {

                                ModItems.WEAPONS.getEntries().forEach(holder ->
                                        output.accept(holder.get())
                                );
                                ModItems.ORICHALCUM.getEntries().forEach(holder ->
                                        output.accept(holder.get())
                                );

                            })
                            .build()
            );
}