package destiny.secretsofthevoid.client.render;

import destiny.secretsofthevoid.blocks.blockentity.ThermoelectricGeneratorBlockEntity;
import destiny.secretsofthevoid.client.models.ThermoelectricGeneratorModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class ThermoelectricGeneratorRenderer extends GeoBlockRenderer<ThermoelectricGeneratorBlockEntity> {
    public ThermoelectricGeneratorRenderer() {
        super(new ThermoelectricGeneratorModel());
    }
}