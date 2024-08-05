package destiny.secretsofthevoid.client;

import destiny.secretsofthevoid.SecretsOfTheVoid;
import destiny.secretsofthevoid.client.models.NetheriteGearModel;
import destiny.secretsofthevoid.client.models.SteelGearModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;

public class Layers
{
    public static final ModelLayerLocation STEEL_GEAR = new ModelLayerLocation(new ResourceLocation(SecretsOfTheVoid.MODID, "steel_gear"), "main");
    public static final ModelLayerLocation NETHERITE_GEAR = new ModelLayerLocation(new ResourceLocation(SecretsOfTheVoid.MODID, "netherite_gear"), "main");

    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(STEEL_GEAR, SteelGearModel::createBodyLayer);
        event.registerLayerDefinition(NETHERITE_GEAR, NetheriteGearModel::createBodyLayer);
    }
}
