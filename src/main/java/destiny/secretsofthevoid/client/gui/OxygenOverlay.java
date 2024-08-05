package destiny.secretsofthevoid.client.gui;

import com.google.common.util.concurrent.AtomicDouble;
import com.mojang.blaze3d.systems.RenderSystem;
import destiny.secretsofthevoid.SecretsOfTheVoid;
import destiny.secretsofthevoid.init.CapabilitiesInit;
import destiny.secretsofthevoid.network.ClientPacketHandler;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class OxygenOverlay {
    public static final ResourceLocation FULL = new ResourceLocation(SecretsOfTheVoid.MODID,
            "textures/gui/oxygen_gauge/full.png");
    public static final ResourceLocation HALF = new ResourceLocation(SecretsOfTheVoid.MODID,
            "textures/gui/oxygen_gauge/half.png");
    public static final ResourceLocation EMPTY = new ResourceLocation(SecretsOfTheVoid.MODID,
            "textures/gui/oxygen_gauge/empty.png");


    public static final IGuiOverlay OVERLAY = ((gui, poseStack, partialTicks, width, height)
    -> {
        int x = width/2;
        int y = height;
        AtomicDouble oxygen = new AtomicDouble( 0.0D);
        AtomicDouble maxOxygen = new AtomicDouble(0.0D);
        ClientPacketHandler.getPlayer().ifPresent(
                player -> player.getCapability(CapabilitiesInit.DIVING).ifPresent(
                        cap -> {
                            oxygen.set(cap.getOxygen());
                            maxOxygen.set(cap.getMaxOxygen());
                        }
                )
        );

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        double percentage = (oxygen.get() / maxOxygen.get()) * 100;

        if (oxygen.get() > 0) {
            for(int i = 0; i < 10; i++) {
                //Render empty gauge first
                OxygenOverlay.blitEmpty(poseStack, x + 82 - (i * 8), y - 59);

                if (percentage >= 10) {
                    OxygenOverlay.blitFull(poseStack, x + 82 - (i * 8), y - 59);
                }

                if (percentage < 10 && percentage > 0) {
                    OxygenOverlay.blitPartial(poseStack, x + 82 - (i * 8), y - 59);
                }

                percentage -= 10;
            }
        }
    });

    public static void blitEmpty(GuiGraphics stack, int x, int y)
    {
        stack.blit(EMPTY, x, y, 0, 0, 9, 9, 9, 9);
    }

    public static void blitPartial(GuiGraphics stack, int x, int y)
    {
        stack.blit(HALF, x, y, 18, 0, 9, 9, 9, 9);
    }

    public static void blitFull(GuiGraphics stack, int x, int y)
    {
        stack.blit(FULL, x, y, 9, 0, 9, 9,9, 9);
    }
}
