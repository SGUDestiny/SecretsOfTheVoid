package destiny.secretsofthevoid.init;

import destiny.secretsofthevoid.items.AirTankItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

public class ItemTabInit
{

    public static void setupTabs(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES)
        {
            event.accept(ItemInit.CALLIGRAPHY_KIT);
            event.accept(ItemInit.ANCIENT_ALPHABET);
            event.accept(AirTankItem.getAirTank(ItemInit.AIR_TANK.get(), 240));
        }
    }

}
