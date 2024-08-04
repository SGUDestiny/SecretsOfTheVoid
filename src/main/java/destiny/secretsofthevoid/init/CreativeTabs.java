package destiny.secretsofthevoid.init;

import destiny.secretsofthevoid.SecretsOfTheVoid;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class CreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SecretsOfTheVoid.MODID);

    public static final List<Supplier<? extends ItemLike>> CREATIVE_TAB_ITEMS = new ArrayList<>();

    public static final RegistryObject<CreativeModeTab> CREATIVE_TAB = CREATIVE_MODE_TABS.register("secretsofthevoid",
            () -> CreativeModeTab.builder()
                    .icon(() -> ItemInit.CALLIGRAPHY_KIT.get().getDefaultInstance())
                    .title(Component.translatable("itemGroup.alexscaves" + ": ")
                            .append(Component.translatable("itemGroup.secretsofthevoid.creative_tab").withStyle(ChatFormatting.DARK_BLUE)))
                    .build()
    );
}
