package destiny.secretsofthevoid.init;

import destiny.secretsofthevoid.SecretsOfTheVoid;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundInit {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SecretsOfTheVoid.MODID);

    public static RegistryObject<SoundEvent> REBREATHER_INHALE = registerSoundEvent("rebreather_inhale");

    public static RegistryObject<SoundEvent> REBREATHER_EXHALE = registerSoundEvent("rebreather_exhale");

    public static RegistryObject<SoundEvent> TANK_REFILL = registerSoundEvent("tank_refill");

    public static RegistryObject<SoundEvent> DISK_HADAL = registerSoundEvent("disc/hadal");

    public static RegistryObject<SoundEvent> DISK_HADAL_AMBIENT = registerSoundEvent("disc/hadal_ambient");

    private static RegistryObject<SoundEvent> registerSoundEvent(String sound)
    {
        return SOUNDS.register(sound, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SecretsOfTheVoid.MODID, sound)));
    }
}
