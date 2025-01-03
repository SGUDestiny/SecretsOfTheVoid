package destiny.secretsofthevoid.init;

import com.github.alexmodguy.alexscaves.server.block.GlowingAbyssmarineBlock;
import destiny.secretsofthevoid.SecretsOfTheVoid;
import destiny.secretsofthevoid.blocks.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SecretsOfTheVoid.MODID);


    public static final RegistryObject<Block> VOIDSTONE = registerBlock("voidstone",
            () -> new Block(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_MAGENTA)
                            .strength(20.0F, 2000)
                            .sound(SoundType.ANCIENT_DEBRIS)
                            .requiresCorrectToolForDrops()
            )
    );

    public static final RegistryObject<Block> SHIMMERSTEEL_BLOCK = registerBlock("shimmersteel_block",
            () -> new Block(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_CYAN)
                            .strength(6.0F, 10)
                            .sound(SoundType.METAL)
                            .requiresCorrectToolForDrops()
            )

    );

    public static final RegistryObject<Block> SCORIA_BLOCK = registerBlock("scoria_block",
            () -> new Block(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_YELLOW)
                            .strength(10.0F, 2000)
                            .sound(SoundType.METAL)
                            .requiresCorrectToolForDrops()
            )

    );

    public static final RegistryObject<Block> DEEPSLATE_SCORIA_ORE = registerBlock("deepslate_scoria_ore",
            () -> new Block(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_ORANGE)
                            .strength(15.0F, 2000)
                            .sound(SoundType.DEEPSLATE)
                            .requiresCorrectToolForDrops()
            )
    );

    public static final RegistryObject<Block> HYDROTHERMIC_CRYSTAL = registerBlock("hydrothermic_crystal",
            () -> new HydrothermicCrystalBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_ORANGE)
                            .strength(20.0F, 2000)
                            .sound(SoundType.AMETHYST_CLUSTER)
                            .requiresCorrectToolForDrops()
                            .lightLevel(state -> 12)
                            .noOcclusion()
            )
    );

    public static final RegistryObject<Block> OXYGEN_VENT = registerBlock("oxygen_vent",
            () -> new OxygenVentBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_GRAY)
                            .strength(3.0F, 6)
                            .sound(SoundType.DEEPSLATE)
                            .requiresCorrectToolForDrops()
            )
    );

    public static final RegistryObject<Block> PRESSURE_DRAIN = registerBlock("pressure_drain",
            () -> new PressureDrainBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_CYAN)
                            .strength(6.0F, 10)
                            .sound(SoundType.METAL)
                            .requiresCorrectToolForDrops()
                            .noOcclusion()
            )
    );

    public static final RegistryObject<Block> THERMOELECTRIC_GENERATOR = registerBlock("thermoelectric_generator",
            () -> new ThermoelectricGeneratorBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_ORANGE)
                            .strength(6.0F, 10)
                            .sound(SoundType.METAL)
                            .requiresCorrectToolForDrops()
                            .noOcclusion()
            )
    );

    public static final RegistryObject<AbyssmarineSigilBlock> ABYSSMARINE_SIGIL_COMMONER = registerBlock("abyssmarine_sigil_commoner",
            () -> new AbyssmarineSigilBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_BLUE)
                            .strength(3.0F, 10)
                            .sound(SoundType.DEEPSLATE)
                            .requiresCorrectToolForDrops()
            )
    );

    public static final RegistryObject<AbyssmarineSigilBlock> ABYSSMARINE_SIGIL_KNIGHT = registerBlock("abyssmarine_sigil_knight",
            () -> new AbyssmarineSigilBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_BLUE)
                            .strength(3.0F, 10)
                            .sound(SoundType.DEEPSLATE)
                            .requiresCorrectToolForDrops()
            )
    );

    public static final RegistryObject<AbyssmarineSigilBlock> ABYSSMARINE_SIGIL_MAGE = registerBlock("abyssmarine_sigil_mage",
            () -> new AbyssmarineSigilBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_BLUE)
                            .strength(3.0F, 10)
                            .sound(SoundType.DEEPSLATE)
                            .requiresCorrectToolForDrops()
            )
    );

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, Supplier<T> block){
        return ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
