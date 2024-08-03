package destiny.secretsofthevoid.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class UpdateBreathingPacket
{
    public double oxygen;
    public double maxOxygen;

    public UpdateBreathingPacket(double oxygen, double maxOxygen)
    {
        this.oxygen = oxygen;
        this.maxOxygen = maxOxygen;
    }

    public static void write(UpdateBreathingPacket packet, FriendlyByteBuf buffer)
    {
        buffer.writeDouble(packet.oxygen);
        buffer.writeDouble(packet.maxOxygen);
    }

    public static UpdateBreathingPacket read(FriendlyByteBuf buffer)
    {
        double oxygen = buffer.readDouble();
        double maxOxygen = buffer.readDouble();

        return new UpdateBreathingPacket(oxygen, maxOxygen);
    }

    public static void handle(UpdateBreathingPacket packet, Supplier<NetworkEvent.Context> context)
    {
        context.get().enqueueWork(() -> ClientPacketHandler.handleUpdateBreathingPacket(packet));
        context.get().setPacketHandled(true);
    }
}
