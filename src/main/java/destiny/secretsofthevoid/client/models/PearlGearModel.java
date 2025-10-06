package destiny.secretsofthevoid.client.models;

import destiny.secretsofthevoid.SecretsOfTheVoid;
import destiny.secretsofthevoid.items.diving_gear.PearlGearItem;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PearlGearModel extends GeoModel<PearlGearItem> {
    @Override
    public ResourceLocation getModelResource(PearlGearItem animatable) {
        return new ResourceLocation(SecretsOfTheVoid.MODID, "geo/armor/pearl_diving_gear.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PearlGearItem animatable) {
        return new ResourceLocation(SecretsOfTheVoid.MODID, "textures/item/pearl_diving_gear.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PearlGearItem animatable) {
        return new ResourceLocation(SecretsOfTheVoid.MODID, "animations/pearl_diving_gear.animation.json");
    }

    @Override
    public RenderType getRenderType(PearlGearItem animatable, ResourceLocation texture) {
        return RenderType.entityTranslucent(texture);
    }
}
