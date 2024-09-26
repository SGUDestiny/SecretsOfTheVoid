package destiny.secretsofthevoid.init;

import destiny.secretsofthevoid.SecretsOfTheVoid;
import destiny.secretsofthevoid.helper.ItemHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ItemTabInit
{
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SecretsOfTheVoid.MODID);

    public static final RegistryObject<CreativeModeTab> MAIN = TABS.register("secretsofthevoid",
            () -> CreativeModeTab.builder()
                    .icon(() -> ItemInit.DISC_HADAL.get().getDefaultInstance())
                    .title(Component.translatable("itemGroup.secretsofthevoid.creative_tab"))
                    .build()
    );

    public static void register(IEventBus bus)
    {
        TABS.register(bus);
    }

    public static void setupTabs(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == MAIN.getKey())
        {
            event.accept(BlockInit.OXYGEN_VENT);
            event.accept(BlockInit.HYDROTHERMIC_CRYSTAL);
            event.accept(BlockInit.DEEPSLATE_SCORIA_ORE);

            event.accept(ItemInit.RAW_SCORIA);
            event.accept(ItemInit.SCORIA_INGOT);
            event.accept(ItemInit.SCORIA_UPGRADE);

            event.accept(ItemInit.STEEL_INGOT);
            event.accept(ItemInit.AIR_TUBE);
            event.accept(ItemInit.AIR_FILTER);
            event.accept(ItemInit.AIR_TANK);

            event.accept(ItemInit.CALLIGRAPHY_KIT);
            event.accept(ItemInit.ANCIENT_ALPHABET);
            event.accept(ItemInit.DISC_HADAL);
            event.accept(ItemInit.DISC_HADAL_AMBIENT);

            event.accept(ItemHelper.makeRebreather(ItemInit.STEEL_REBREATHER.get(), 1.2));
            event.accept(ItemHelper.makeAirTank(ItemInit.STEEL_BACKTANK.get(), 120));
            event.accept(ItemHelper.makeFlipperss(ItemInit.STEEL_FLIPPERS.get(), 1.2));

            event.accept(ItemHelper.makeRebreather(ItemInit.NETHERITE_SCUBA.get(), 1.3));
            event.accept(ItemHelper.makeAirTank(ItemInit.DOUBLE_NETHERITE_BACKTANK.get(), 300));
            event.accept(ItemHelper.makeFlipperss(ItemInit.NETHERITE_FLIPPERS.get(), 1.3));

            event.accept(ItemHelper.makeRebreather(ItemInit.HYDROTHERMIC_HELM.get(), 1.5));
            event.accept(ItemHelper.makeAirTank(ItemInit.PRESSURIZED_HYDROTHERMIC_BACKTANK.get(), 900));
            event.accept(ItemInit.HYDROTHERMIC_LEGGINGS);
            event.accept(ItemHelper.makeFlipperss(ItemInit.HYDROTHERMIC_RAZOR_BOOTS.get(), 1.5));
        }
    }

}
