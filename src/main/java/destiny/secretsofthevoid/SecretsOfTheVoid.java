package destiny.secretsofthevoid;

import destiny.secretsofthevoid.client.gui.OxygenOverlay;
import destiny.secretsofthevoid.init.*;
import destiny.worldgen.feature.ModFeatures;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static destiny.secretsofthevoid.init.BlockInit.BLOCKS;

@Mod(SecretsOfTheVoid.MODID)

public class SecretsOfTheVoid {
    public static final String MODID = "secretsofthevoid";

    public SecretsOfTheVoid()
    {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        ItemInit.register(modBus);
        ItemTabInit.register(modBus);
        BLOCKS.register(modBus);
        SoundInit.SOUNDS.register(modBus);
        ModFeatures.DEF_REG.register(modBus);
        BlockEntitiesInit.DEF_REG.register(modBus);
    }

    @Mod.EventBusSubscriber(modid = MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEvents
    {
        @SubscribeEvent
        public static void onCreativeTab(BuildCreativeModeTabContentsEvent event)
        {
            ItemTabInit.setupTabs(event);
        }
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void registerOverlays(RegisterGuiOverlaysEvent event)
        {
            event.registerAboveAll("oxygen", OxygenOverlay.OVERLAY);
        }
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            NetworkInit.registerPackets();
        });
    }
}