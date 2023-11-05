package destiny.calamityost;

import com.github.alexmodguy.alexscaves.server.entity.living.HullbreakerEntity;
import com.github.alexmodguy.alexscaves.server.level.biome.ACBiomeRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CalamityOST.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CalamityEvents {

    @SubscribeEvent
    public static void causeEidolonSound(LivingEvent.LivingTickEvent event){
        Entity entity = event.getEntity();
        Minecraft mc = Minecraft.getInstance();
        if(entity instanceof HullbreakerEntity){
            if(mc.player == ((HullbreakerEntity) entity).getTarget()){
                mc.player.playSound(CalamitySounds.ADULTEIDOLONWYRM.get());
            }
        }
    }

    @SubscribeEvent
    public static void getPlayerPos(TickEvent.PlayerTickEvent event) {
        Minecraft mc = Minecraft.getInstance();
        BlockPos pos = event.player.blockPosition();
        if (mc.level != null && mc.level.isLoaded(pos)) {
            Holder<Biome> biomeHolder = mc.level.getBiome(pos);

            if (!biomeHolder.isBound())
                return;

            Biome biome = biomeHolder.value();
            if (biomeHolder.is(ACBiomeRegistry.ABYSSAL_CHASM)) {
                System.out.println("TEST" + biome);
                double y = event.player.getY();
                if(y < 64 && y > 32){
                    event.player.playSound(CalamitySounds.ABYSS1.get(), 1, 1);
                }
                else if(y < 32 && y > -32){
                    event.player.playSound(CalamitySounds.ABYSS2.get(), 1,1);
                }
                else if(y < -32 && y > -64){
                    event.player.playSound(CalamitySounds.ABYSS3.get(), 1,1);
                }
            }
        }
    }
}
