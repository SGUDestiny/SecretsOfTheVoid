package destiny.secretsofthevoid.init;

import com.github.alexmodguy.alexscaves.server.block.blockentity.BeholderBlockEntity;
import destiny.secretsofthevoid.SecretsOfTheVoid;
import destiny.secretsofthevoid.blocks.blockentity.OxygenVentBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntitiesInit {
    public static final DeferredRegister<BlockEntityType<?>> DEF_REG = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SecretsOfTheVoid.MODID);

    public static final RegistryObject<BlockEntityType<OxygenVentBlockEntity>> OXYGEN_VENT = DEF_REG.register("oxygen_vent", () -> BlockEntityType.Builder.of(OxygenVentBlockEntity::new, BlockInit.OXYGEN_VENT.get()).build(null));
}
