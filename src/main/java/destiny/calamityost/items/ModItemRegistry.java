package destiny.calamityost.items;

import destiny.calamityost.CalamityOST;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemRegistry {

    public static final DeferredRegister<Item> DEF_REG = DeferredRegister.create(ForgeRegistries.ITEMS, CalamityOST.MODID);

    public static final RegistryObject<Item> CALLIGRAPHY_KIT = DEF_REG.register("calligraphy_kit", () -> new ItemCalligraphyKit( new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1)));
    public static final RegistryObject<Item> ANCIENT_ALPHABET = DEF_REG.register("ancient_alphabet", () -> new ItemAncientAlphabet( new Item.Properties().rarity(Rarity.RARE).stacksTo(1)));

    public static void setupTabs(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES)
        {
            event.accept(CALLIGRAPHY_KIT);
            event.accept(ANCIENT_ALPHABET);
        }
    }
}
