package destiny.calamityost;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CalamitySounds {

    public static final DeferredRegister<SoundEvent> DEF_REG = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, CalamityOST.MODID);
    //Tardis Land/Takeoff
    public static final RegistryObject<SoundEvent> ABYSS1 = DEF_REG.register("abyss1", () -> setupSound("abyss1"));
    public static final RegistryObject<SoundEvent> ABYSS2 = DEF_REG.register("abyss2", () -> setupSound("abyss2"));
    public static final RegistryObject<SoundEvent> ABYSS3 = DEF_REG.register("abyss3", () -> setupSound("abyss3"));
    public static final RegistryObject<SoundEvent> ADULTEIDOLONWYRM = DEF_REG.register("adult_eidolon_wyrm", () -> setupSound("adult_eidolon_wyrm"));


    private static SoundEvent setupSound(String soundName) {
        return SoundEvent.createVariableRangeEvent(new ResourceLocation(CalamityOST.MODID, soundName));
    }

}
