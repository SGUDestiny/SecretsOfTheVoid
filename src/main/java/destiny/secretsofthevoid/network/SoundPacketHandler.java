package destiny.secretsofthevoid.network;

import destiny.secretsofthevoid.init.SoundInit;
import destiny.secretsofthevoid.network.packets.SoundPackets;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.RandomSequence;

import java.util.Random;

public class SoundPacketHandler
{
    public static Minecraft minecraft = Minecraft.getInstance();

    public static void handleRebreatherInhale(SoundPackets.RebreatherInhale packet)
    {
        SoundInstance sound = new SimpleSoundInstance(SoundInit.REBREATHER_INHALE.get(), SoundSource.PLAYERS, 1.0f, 1.0f, SoundInstance.createUnseededRandom(), packet.pos);
        minecraft.getSoundManager().play(sound);
    }

    public static void handleRebreatherExhale(SoundPackets.RebreatherExhale packet)
    {
        SoundInstance sound = new SimpleSoundInstance(SoundInit.REBREATHER_EXHALE.get(), SoundSource.PLAYERS, 1.0f, 1.0f, SoundInstance.createUnseededRandom(), packet.pos);
        minecraft.getSoundManager().play(sound);
    }

    public static void handleTankRefill(SoundPackets.TankRefill packet)
    {
        SoundInstance sound = new SimpleSoundInstance(SoundInit.TANK_REFILL.get(), SoundSource.PLAYERS, 1.0f, 1.0f, SoundInstance.createUnseededRandom(), packet.pos);
        minecraft.getSoundManager().play(sound);
    }
}
