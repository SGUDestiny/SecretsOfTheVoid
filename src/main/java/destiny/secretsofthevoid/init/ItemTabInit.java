package destiny.secretsofthevoid.init;

import destiny.secretsofthevoid.SecretsOfTheVoid;
import destiny.secretsofthevoid.items.AirTankItem;
import destiny.secretsofthevoid.items.RebreatherItem;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
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
                    .title(Component.translatable("itemGroup.alexscaves" + ": ")
                            .append(Component.translatable("itemGroup.secretsofthevoid.creative_tab").withStyle(ChatFormatting.DARK_BLUE)))
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
            event.accept(ItemInit.CALLIGRAPHY_KIT);
            event.accept(ItemInit.ANCIENT_ALPHABET);
            event.accept(AirTankItem.getAirTank(ItemInit.STEEL_AIR_TANK.get(), 120, 120, 10));
            event.accept(RebreatherItem.getRebreather(ItemInit.STEEL_REBREATHER.get(), 0.5, 5));
        }
    }

}
