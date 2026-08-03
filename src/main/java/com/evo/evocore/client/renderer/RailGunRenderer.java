package com.evo.evocore.client.renderer;

import com.evo.evocore.client.model.RailGunModel;
import com.evo.evocore.item.custom.RailGunItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;


public class RailGunRenderer
        extends GeoItemRenderer<RailGunItem> {


    public RailGunRenderer() {
        super(new RailGunModel());
    }
}