package destiny.secretsofthevoid.client.models;

import destiny.secretsofthevoid.SecretsOfTheVoid;
import destiny.secretsofthevoid.items.shimmersteel.ShimmersteelGearItem;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ShimmersteelGearModel extends GeoModel<ShimmersteelGearItem> {
    @Override
    public ResourceLocation getModelResource(ShimmersteelGearItem animatable) {
        return new ResourceLocation(SecretsOfTheVoid.MODID, "geo/armor/shimmersteel_diving_gear.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ShimmersteelGearItem animatable) {
        return new ResourceLocation(SecretsOfTheVoid.MODID, "textures/item/armor/shimmersteel/shimmersteel_diving_gear.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ShimmersteelGearItem animatable) {
        return new ResourceLocation(SecretsOfTheVoid.MODID, "animations/shimmersteel_diving_gear.animation.json");
    }

    @Override
    public RenderType getRenderType(ShimmersteelGearItem animatable, ResourceLocation texture) {
        return RenderType.entityTranslucent(texture);
    }
}
