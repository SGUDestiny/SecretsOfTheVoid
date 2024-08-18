package destiny.secretsofthevoid.init;

import destiny.secretsofthevoid.SecretsOfTheVoid;
import destiny.secretsofthevoid.items.*;
import destiny.secretsofthevoid.items.netherite.NetheriteAirTankItem;
import destiny.secretsofthevoid.items.netherite.NetheriteRebreatherItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SecretsOfTheVoid.MODID);

    public static final RegistryObject<ItemCalligraphyKit> CALLIGRAPHY_KIT = ITEMS.register("calligraphy_kit",
            () -> new ItemCalligraphyKit(
            new Item.Properties()
                    .rarity(Rarity.UNCOMMON)
                    .stacksTo(1)
            )
    );
    public static final RegistryObject<ItemAncientAlphabet> ANCIENT_ALPHABET = ITEMS.register("ancient_alphabet",
            () -> new ItemAncientAlphabet(
                    new Item.Properties()
                            .rarity(Rarity.RARE)
                            .stacksTo(1)
            )
    );

    public static final RegistryObject<Item> DISC_HADAL = ITEMS.register("disc_hadal",
            () -> new RecordItem(0, SoundInit.DISK_HADAL,
                    new Item.Properties()
                            .rarity(Rarity.EPIC)
                            .stacksTo(1),
                    7620
            ));

    public static final RegistryObject<Item> DISC_HADAL_AMBIENT = ITEMS.register("disc_hadal_ambient",
            () -> new RecordItem(0, SoundInit.DISK_HADAL_AMBIENT,
                    new Item.Properties()
                            .rarity(Rarity.EPIC)
                            .stacksTo(1),
                    7600
            ));

    public static final RegistryObject<NetheriteAirTankItem> NETHERITE_AIR_TANK = ITEMS.register("armor/netherite/double_netherite_backtank",
            () -> new NetheriteAirTankItem(
                    ArmorMaterialsInit.NETHERITE_DIVING_GEAR,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()
                            .stacksTo(1))
    );

    public static final RegistryObject<NetheriteRebreatherItem> NETHERITE_SCUBA = ITEMS.register("armor/netherite/netherite_scuba",
            () -> new NetheriteRebreatherItem(ArmorMaterials.IRON,
                    ArmorItem.Type.HELMET,
                    new Item.Properties()
                            .stacksTo(1)
            )
    );

    public static void register(IEventBus bus)
    {
        ITEMS.register(bus);
    }
}
