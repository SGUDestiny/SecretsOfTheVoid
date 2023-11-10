package destiny.calamityost.client.gui;

import com.github.alexthe666.citadel.client.gui.GuiBasicBook;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import destiny.calamityost.CalamityOST;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GUIAncientAlphabet extends Screen {
    public static Component TITLE = Component.literal("Ancient Alphabet");

    public static final ResourceLocation ALPHABET = new ResourceLocation(CalamityOST.MODID, "textures/gui/ancient_alphabet_gui.png");
    public GUIAncientAlphabet(Component component) {
        super(component);
    }

    public GUIAncientAlphabet(){
        super(TITLE);
    }

    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics);
        guiGraphics.blit(ALPHABET, (width - 80) / 2, (height - 149) / 2, 0, 0, 80, 149);

        guiGraphics.pose().pushPose();
        guiGraphics.pose().scale(2.5f, 2.5f, 2.5f);
        guiGraphics.pose().popPose();
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
