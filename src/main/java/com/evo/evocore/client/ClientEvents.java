package com.evo.evocore.client;

import com.evo.evocore.EvoCore;
import com.evo.evocore.network.BurstPacket;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

@EventBusSubscriber(
        modid = EvoCore.MODID,
        value = Dist.CLIENT
)
public class ClientEvents {


    @SubscribeEvent
    public static void clientTick(ClientTickEvent.Post event) {

        while (ModKeyBindings.BURST.consumeClick()) {
            BurstPacket.sendToServer();
        }

    }


    @SubscribeEvent
    public static void registerItemRenderers(
            RegisterClientExtensionsEvent event
    ) {

    }
}
        //{

       // event.registerItem(
        //        new IClientItemExtensions() {

       //             @Override
        //            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
        //                return new RailGunRenderer();
        //            }

      //         },
       //         ModItems.RAILGUN.get()
     //   );


// Magic circle test key
// while (ModKeyBindings.TEST_CIRCLE.consumeClick()) {

//     Minecraft minecraft = Minecraft.getInstance();


//    if (minecraft.player == null)
              //  return;


//     Vec3 position =
//             minecraft.player.position();


//     CirclePacket.sendToServer();