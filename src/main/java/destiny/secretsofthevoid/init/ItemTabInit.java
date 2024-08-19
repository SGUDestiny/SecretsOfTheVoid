package destiny.secretsofthevoid.init;

import destiny.secretsofthevoid.SecretsOfTheVoid;
import destiny.secretsofthevoid.helper.ItemHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ItemTabInit
{
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SecretsOfTheVoid.MODID);

    public static final List<Supplier<? extends ItemLike>> CREATIVE_TAB_ITEMS = new ArrayList<>();

    public static final RegistryObject<CreativeModeTab> MAIN = TABS.register("secretsofthevoid",
            () -> CreativeModeTab.builder()
                    .icon(() -> ItemInit.CALLIGRAPHY_KIT.get().getDefaultInstance())
                    .title(Component.translatable("itemGroup.alexscaves")
                            .append(Component.literal(": "))
                            .append(Component.translatable("itemGroup.secretsofthevoid.creative_tab")))
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
            event.accept(BlockInit.DEEPSLATE_SCORIA_ORE);

            event.accept(ItemInit.RAW_SCORIA);
            event.accept(ItemInit.STEEL_INGOT);
            event.accept(ItemInit.STEEL_TUBE);
            event.accept(ItemInit.STEEL_FILTER);
            event.accept(ItemInit.STEEL_TANK);

            event.accept(ItemInit.CALLIGRAPHY_KIT);
            event.accept(ItemInit.ANCIENT_ALPHABET);
            event.accept(ItemInit.DISC_HADAL);
            event.accept(ItemInit.DISC_HADAL_AMBIENT);

            event.accept(ItemHelper.makeRebreather(ItemInit.STEEL_REBREATHER.get(), 0.2));
            event.accept(ItemHelper.makeAirTank(ItemInit.STEEL_AIR_TANK.get(), 120));
            event.accept(ItemHelper.makeFlipperss(ItemInit.STEEL_FLIPPERS.get(), 0.2));

            event.accept(ItemHelper.makeRebreather(ItemInit.NETHERITE_REBREATHER.get(), 0.5));
            event.accept(ItemHelper.makeAirTank(ItemInit.NETHERITE_AIR_TANK.get(), 300));
            event.accept(ItemHelper.makeFlipperss(ItemInit.NETHERITE_FLIPPERS.get(), 0.3));
        }
    }

}
