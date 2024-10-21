package destiny.mixin;

import com.github.alexmodguy.alexscaves.client.gui.book.CaveBookScreen;
import destiny.secretsofthevoid.SecretsOfTheVoid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(CaveBookScreen.class)
public class CaveBookScreenMixin {
    @Inject(method = "getBookFileDirectory()IIFV", at = @At("HEAD"))
    public static String getBookFileDirectory() {
        return SecretsOfTheVoid.MODID + ":books/";
    }
}
