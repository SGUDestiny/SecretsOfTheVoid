package destiny.secretsofthevoid.init;

import destiny.secretsofthevoid.SecretsOfTheVoid;
import destiny.secretsofthevoid.blocks.HydrothermicCrystalBlock;
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

    public static final RegistryObject<Block> DEEPSLATE_SCORIA_ORE = registerBlock("deepslate_scoria_ore",
            () -> new Block(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_ORANGE)
                            .requiresCorrectToolForDrops()
                            .strength(4.0F, 60)
                            .sound(SoundType.DEEPSLATE)
            )
    );

    public static final RegistryObject<Block> HYDROTHERMIC_CRYSTAL = registerBlock("hydrothermic_crystal",
            () -> new HydrothermicCrystalBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_ORANGE)
                            .requiresCorrectToolForDrops()
                            .strength(5.0F, -1)
                            .sound(SoundType.AMETHYST_CLUSTER)
                            .lightLevel(state -> 12)
                            .noOcclusion()
            )
    );

    public static final RegistryObject<Block> OXYGEN_VENT = registerBlock("oxygen_vent",
            () -> new Block(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_GRAY)
                            .strength(4.0F, 60)
                            .sound(SoundType.DEEPSLATE)
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
