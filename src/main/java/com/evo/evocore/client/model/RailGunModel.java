package com.evo.evocore.client.model;

import com.evo.evocore.item.custom.RailGunItem;
import software.bernie.geckolib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;


public class RailGunModel
        extends GeoModel<RailGunItem> {


    @Override
    public ResourceLocation getModelResource(
            RailGunItem animatable
    ) {

        return ResourceLocation.fromNamespaceAndPath(
                "evocore",
                "geo/railgun.geo.json"
        );
    }


    @Override
    public ResourceLocation getTextureResource(
            RailGunItem animatable
    ) {

        return ResourceLocation.fromNamespaceAndPath(
                "evocore",
                "textures/item/railgun.png"
        );
    }


    @Override
    public ResourceLocation getAnimationResource(
            RailGunItem animatable
    ) {

        return ResourceLocation.fromNamespaceAndPath(
                "evocore",
                "animations/railgun.animation.json"
        );
    }
}