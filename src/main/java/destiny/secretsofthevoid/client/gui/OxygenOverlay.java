package destiny.secretsofthevoid.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import destiny.secretsofthevoid.SecretsOfTheVoid;
import destiny.secretsofthevoid.capabilities.DivingCapability;
import destiny.secretsofthevoid.init.CapabilitiesInit;
import destiny.secretsofthevoid.network.ClientPacketHandler;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

@SuppressWarnings("ConstantConditions")
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
        double oxygen =  0.0D;
        double maxOxygen = 0.0D;
        LocalPlayer player = ClientPacketHandler.getPlayer().orElse(null);
        if(player != null && player.getCapability(CapabilitiesInit.DIVING).isPresent()) {
            DivingCapability cap = player.getCapability(CapabilitiesInit.DIVING).orElse(null);

            oxygen = cap.getOxygen();
            maxOxygen = cap.getMaxOxygen();

            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

            double percentage = (oxygen / maxOxygen) * 100;

            if(!player.getEyeInFluidType().canDrownIn(player)) {
                y += 9;
            }

            if (!player.isCreative() && !player.isSpectator()) {
                if (oxygen > 0) {
                    for (int i = 0; i < 10; i++) {
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
