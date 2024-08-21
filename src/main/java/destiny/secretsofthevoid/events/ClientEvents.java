package destiny.secretsofthevoid.events;

import destiny.secretsofthevoid.SecretsOfTheVoid;
import destiny.secretsofthevoid.init.CapabilitiesInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SecretsOfTheVoid.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEvents
{

    @SubscribeEvent
    public static void fovCalculation(ComputeFovModifierEvent event)
    {
        event.getPlayer().getCapability(CapabilitiesInit.DIVING).ifPresent(cap -> {
            if(!cap.getEquipmentFlippers(event.getPlayer(), null).isEmpty())
                event.setNewFovModifier(1F);
        });
    }

}
