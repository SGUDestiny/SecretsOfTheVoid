package destiny.calamityost;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CalamitySounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, CalamityOST.MODID);
    //Tardis Land/Takeoff
    public static final RegistryObject<SoundEvent> ABYSS1 = SOUNDS.register("abyss1", () -> setupSound("abyss1"));
    public static final RegistryObject<SoundEvent> ABYSS2 = SOUNDS.register("abyss2", () -> setupSound("abyss2"));
    public static final RegistryObject<SoundEvent> ABYSS3 = SOUNDS.register("abyss3", () -> setupSound("abyss3"));
    public static final RegistryObject<SoundEvent> ADULTEIDOLONWYRM = SOUNDS.register("adult_eidolon_wyrm", () -> setupSound("adult_eidolon_wyrm"));


    private static SoundEvent setupSound(String soundName) {
        return SoundEvent.createVariableRangeEvent(new ResourceLocation(CalamityOST.MODID, soundName));
    }

}
