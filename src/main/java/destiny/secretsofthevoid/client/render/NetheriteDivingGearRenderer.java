package destiny.secretsofthevoid.client.render;

import destiny.secretsofthevoid.client.models.NetheriteDivingGearModel;
import destiny.secretsofthevoid.items.netherite.NetheriteAirTankItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class NetheriteDivingGearRenderer extends GeoArmorRenderer<NetheriteAirTankItem> {
    public NetheriteDivingGearRenderer() {
        super(new NetheriteDivingGearModel());
    }
}
