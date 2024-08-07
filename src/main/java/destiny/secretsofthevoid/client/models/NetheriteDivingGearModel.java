package destiny.secretsofthevoid.client.models;

import destiny.secretsofthevoid.SecretsOfTheVoid;
import destiny.secretsofthevoid.items.netherite.NetheriteAirTankItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class NetheriteDivingGearModel extends GeoModel<NetheriteAirTankItem> {
    @Override
    public ResourceLocation getModelResource(NetheriteAirTankItem animatable) {
        return new ResourceLocation(SecretsOfTheVoid.MODID, "geo/armor/netherite_diving_gear.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NetheriteAirTankItem animatable) {
        return new ResourceLocation(SecretsOfTheVoid.MODID, "textures/item/armor/netherite/netherite_diving_gear.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NetheriteAirTankItem animatable) {
        return new ResourceLocation(SecretsOfTheVoid.MODID, "animations/netherite_diving_gear.animation.json");
    }
}
