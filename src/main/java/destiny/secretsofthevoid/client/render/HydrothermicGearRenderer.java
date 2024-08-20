package destiny.secretsofthevoid.client.render;

import destiny.secretsofthevoid.client.models.HydrothermicGearModel;
import destiny.secretsofthevoid.items.hydrothermic.HydrothermicGearItem;
import destiny.secretsofthevoid.items.netherite.NetheriteGearItem;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class HydrothermicGearRenderer extends GeoArmorRenderer<HydrothermicGearItem> {
    public HydrothermicGearRenderer() {
        super(new HydrothermicGearModel());

        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }

    @Override
    public RenderType getRenderType(HydrothermicGearItem animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick)
    {
        return RenderType.entityTranslucent(texture);
    }
}
