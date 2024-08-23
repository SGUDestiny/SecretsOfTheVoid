package destiny.secretsofthevoid.client.models;

import destiny.secretsofthevoid.SecretsOfTheVoid;
import destiny.secretsofthevoid.items.scoria.ScoriaGearItem;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ScoriaGearModel extends GeoModel<ScoriaGearItem> {
    @Override
    public ResourceLocation getModelResource(ScoriaGearItem animatable) {
        return new ResourceLocation(SecretsOfTheVoid.MODID, "geo/armor/scoria_diving_gear.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ScoriaGearItem animatable) {
        return new ResourceLocation(SecretsOfTheVoid.MODID, "textures/item/armor/scoria/scoria_diving_gear.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ScoriaGearItem animatable) {
        return new ResourceLocation(SecretsOfTheVoid.MODID, "animations/scoria_diving_gear.animation.json");
    }

    @Override
    public RenderType getRenderType(ScoriaGearItem animatable, ResourceLocation texture) {
        return RenderType.entityTranslucent(texture);
    }
}
