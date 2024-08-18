package destiny.secretsofthevoid.client.models;

import destiny.secretsofthevoid.SecretsOfTheVoid;
import destiny.secretsofthevoid.items.steel.SteelGearItem;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SteelGearModel extends GeoModel<SteelGearItem> {
    @Override
    public ResourceLocation getModelResource(SteelGearItem animatable) {
        return new ResourceLocation(SecretsOfTheVoid.MODID, "geo/armor/steel_diving_gear.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SteelGearItem animatable) {
        return new ResourceLocation(SecretsOfTheVoid.MODID, "textures/item/armor/steel/steel_diving_gear.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SteelGearItem animatable) {
        return new ResourceLocation(SecretsOfTheVoid.MODID, "animations/steel_diving_gear.animation.json");
    }

    @Override
    public RenderType getRenderType(SteelGearItem animatable, ResourceLocation texture) {
        return RenderType.entityTranslucent(texture);
    }
}
