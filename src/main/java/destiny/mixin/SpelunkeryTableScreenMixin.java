package destiny.mixin;

import com.github.alexmodguy.alexscaves.client.gui.SpelunkeryTableScreen;
import destiny.secretsofthevoid.init.ItemInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static destiny.secretsofthevoid.client.gui.GUIAncientAlphabet.ALPHABET;

@Mixin(SpelunkeryTableScreen.class)
public class SpelunkeryTableScreenMixin
{

    @Inject(method = "render(Lnet/minecraft/client/gui/GuiGraphics;IIF)V", at = @At("TAIL"), remap = true)
    public void render(GuiGraphics guiGraphics, int x, int y, float partialTick, CallbackInfo ci)
    {
        renderAlphabet(guiGraphics);
    }

    public void renderAlphabet(GuiGraphics guiGraphics)
    {
        if(Minecraft.getInstance().player != null && Minecraft.getInstance().player.getInventory().hasAnyMatching(predicate -> predicate.is(ItemInit.ANCIENT_ALPHABET.get()))) {
            guiGraphics.pose().pushPose();
            guiGraphics.blit(ALPHABET, (int) (((SpelunkeryTableScreen) ((Object) this)).getMagnifyPosX(1) + 45), (int) (((SpelunkeryTableScreen) ((Object) this)).getMagnifyPosY(1) - 120), 0, 0, 80, 149);
            guiGraphics.pose().popPose();
        }
    }

}
