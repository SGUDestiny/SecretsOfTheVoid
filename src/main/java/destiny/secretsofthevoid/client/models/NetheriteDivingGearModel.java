package destiny.secretsofthevoid.client.models;

import destiny.secretsofthevoid.SecretsOfTheVoid;
import destiny.secretsofthevoid.items.NetheriteDivingGearItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class NetheriteDivingGearModel extends GeoModel<NetheriteDivingGearItem> {
    @Override
    public ResourceLocation getModelResource(NetheriteDivingGearItem animatable) {
        return new ResourceLocation(SecretsOfTheVoid.MODID, "geo/armor/netherite_diving_gear.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NetheriteDivingGearItem animatable) {
        return new ResourceLocation(SecretsOfTheVoid.MODID, "textures/armor/netherite/netherite_diving_gear.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NetheriteDivingGearItem animatable) {
        return new ResourceLocation(SecretsOfTheVoid.MODID, "animations/netherite_diving_gear.animation.json");
    }
}
