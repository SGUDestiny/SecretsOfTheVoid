package destiny.secretsofthevoid.events;

import destiny.secretsofthevoid.SecretsOfTheVoid;
import destiny.secretsofthevoid.capabilities.BreathingCapability;
import destiny.secretsofthevoid.capabilities.GenericProvider;
import destiny.secretsofthevoid.init.CapabilitiesInit;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SecretsOfTheVoid.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.DEDICATED_SERVER)
public class CalamityEvents {

    @SubscribeEvent
    public static void attachCapabilities(AttachCapabilitiesEvent<Entity> event)
    {
        if(event.getObject() instanceof Player)
            event.addCapability(new ResourceLocation(SecretsOfTheVoid.MODID, "breathing"), new GenericProvider<>(CapabilitiesInit.BREATHING, new BreathingCapability()));
    }

    @SubscribeEvent
    public static void playerTick(TickEvent.PlayerTickEvent event)
    {
        event.player.getCapability(CapabilitiesInit.BREATHING).ifPresent(
                cap -> cap.tick(event.player.level(), event.player)
        );
    }

}
