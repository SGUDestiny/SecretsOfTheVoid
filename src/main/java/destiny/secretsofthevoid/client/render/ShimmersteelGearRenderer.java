package destiny.secretsofthevoid.client.render;

import destiny.secretsofthevoid.client.models.ShimmersteelGearModel;
import destiny.secretsofthevoid.items.shimmersteel.ShimmersteelGearItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ShimmersteelGearRenderer extends GeoArmorRenderer<ShimmersteelGearItem> {
    public ShimmersteelGearRenderer() {super(new ShimmersteelGearModel());}
}
