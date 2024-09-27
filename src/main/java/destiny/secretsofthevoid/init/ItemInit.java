package destiny.secretsofthevoid.init;

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
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ItemInit
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SecretsOfTheVoid.MODID);

    public static final RegistryObject<SmithingTemplateItem> SCORIA_UPGRADE = ITEMS.register("scoria_upgrade_smithing_template",
            () -> new SmithingTemplateItem(
                    Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(SecretsOfTheVoid.MODID, "smithing_template.scoria_upgrade.applies_to"))).withStyle(ChatFormatting.BLUE),
                    Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(SecretsOfTheVoid.MODID, "smithing_template.scoria_upgrade.ingredients"))).withStyle(ChatFormatting.BLUE),
                    Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation(SecretsOfTheVoid.MODID, "scoria_upgrade"))).withStyle(ChatFormatting.GRAY),
                    Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(SecretsOfTheVoid.MODID, "smithing_template.scoria_upgrade.base_slot_description"))),
                    Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(SecretsOfTheVoid.MODID, "smithing_template.scoria_upgrade.additions_slot_description"))),
                    List.of(
                            new ResourceLocation("item/empty_armor_slot_helmet"),
                            new ResourceLocation("item/empty_armor_slot_chestplate"),
                            new ResourceLocation("item/empty_armor_slot_leggings"),
                            new ResourceLocation("item/empty_armor_slot_boots"),
                            new ResourceLocation("item/empty_slot_sword"),
                            new ResourceLocation("item/empty_slot_axe"),
                            new ResourceLocation("item/empty_slot_pickaxe"),
                            new ResourceLocation("item/empty_slot_shovel"),
                            new ResourceLocation("item/empty_slot_hoe")
                    ),
                    List.of(
                            new ResourceLocation("item/empty_slot_ingot")
                    )
            )
    );

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

    public static final RegistryObject<SteelRebreatherItem> STEEL_REBREATHER = ITEMS.register("armor/steel/steel_scuba",
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
                            .stacksTo(1)
            )
    );
    public static final RegistryObject<SteelFlippersItem> STEEL_FLIPPERS = ITEMS.register("armor/steel/steel_flippers",
            () -> new SteelFlippersItem(
                    ArmorMaterialsInit.STEEL_DIVING_GEAR,
                    ArmorItem.Type.BOOTS,
                    new Item.Properties()
                            .stacksTo(1)
            )
    );

    public static final RegistryObject<NetheriteRebreatherItem> NETHERITE_SCUBA = ITEMS.register("armor/netherite/netherite_rebreather",
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

    public static final RegistryObject<ScoriaRebreatherItem> SCORIA_HELM = ITEMS.register("armor/scoria/scoria_helm",
            () -> new ScoriaRebreatherItem(
                    ArmorMaterialsInit.HYDROTHERMIC_DIVING_GEAR,
                    ArmorItem.Type.HELMET,
                    new Item.Properties()
                            .stacksTo(1)
                            .fireResistant()
                            .rarity(Rarity.RARE)
            )
    );
    public static final RegistryObject<ScoriaAirTankItem> PRESSURIZED_SCORIA_BACKTANK = ITEMS.register("armor/scoria/pressurized_scoria_backtank",
            () -> new ScoriaAirTankItem(
                    ArmorMaterialsInit.HYDROTHERMIC_DIVING_GEAR,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()
                            .stacksTo(1)
                            .fireResistant()
                            .rarity(Rarity.RARE)
            )
    );
    public static final RegistryObject<ScoriaLeggingsItem> SCORIA_LEGGINGS = ITEMS.register("armor/scoria/scoria_leggings",
            () -> new ScoriaLeggingsItem(
                    ArmorMaterialsInit.HYDROTHERMIC_DIVING_GEAR,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Properties()
                            .stacksTo(1)
                            .fireResistant()
                            .rarity(Rarity.RARE)
            )
    );
    public static final RegistryObject<ScoriaFlippersItem> SCORIA_RAZOR_BOOTS = ITEMS.register("armor/scoria/scoria_razor_boots",
            () -> new ScoriaFlippersItem(
                    ArmorMaterialsInit.HYDROTHERMIC_DIVING_GEAR,
                    ArmorItem.Type.BOOTS,
                    new Item.Properties()
                            .stacksTo(1)
                            .fireResistant()
                            .rarity(Rarity.RARE)
            )
    );

    public static final RegistryObject<SwordItem> STEEL_SWORD = ITEMS.register("steel_sword",
            () -> new SwordItem(ToolMaterialInit.STEEL, 4, -2.2f,
                    new Item.Properties()
            )
    );
    public static final RegistryObject<PickaxeItem> STEEL_PICKAXE = ITEMS.register("steel_pickaxe",
            () -> new PickaxeItem(ToolMaterialInit.STEEL, 2, -2.6f,
                    new Item.Properties()
            )
    );
    public static final RegistryObject<AxeItem> STEEL_AXE = ITEMS.register("steel_axe",
            () -> new AxeItem(ToolMaterialInit.STEEL, 6.0f, -2.8f,
                    new Item.Properties()
            )
    );
    public static final RegistryObject<ShovelItem> STEEL_SHOVEL = ITEMS.register("steel_shovel",
            () -> new ShovelItem(ToolMaterialInit.STEEL, 1f, -2.7f,
                    new Item.Properties()
            )
    );
    public static final RegistryObject<HoeItem> STEEL_HOE = ITEMS.register("steel_hoe",
            () -> new HoeItem(ToolMaterialInit.SCORIA, -1, -1.5f,
                    new Item.Properties()
            )
    );

    public static final RegistryObject<SwordItem> SCORIA_SWORD = ITEMS.register("scoria_sword",
            () -> new SwordItem(ToolMaterialInit.SCORIA, 4, -1.9f,
                    new Item.Properties()
                            .fireResistant()
                            .rarity(Rarity.RARE)
            )
    );
    public static final RegistryObject<PickaxeItem> SCORIA_PICKAXE = ITEMS.register("scoria_pickaxe",
            () -> new PickaxeItem(ToolMaterialInit.SCORIA, 2, -2.3f,
                    new Item.Properties()
                            .fireResistant()
                            .rarity(Rarity.RARE)
            )
    );
    public static final RegistryObject<AxeItem> SCORIA_AXE = ITEMS.register("scoria_axe",
            () -> new AxeItem(ToolMaterialInit.SCORIA, 6.0f, -2.5f,
                    new Item.Properties()
                            .fireResistant()
                            .rarity(Rarity.RARE)
            )
    );
    public static final RegistryObject<ShovelItem> SCORIA_SHOVEL = ITEMS.register("scoria_shovel",
            () -> new ShovelItem(ToolMaterialInit.SCORIA, 2.5f, -2.0f,
                    new Item.Properties()
                            .fireResistant()
                            .rarity(Rarity.RARE)
            )
    );
    public static final RegistryObject<HoeItem> SCORIA_HOE = ITEMS.register("scoria_hoe",
            () -> new HoeItem(ToolMaterialInit.SCORIA, 0, 1f,
                    new Item.Properties()
                            .fireResistant()
                            .rarity(Rarity.RARE)
            )
    );

    public static void register(IEventBus bus)
    {
        ITEMS.register(bus);
    }
}
