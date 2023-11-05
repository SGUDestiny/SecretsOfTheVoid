package destiny.calamityost.client;

import destiny.calamityost.CalamityOST;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import com.github.alexmodguy.alexscaves.server.level.biome.ACBiomeRegistry;


@EventBusSubscriber(modid = CalamityOST.MODID, value = Dist.CLIENT, bus = Bus.MOD)
public class SoundtrackTrigger {
    @SubscribeEvent
    public static void getPlayerPos(TickEvent.PlayerTickEvent event) {
        Minecraft mc = Minecraft.getInstance();
        BlockPos pos = mc.getCameraEntity().blockPosition();
        double player = event.player.getY();
        Minecraft.getInstance().level.getBiome(pos);
        if (mc.level != null && mc.level.isLoaded(pos)) {
            Holder<Biome> biomeHolder = mc.level.getBiome(pos);

            if (!biomeHolder.isBound())
                return;

            Biome biome = biomeHolder.value();
            if (biomeHolder == ACBiomeRegistry.ABYSSAL_CHASM) {
                System.out.println("TEST");
            }
        }
    }
}
