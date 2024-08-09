package destiny.secretsofthevoid.init;

import destiny.secretsofthevoid.SecretsOfTheVoid;
import destiny.secretsofthevoid.items.*;
import destiny.secretsofthevoid.items.netherite.NetheriteAirTankItem;
import destiny.secretsofthevoid.items.steel.SteelAirTankItem;
import destiny.secretsofthevoid.items.steel.SteelRebreatherItem;
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

    public static final RegistryObject<Item> HADAL_DISC = ITEMS.register("hadal_disc",
            () -> new RecordItem(0, SoundInit.DISK_HADAL,
                    new Item.Properties()
                            .rarity(Rarity.EPIC)
                            .stacksTo(1),
                    7620
            ));

    public static final RegistryObject<Item> HADAL_DISC_AMBIENT = ITEMS.register("hadal_disc_ambient",
            () -> new RecordItem(0, SoundInit.DISK_HADAL,
                    new Item.Properties()
                            .rarity(Rarity.EPIC)
                            .stacksTo(1),
                    7600
            ));
    public static final RegistryObject<AirTankItem> STEEL_AIR_TANK = ITEMS.register("armor/steel/steel_backtank",
            () -> new SteelAirTankItem(
                    ArmorMaterials.IRON,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()
                            .stacksTo(1)
            )
    );

    public static final RegistryObject<AirTankItem> NETHERITE_AIR_TANK = ITEMS.register("armor/netherite/double_netherite_backtank",
            () -> new NetheriteAirTankItem(
                    ArmorMaterialsInit.NETHERITE_DIVING_GEAR,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()
                            .stacksTo(1))
    );

    public static final RegistryObject<RebreatherItem> STEEL_REBREATHER = ITEMS.register("armor/steel/steel_rebreather",
            () -> new SteelRebreatherItem(ArmorMaterials.IRON,
                    ArmorItem.Type.HELMET,
                    new Item.Properties()
            )
    );

    public static final RegistryObject<RebreatherItem> NETHERITE_SCUBA = ITEMS.register("armor/netherite/netherite_scuba",
            () -> new RebreatherItem(ArmorMaterials.IRON,
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
