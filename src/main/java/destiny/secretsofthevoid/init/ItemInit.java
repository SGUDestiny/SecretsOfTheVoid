package destiny.secretsofthevoid.init;

import com.github.alexmodguy.alexscaves.server.item.ACItemRegistry;
import destiny.secretsofthevoid.SecretsOfTheVoid;
import destiny.secretsofthevoid.items.*;
import destiny.secretsofthevoid.items.scoria.ScoriaAirTankItem;
import destiny.secretsofthevoid.items.scoria.ScoriaFlippersItem;
import destiny.secretsofthevoid.items.scoria.ScoriaLeggingsItem;
import destiny.secretsofthevoid.items.scoria.ScoriaRebreatherItem;
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
                            .fireResistant()
            )
    );
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(
                    new Item.Properties()
            )
    );

    public static final RegistryObject<Item> SCORIA_INGOT = ITEMS.register("scoria_ingot",
            () -> new Item(
                    new Item.Properties()
                            .rarity(Rarity.RARE)
                            .fireResistant()
                            .stacksTo(16)
            )
    );
    public static final RegistryObject<Item> AIR_TUBE = ITEMS.register("air_tube",
            () -> new Item(
                    new Item.Properties()
                            .stacksTo(16)
            )
    );
    public static final RegistryObject<Item> AIR_FILTER = ITEMS.register("air_filter",
            () -> new Item(
                    new Item.Properties()
                            .stacksTo(1)
            )
    );
    public static final RegistryObject<Item> AIR_TANK = ITEMS.register("air_tank",
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
                    .craftRemainder(Items.GLOW_INK_SAC)
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
    public static final RegistryObject<SteelAirTankItem> STEEL_BACKTANK = ITEMS.register("armor/steel/steel_backtank",
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

    public static final RegistryObject<NetheriteRebreatherItem> NETHERITE_SCUBA = ITEMS.register("armor/netherite/netherite_scuba",
            () -> new NetheriteRebreatherItem(
                    ArmorMaterialsInit.NETHERITE_DIVING_GEAR,
                    ArmorItem.Type.HELMET,
                    new Item.Properties()
                            .stacksTo(1)
                            .fireResistant()
            )
    );
    public static final RegistryObject<NetheriteAirTankItem> DOUBLE_NETHERITE_BACKTANK = ITEMS.register("armor/netherite/double_netherite_backtank",
            () -> new NetheriteAirTankItem(
                    ArmorMaterialsInit.NETHERITE_DIVING_GEAR,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()
                            .stacksTo(1)
                            .fireResistant()
            )
    );
    public static final RegistryObject<NetheriteFlippersItem> NETHERITE_FLIPPERS = ITEMS.register("armor/netherite/netherite_flipper_boots",
            () -> new NetheriteFlippersItem(
                    ArmorMaterialsInit.NETHERITE_DIVING_GEAR,
                    ArmorItem.Type.BOOTS,
                    new Item.Properties()
                            .stacksTo(1)
                            .fireResistant()
            )
    );

    public static final RegistryObject<ScoriaRebreatherItem> HYDROTHERMIC_HELM = ITEMS.register("armor/scoria/scoria_helm",
            () -> new ScoriaRebreatherItem(
                    ArmorMaterialsInit.HYDROTHERMIC_DIVING_GEAR,
                    ArmorItem.Type.HELMET,
                    new Item.Properties()
                            .stacksTo(1)
                            .fireResistant()
            )
    );
    public static final RegistryObject<ScoriaAirTankItem> PRESSURIZED_HYDROTHERMIC_BACKTANK = ITEMS.register("armor/scoria/pressurized_scoria_backtank",
            () -> new ScoriaAirTankItem(
                    ArmorMaterialsInit.HYDROTHERMIC_DIVING_GEAR,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()
                            .stacksTo(1)
                            .fireResistant()
            )
    );
    public static final RegistryObject<ScoriaLeggingsItem> HYDROTHERMIC_LEGGINGS = ITEMS.register("armor/scoria/scoria_leggings",
            () -> new ScoriaLeggingsItem(
                    ArmorMaterialsInit.HYDROTHERMIC_DIVING_GEAR,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Properties()
                            .stacksTo(1)
                            .fireResistant()
            )
    );
    public static final RegistryObject<ScoriaFlippersItem> HYDROTHERMIC_RAZOR_BOOTS = ITEMS.register("armor/scoria/scoria_razor_boots",
            () -> new ScoriaFlippersItem(
                    ArmorMaterialsInit.HYDROTHERMIC_DIVING_GEAR,
                    ArmorItem.Type.BOOTS,
                    new Item.Properties()
                            .stacksTo(1)
                            .fireResistant()
            )
    );

    public static void register(IEventBus bus)
    {
        ITEMS.register(bus);
    }
}
