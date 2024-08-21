package destiny.secretsofthevoid.events;

import destiny.secretsofthevoid.SecretsOfTheVoid;
import destiny.secretsofthevoid.init.CapabilitiesInit;
import net.minecraft.world.entity.player.Player;
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
            Player player = event.getPlayer();
            if(!cap.getEquipmentFlippers(player, null).isEmpty() && player.getEyeInFluidType().canDrownIn(player)) {
                event.setNewFovModifier(1.4F);
            } else if(!cap.getEquipmentFlippers(player, null).isEmpty())
                event.setNewFovModifier(1F);
        });
    }

}
