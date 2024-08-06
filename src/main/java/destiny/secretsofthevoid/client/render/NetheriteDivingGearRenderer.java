package destiny.secretsofthevoid.client.render;

import destiny.secretsofthevoid.client.models.NetheriteDivingGearModel;
import destiny.secretsofthevoid.items.NetheriteDivingGearItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class NetheriteDivingGearRenderer extends GeoArmorRenderer<NetheriteDivingGearItem> {
    public NetheriteDivingGearRenderer() {
        super(new NetheriteDivingGearModel());
    }
}
