package destiny.calamityost.client.gui;

import com.github.alexthe666.citadel.client.gui.GuiBasicBook;
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
    public static final ResourceLocation ALPHABET = new ResourceLocation(CalamityOST.MODID, "textures/gui/spelunkery_table_ancient_alphabet.png");
    public GUIAncientAlphabet(Component component) {
        super(component);
    }

    public void render(GuiGraphics guiGraphics, int x, int y, float f) {
        this.renderBackground(guiGraphics);
        int i = (this.width - 80) / 2;
        int j = (this.height - 149) / 2;
        guiGraphics.blit(ALPHABET, i, j, 0, 0, 80, 149);
    }
}
