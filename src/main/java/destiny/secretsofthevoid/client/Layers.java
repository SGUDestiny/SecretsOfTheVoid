package destiny.secretsofthevoid.client;

import destiny.secretsofthevoid.SecretsOfTheVoid;
import destiny.secretsofthevoid.client.models.airtanks.SteelAirTank;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;

public class Layers
{
    public static final ModelLayerLocation STEEL_DIVING_GEAR = new ModelLayerLocation(new ResourceLocation(SecretsOfTheVoid.MODID, "steel_air_tank"), "main");

    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(STEEL_DIVING_GEAR, SteelAirTank::createBodyLayer);
    }
}
