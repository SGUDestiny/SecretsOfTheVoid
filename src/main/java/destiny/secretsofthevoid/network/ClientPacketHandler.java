package destiny.secretsofthevoid.network;

import destiny.secretsofthevoid.init.CapabilitiesInit;
import destiny.secretsofthevoid.network.packets.UpdateDivingPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.level.Level;

import java.util.Optional;

public class ClientPacketHandler
{
    public static void handleUpdateBreathingPacket(UpdateDivingPacket packet) {
        getPlayer().ifPresent(
                player -> player.getCapability(CapabilitiesInit.DIVING).ifPresent(
                        cap -> {
                            cap.setOxygen(packet.oxygen);
                            cap.setMaxOxygen(packet.maxOxygen);
                            cap.setOxygenEfficiency(packet.oxygenEfficiency);
                        }
                )
        );
    }


    public static Optional<Level> getLevel() {
        Minecraft minecraft = Minecraft.getInstance();

        return minecraft.level == null ? Optional.empty() : Optional.of(Minecraft.getInstance().level);
    }

    public static Optional<LocalPlayer> getPlayer() {
        Minecraft minecraft = Minecraft.getInstance();

        return minecraft.player == null ? Optional.empty() : Optional.of(Minecraft.getInstance().player);
    }
}
