package com.evo.evocore;

import com.evo.evocore.effect.ModEffects;
import com.evo.evocore.item.ModArmorMaterials;
import com.evo.evocore.item.ModCreativeModeTabs;
import com.evo.evocore.item.ModItems;
import com.evo.evocore.network.CirclePacket;
import com.evo.evocore.network.DoubleJumpHandler;
import com.evo.evocore.network.DoubleJumpPacket;
import com.evo.evocore.network.ModNetworking;
import com.evo.evocore.sound.ModSounds;
import com.evo.evocore.tag.ModTags;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import org.slf4j.Logger;


@Mod(EvoCore.MODID)
public class EvoCore {
    public static final String MODID = "evocore";
    public static final Logger LOGGER = LogUtils.getLogger();


    public EvoCore(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::registerPayloads);


        NeoForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);
        ModItems.ORICHALCUM.register(modEventBus);
        ModCreativeModeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        ModTags.PULL_WEAPONS.registry();
        ModEffects.register(modEventBus);
        modEventBus.addListener(ModNetworking::register);
        ModSounds.register(modEventBus);
        ModArmorMaterials.ARMOR_MATERIALS.register(modEventBus);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
    private void commonSetup(FMLCommonSetupEvent event) {

    }
    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    private void registerPayloads(RegisterPayloadHandlersEvent event) {
        var registrar = event.registrar(MODID);
        registrar.playToServer(
                DoubleJumpPacket.TYPE,
                DoubleJumpPacket.STREAM_CODEC,
                (packet, context) -> context.player().level().getServer().execute(() -> {
                    DoubleJumpHandler.handle(context.player());
                })
        );
        registrar.playToServer(
                CirclePacket.TYPE,
                CirclePacket.STREAM_CODEC,
                CirclePacket::handle
        );
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
    }