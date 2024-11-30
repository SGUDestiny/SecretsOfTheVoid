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
                    .icon(() -> ItemInit.SCORIA_INGOT.get().getDefaultInstance())
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
            event.accept(BlockInit.ABYSSMARINE_SIGIL_COMMONER);
            event.accept(BlockInit.ABYSSMARINE_SIGIL_KNIGHT);
            event.accept(BlockInit.ABYSSMARINE_SIGIL_MAGE);

            event.accept(BlockInit.DEEPSLATE_SCORIA_ORE);
            event.accept(BlockInit.OXYGEN_VENT);

            event.accept(BlockInit.HYDROTHERMIC_CRYSTAL);
            event.accept(ItemInit.RAW_SCORIA);
            event.accept(ItemInit.SCORIA_INGOT);
            event.accept(BlockInit.SCORIA_BLOCK);

            event.accept(BlockInit.THERMOELECTRIC_GENERATOR);
            event.accept(BlockInit.PRESSURE_DRAIN);
            event.accept(BlockInit.SHIMMERSTEEL_BLOCK);
            event.accept(ItemInit.SHIMMERSTEEL_INGOT);
            event.accept(ItemInit.AIR_TUBE);
            event.accept(ItemInit.AIR_FILTER);
            event.accept(ItemInit.AIR_TANK);

            event.accept(ItemInit.CALLIGRAPHY_KIT);
            event.accept(ItemInit.ANCIENT_ALPHABET);
            event.accept(ItemInit.DISC_FRAGMENT_HADAL);
            event.accept(ItemInit.DISC_HADAL);
            event.accept(ItemInit.DISC_HADAL_AMBIENT);
            event.accept(ItemInit.SCORIA_UPGRADE);

            event.accept(ItemHelper.makeRebreather(ItemInit.SHIMMERSTEEL_REBREATHER.get(), 1.2));
            event.accept(ItemHelper.makeAirTank(ItemInit.SHIMMERSTEEL_BACKTANK.get(), 120));
            event.accept(ItemHelper.makeFlippers(ItemInit.SHIMMERSTEEL_FLIPPERS.get(), 0.5));

            event.accept(ItemHelper.makeRebreather(ItemInit.NETHERITE_SCUBA.get(), 1.3));
            event.accept(ItemHelper.makeAirTank(ItemInit.DOUBLE_NETHERITE_BACKTANK.get(), 300));
            event.accept(ItemHelper.makeFlippers(ItemInit.NETHERITE_FLIPPERS.get(), 0.7));

            event.accept(ItemHelper.makeRebreather(ItemInit.SCORIA_HELM.get(), 1.5));
            event.accept(ItemHelper.makeAirTank(ItemInit.PRESSURIZED_SCORIA_BACKTANK.get(), 900));
            event.accept(ItemHelper.makeLegwear(ItemInit.SCORIA_LEGWEAR.get(), 0.25));
            event.accept(ItemHelper.makeFlippers(ItemInit.SCORIA_RAZOR_BOOTS.get(), 0.75));

            event.accept(ItemInit.SHIMMERSTEEL_HELMET);
            event.accept(ItemInit.SHIMMERSTEEL_CHESTPLATE);
            event.accept(ItemInit.SHIMMERSTEEL_LEGGINGS);
            event.accept(ItemInit.SHIMMERSTEEL_BOOTS);

            event.accept(ItemInit.SCORIA_HELMET);
            event.accept(ItemInit.SCORIA_CHESTPLATE);
            event.accept(ItemInit.SCORIA_LEGGINGS);
            event.accept(ItemInit.SCORIA_BOOTS);

            event.accept(ItemInit.SHIMMERSTEEL_SWORD);
            event.accept(ItemInit.SHIMMERSTEEL_AXE);
            event.accept(ItemInit.SHIMMERSTEEL_PICKAXE);
            event.accept(ItemInit.SHIMMERSTEEL_SHOVEL);
            event.accept(ItemInit.SHIMMERSTEEL_HOE);

            event.accept(ItemInit.SCORIA_SWORD);
            event.accept(ItemInit.SCORIA_AXE);
            event.accept(ItemInit.SCORIA_PICKAXE);
            event.accept(ItemInit.SCORIA_SHOVEL);
            event.accept(ItemInit.SCORIA_HOE);

            event.accept(ItemInit.IRON_BRUSH);
            event.accept(ItemInit.SHIMMERSTEEL_BRUSH);
            event.accept(ItemInit.SCORIA_BRUSH);
        }
    }

}
