package destiny.secretsofthevoid.client.models;

import destiny.secretsofthevoid.SecretsOfTheVoid;
import destiny.secretsofthevoid.blocks.blockentity.ThermoelectricGeneratorBlockEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;

public class ThermoelectricGeneratorModel extends DefaultedBlockGeoModel<ThermoelectricGeneratorBlockEntity> {
    public ThermoelectricGeneratorModel() {
        super(new ResourceLocation(SecretsOfTheVoid.MODID, "geo/block/thermoelectric_generator.geo.json"));
    }

    @Override
    public RenderType getRenderType(ThermoelectricGeneratorBlockEntity animatable, ResourceLocation texture) {
        return RenderType.entityTranslucent(getTextureResource(animatable));
    }
}