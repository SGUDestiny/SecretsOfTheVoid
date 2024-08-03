package destiny.secretsofthevoid;

import destiny.secretsofthevoid.init.ItemInit;
import destiny.secretsofthevoid.init.ItemTabInit;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod(SecretsOfTheVoid.MODID)

public class SecretsOfTheVoid {
    public static final String MODID = "secretsofthevoid";

    public SecretsOfTheVoid()
    {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        //Register our Deferred Registries here so it can be registered early enough to avoid NPEs
        ItemInit.register(modBus);
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEvents
    {
        @SubscribeEvent
        public static void onCreativeTab(BuildCreativeModeTabContentsEvent event)
        {
            ItemTabInit.setupTabs(event);
        }
    }

    private void commonSetup(FMLCommonSetupEvent event) {

        event.enqueueWork(() -> {

        });
    }
}