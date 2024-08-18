package destiny.secretsofthevoid.client.render;

import destiny.secretsofthevoid.client.models.NetheriteGearModel;
import destiny.secretsofthevoid.items.netherite.NetheriteGearItem;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class NetheriteGearRenderer extends GeoArmorRenderer<NetheriteGearItem> {
    public NetheriteGearRenderer() {
        super(new NetheriteGearModel());
    }
}
