package destiny.secretsofthevoid.client.render;

import destiny.secretsofthevoid.client.models.SteelGearModel;
import destiny.secretsofthevoid.items.steel.SteelGearItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class SteelGearRenderer extends GeoArmorRenderer<SteelGearItem> {
    public SteelGearRenderer() {super(new SteelGearModel());}
}
