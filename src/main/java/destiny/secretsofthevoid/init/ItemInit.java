package destiny.secretsofthevoid.init;

import destiny.secretsofthevoid.SecretsOfTheVoid;
import destiny.secretsofthevoid.items.*;
import destiny.secretsofthevoid.items.scoria.ScoriaAirTankItem;
import destiny.secretsofthevoid.items.scoria.ScoriaFlippersItem;
import destiny.secretsofthevoid.items.scoria.ScoriaLegwearItem;
import destiny.secretsofthevoid.items.scoria.ScoriaRebreatherItem;
import destiny.secretsofthevoid.items.netherite.NetheriteAirTankItem;
import destiny.secretsofthevoid.items.netherite.NetheriteFlippersItem;
import destiny.secretsofthevoid.items.netherite.NetheriteRebreatherItem;
import destiny.secretsofthevoid.items.shimmersteel.ShimmersteelAirTankItem;
import destiny.secretsofthevoid.items.shimmersteel.ShimmersteelFlippersItem;
import destiny.secretsofthevoid.items.shimmersteel.ShimmersteelRebreatherItem;
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

    public static final RegistryObject<BrushItem> IRON_BRUSH = ITEMS.register("iron_brush",
            () -> new BrushItem(
                    new Item.Properties()
                            .durability(128)
            )
    );

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
    public static final RegistryObject<Item> SHIMMERSTEEL_INGOT = ITEMS.register("shimmersteel_ingot",
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
            )
    );

    public static final RegistryObject<Item> DISC_HADAL_AMBIENT = ITEMS.register("disc_hadal_ambient",
            () -> new RecordItem(0, SoundInit.DISK_HADAL_AMBIENT,
                    new Item.Properties()
                            .rarity(Rarity.EPIC)
                            .stacksTo(1),
                    7600
            )
    );

    public static final RegistryObject<Item> DISC_FRAGMENT_HADAL = ITEMS.register("disc_fragment_hadal",
            () -> new DiscFragmentItem(
                    new Item.Properties()
                            .rarity(Rarity.RARE)
            )
    );

    public static final RegistryObject<ShimmersteelRebreatherItem> SHIMMERSTEEL_REBREATHER = ITEMS.register("armor/shimmersteel/shimmersteel_scuba",
            () -> new ShimmersteelRebreatherItem(
                    ArmorMaterialsInit.SHIMMERSTEEL_DIVING_GEAR,
                    ArmorItem.Type.HELMET,
                    new Item.Properties()
                            .stacksTo(1)
            )
    );
    public static final RegistryObject<ShimmersteelAirTankItem> SHIMMERSTEEL_BACKTANK = ITEMS.register("armor/shimmersteel/shimmersteel_backtank",
            () -> new ShimmersteelAirTankItem(
                    ArmorMaterialsInit.SHIMMERSTEEL_DIVING_GEAR,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()
                            .stacksTo(1)
            )
    );
    public static final RegistryObject<ShimmersteelFlippersItem> SHIMMERSTEEL_FLIPPERS = ITEMS.register("armor/shimmersteel/shimmersteel_flippers",
            () -> new ShimmersteelFlippersItem(
                    ArmorMaterialsInit.SHIMMERSTEEL_DIVING_GEAR,
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
                    ArmorMaterialsInit.SCORIA_DIVING_GEAR,
                    ArmorItem.Type.HELMET,
                    new Item.Properties()
                            .stacksTo(1)
                            .fireResistant()
                            .rarity(Rarity.RARE)
            )
    );
    public static final RegistryObject<ScoriaAirTankItem> PRESSURIZED_SCORIA_BACKTANK = ITEMS.register("armor/scoria/pressurized_scoria_backtank",
            () -> new ScoriaAirTankItem(
                    ArmorMaterialsInit.SCORIA_DIVING_GEAR,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()
                            .stacksTo(1)
                            .fireResistant()
                            .rarity(Rarity.RARE)
            )
    );
    public static final RegistryObject<ScoriaLegwearItem> SCORIA_LEGWEAR = ITEMS.register("armor/scoria/scoria_legwear",
            () -> new ScoriaLegwearItem(
                    ArmorMaterialsInit.SCORIA_DIVING_GEAR,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Properties()
                            .stacksTo(1)
                            .fireResistant()
                            .rarity(Rarity.RARE)
            )
    );
    public static final RegistryObject<ScoriaFlippersItem> SCORIA_RAZOR_BOOTS = ITEMS.register("armor/scoria/scoria_razor_boots",
            () -> new ScoriaFlippersItem(
                    ArmorMaterialsInit.SCORIA_DIVING_GEAR,
                    ArmorItem.Type.BOOTS,
                    new Item.Properties()
                            .stacksTo(1)
                            .fireResistant()
                            .rarity(Rarity.RARE)
            )
    );

    public static final RegistryObject<Item> SHIMMERSTEEL_HELMET = ITEMS.register("shimmersteel_helmet",
            () -> new ArmorItem(
                    ArmorMaterialsInit.SHIMMERSTEEL,
                    ArmorItem.Type.HELMET,
                    new Item.Properties()
                            .stacksTo(1)
            )
    );

    public static final RegistryObject<Item> SHIMMERSTEEL_CHESTPLATE = ITEMS.register("shimmersteel_chestplate",
            () -> new ArmorItem(
                    ArmorMaterialsInit.SHIMMERSTEEL,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()
                            .stacksTo(1)
            )
    );

    public static final RegistryObject<Item> SHIMMERSTEEL_LEGGINGS = ITEMS.register("shimmersteel_leggings",
            () -> new ArmorItem(
                    ArmorMaterialsInit.SHIMMERSTEEL,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Properties()
                            .stacksTo(1)
            )
    );

    public static final RegistryObject<Item> SHIMMERSTEEL_BOOTS = ITEMS.register("shimmersteel_boots",
            () -> new ArmorItem(
                    ArmorMaterialsInit.SHIMMERSTEEL,
                    ArmorItem.Type.BOOTS,
                    new Item.Properties()
                            .stacksTo(1)
            )
    );

    public static final RegistryObject<Item> SCORIA_HELMET = ITEMS.register("scoria" +
                    "_helmet",
            () -> new ArmorItem(
                    ArmorMaterialsInit.SCORIA,
                    ArmorItem.Type.HELMET,
                    new Item.Properties()
                            .stacksTo(1)
                            .rarity(Rarity.RARE)
                            .fireResistant()
            )
    );

    public static final RegistryObject<Item> SCORIA_CHESTPLATE = ITEMS.register("scoria_chestplate",
            () -> new ArmorItem(
                    ArmorMaterialsInit.SCORIA,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()
                            .stacksTo(1)
                            .rarity(Rarity.RARE)
                            .fireResistant()
            )
    );

    public static final RegistryObject<Item> SCORIA_LEGGINGS = ITEMS.register("scoria_leggings",
            () -> new ArmorItem(
                    ArmorMaterialsInit.SCORIA,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Properties()
                            .stacksTo(1)
                            .rarity(Rarity.RARE)
                            .fireResistant()
            )
    );

    public static final RegistryObject<Item> SCORIA_BOOTS = ITEMS.register("scoria_boots",
            () -> new ArmorItem(
                    ArmorMaterialsInit.SCORIA,
                    ArmorItem.Type.BOOTS,
                    new Item.Properties()
                            .stacksTo(1)
                            .rarity(Rarity.RARE)
                            .fireResistant()
            )
    );

    public static final RegistryObject<SwordItem> SHIMMERSTEEL_SWORD = ITEMS.register("shimmersteel_sword",
            () -> new SwordItem(ToolMaterialInit.SHIMMERSTEEL, 3, -2.4f,
                    new Item.Properties()
            )
    );
    public static final RegistryObject<PickaxeItem> SHIMMERSTEEL_PICKAXE = ITEMS.register("shimmersteel_pickaxe",
            () -> new PickaxeItem(ToolMaterialInit.SHIMMERSTEEL, 1, -2.8f,
                    new Item.Properties()
            )
    );
    public static final RegistryObject<AxeItem> SHIMMERSTEEL_AXE = ITEMS.register("shimmersteel_axe",
            () -> new AxeItem(ToolMaterialInit.SHIMMERSTEEL, 5.0f, -3.05f,
                    new Item.Properties()
            )
    );
    public static final RegistryObject<ShovelItem> SHIMMERSTEEL_SHOVEL = ITEMS.register("shimmersteel_shovel",
            () -> new ShovelItem(ToolMaterialInit.SHIMMERSTEEL, 1f, -3f,
                    new Item.Properties()
            )
    );
    public static final RegistryObject<HoeItem> SHIMMERSTEEL_HOE = ITEMS.register("shimmersteel_hoe",
            () -> new HoeItem(ToolMaterialInit.SHIMMERSTEEL, -3, -0.5f,
                    new Item.Properties()
            )
    );

    public static final RegistryObject<BrushItem> SHIMMERSTEEL_BRUSH = ITEMS.register("shimmersteel_brush",
            () -> new BrushItem(
                    new Item.Properties()
                            .durability(256)
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

    public static final RegistryObject<BrushItem> SCORIA_BRUSH = ITEMS.register("scoria_brush",
            () -> new BrushItem(
                    new Item.Properties()
                            .durability(512)
                            .rarity(Rarity.RARE)
            )
    );

    public static void register(IEventBus bus)
    {
        ITEMS.register(bus);
    }
}
