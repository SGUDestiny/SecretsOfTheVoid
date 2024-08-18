package destiny.secretsofthevoid.client.render;

import destiny.secretsofthevoid.client.models.NetheriteDivingGearModel;
import destiny.secretsofthevoid.items.netherite.NetheriteAirTankItem;
import destiny.secretsofthevoid.items.netherite.NetheriteGearItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class NetheriteDivingGearRenderer extends GeoArmorRenderer<NetheriteGearItem> {
    public NetheriteDivingGearRenderer() {
        super(new NetheriteDivingGearModel());
    }
}
