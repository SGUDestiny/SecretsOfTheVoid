package destiny.secretsofthevoid.client.models;

import destiny.secretsofthevoid.SecretsOfTheVoid;
import destiny.secretsofthevoid.items.hydrothermic.HydrothermicGearItem;
import destiny.secretsofthevoid.items.netherite.NetheriteGearItem;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HydrothermicGearModel extends GeoModel<HydrothermicGearItem> {
    @Override
    public ResourceLocation getModelResource(HydrothermicGearItem animatable) {
        return new ResourceLocation(SecretsOfTheVoid.MODID, "geo/armor/hydrothermic_diving_gear.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HydrothermicGearItem animatable) {
        return new ResourceLocation(SecretsOfTheVoid.MODID, "textures/item/armor/hydrothermic/hydrothermic_diving_gear.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HydrothermicGearItem animatable) {
        return new ResourceLocation(SecretsOfTheVoid.MODID, "animations/hydrothermic_diving_gear.animation.json");
    }

    @Override
    public RenderType getRenderType(HydrothermicGearItem animatable, ResourceLocation texture) {
        return RenderType.entityTranslucent(texture);
    }
}
