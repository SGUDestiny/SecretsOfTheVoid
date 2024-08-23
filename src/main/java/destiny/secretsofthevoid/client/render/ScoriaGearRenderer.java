package destiny.secretsofthevoid.client.render;

import destiny.secretsofthevoid.client.models.ScoriaGearModel;
import destiny.secretsofthevoid.items.scoria.ScoriaGearItem;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ScoriaGearRenderer extends GeoArmorRenderer<ScoriaGearItem> {
    public ScoriaGearRenderer() {
        super(new ScoriaGearModel());

        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }

    @Override
    public RenderType getRenderType(ScoriaGearItem animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick)
    {
        return RenderType.entityTranslucent(texture);
    }
}
