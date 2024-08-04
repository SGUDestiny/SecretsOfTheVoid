package destiny.secretsofthevoid.init;

import destiny.secretsofthevoid.SecretsOfTheVoid;
import destiny.secretsofthevoid.items.AirTankItem;
import destiny.secretsofthevoid.items.ItemAncientAlphabet;
import destiny.secretsofthevoid.items.ItemCalligraphyKit;
import destiny.secretsofthevoid.items.RebreatherItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit
{

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SecretsOfTheVoid.MODID);

    public static final RegistryObject<ItemCalligraphyKit> CALLIGRAPHY_KIT = ITEMS.register("calligraphy_kit", () -> new ItemCalligraphyKit( new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1)));
    public static final RegistryObject<ItemAncientAlphabet> ANCIENT_ALPHABET = ITEMS.register("ancient_alphabet", () -> new ItemAncientAlphabet( new Item.Properties().rarity(Rarity.RARE).stacksTo(1)));
    public static final RegistryObject<AirTankItem> AIR_TANK = ITEMS.register("air_tank_test", () -> new AirTankItem(ArmorMaterials.IRON, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<RebreatherItem> REBREATHER = ITEMS.register("rebreather_test", () -> new RebreatherItem(ArmorMaterials.IRON, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1)));

    public static void register(IEventBus bus)
    {
        ITEMS.register(bus);
    }
}
