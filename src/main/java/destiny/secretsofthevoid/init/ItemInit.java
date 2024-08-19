package destiny.secretsofthevoid.init;

import destiny.secretsofthevoid.SecretsOfTheVoid;
import destiny.secretsofthevoid.items.*;
import destiny.secretsofthevoid.items.netherite.NetheriteAirTankItem;
import destiny.secretsofthevoid.items.netherite.NetheriteFlippersItem;
import destiny.secretsofthevoid.items.netherite.NetheriteRebreatherItem;
import destiny.secretsofthevoid.items.steel.SteelAirTankItem;
import destiny.secretsofthevoid.items.steel.SteelFlippersItem;
import destiny.secretsofthevoid.items.steel.SteelRebreatherItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SecretsOfTheVoid.MODID);

    public static final RegistryObject<Item> RAW_SCORIA = ITEMS.register("raw_scoria",
            () -> new Item(
                    new Item.Properties()
                            .rarity(Rarity.RARE)
                            .stacksTo(16)
                            .fireResistant()
            )
    );
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(
                    new Item.Properties()
            )
    );
    public static final RegistryObject<Item> STEEL_TUBE = ITEMS.register("steel_tube",
            () -> new Item(
                    new Item.Properties()
                            .stacksTo(16)
            )
    );
    public static final RegistryObject<Item> STEEL_FILTER = ITEMS.register("steel_filter",
            () -> new Item(
                    new Item.Properties()
                            .stacksTo(1)
            )
    );
    public static final RegistryObject<Item> STEEL_TANK = ITEMS.register("steel_tank",
            () -> new Item(
                    new Item.Properties()
                            .stacksTo(1)
            )
    );

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

    public static final RegistryObject<SteelRebreatherItem> STEEL_REBREATHER = ITEMS.register("armor/steel/steel_rebreather",
            () -> new SteelRebreatherItem(
                    ArmorMaterialsInit.STEEL_DIVING_GEAR,
                    ArmorItem.Type.HELMET,
                    new Item.Properties()
                            .stacksTo(1)
            )
    );
    public static final RegistryObject<SteelAirTankItem> STEEL_AIR_TANK = ITEMS.register("armor/steel/steel_backtank",
            () -> new SteelAirTankItem(
                    ArmorMaterialsInit.STEEL_DIVING_GEAR,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()
                            .stacksTo(1))
    );
    public static final RegistryObject<SteelFlippersItem> STEEL_FLIPPERS = ITEMS.register("armor/steel/steel_flippers",
            () -> new SteelFlippersItem(
                    ArmorMaterialsInit.STEEL_DIVING_GEAR,
                    ArmorItem.Type.BOOTS,
                    new Item.Properties()
                            .stacksTo(1)
            )
    );

    public static final RegistryObject<NetheriteRebreatherItem> NETHERITE_REBREATHER = ITEMS.register("armor/netherite/netherite_scuba",
            () -> new NetheriteRebreatherItem(
                    ArmorMaterialsInit.NETHERITE_DIVING_GEAR,
                    ArmorItem.Type.HELMET,
                    new Item.Properties()
                            .stacksTo(1)
            )
    );
    public static final RegistryObject<NetheriteAirTankItem> NETHERITE_AIR_TANK = ITEMS.register("armor/netherite/double_netherite_backtank",
            () -> new NetheriteAirTankItem(
                    ArmorMaterialsInit.NETHERITE_DIVING_GEAR,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()
                            .stacksTo(1))
    );
    public static final RegistryObject<NetheriteFlippersItem> NETHERITE_FLIPPERS = ITEMS.register("armor/netherite/netherite_flipper_boots",
            () -> new NetheriteFlippersItem(
                    ArmorMaterialsInit.NETHERITE_DIVING_GEAR,
                    ArmorItem.Type.BOOTS,
                    new Item.Properties()
                            .stacksTo(1)
            )
    );

    public static void register(IEventBus bus)
    {
        ITEMS.register(bus);
    }
}
