package destiny.calamityost;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CalamityOST.MODID)

public class CalamityOST {
    public static final String MODID = "calamityost";

    public CalamityOST(){

        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        //Register our Deferred Registries here so it can be registered early enough to avoid NPEs
        CalamitySounds.SOUNDS.register(modBus);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

        event.enqueueWork(() -> {

        });
    }
}