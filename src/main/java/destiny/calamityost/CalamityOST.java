package destiny.calamityost;

import destiny.calamityost.items.ModItemRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod(CalamityOST.MODID)

public class CalamityOST {
    public static final String MODID = "calamityost";

    public CalamityOST(){

        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        //Register our Deferred Registries here so it can be registered early enough to avoid NPEs
        CalamitySounds.DEF_REG.register(modBus);
        ModItemRegistry.DEF_REG.register(modBus);
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEvents
    {
        @SubscribeEvent
        public static void onCreativeTab(BuildCreativeModeTabContentsEvent event)
        {
            ModItemRegistry.setupTabs(event);
        }
    }

    private void commonSetup(FMLCommonSetupEvent event) {

        event.enqueueWork(() -> {

        });
    }
}