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

// Mod should check each 10 ticks if the player is in Abyssal Chasm biome; If true, runs a check to determine player's Y level.
// Depending on the value, there are three outcomes - Three OST's that play on defined range respectably.
// First abyssal layer triggers if Y < 64 && Y > 32
// Second layer if Y < 32 && Y > -32
// Third layer if Y < -32 && Y > -64

// Sound transitions should be not abrupt but smooth instead, by decreasing the volume of current track and increasing the
// volume of new one simultaneously

// Fourth track should trigger when Hullbreaker mob has targeted the player
// It abruptly ends any playing track, replacing it
