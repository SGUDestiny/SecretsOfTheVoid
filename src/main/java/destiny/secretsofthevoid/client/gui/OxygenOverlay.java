package destiny.secretsofthevoid.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.datafixers.util.Pair;
import destiny.secretsofthevoid.SecretsOfTheVoid;
import destiny.secretsofthevoid.capabilities.DivingCapability;
import destiny.secretsofthevoid.helper.IAirTank;
import destiny.secretsofthevoid.init.CapabilitiesInit;
import destiny.secretsofthevoid.init.ItemInit;
import destiny.secretsofthevoid.init.SoundInit;
import destiny.secretsofthevoid.network.ClientPacketHandler;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

import java.util.Comparator;
import java.util.List;

@SuppressWarnings("ConstantConditions")
public class OxygenOverlay {
    public static ResourceLocation FULL = new ResourceLocation(SecretsOfTheVoid.MODID,
            "textures/gui/oxygen_gauge/full.png");
    public static ResourceLocation HALF = new ResourceLocation(SecretsOfTheVoid.MODID,
            "textures/gui/oxygen_gauge/half.png");
    public static final ResourceLocation EMPTY = new ResourceLocation(SecretsOfTheVoid.MODID,
            "textures/gui/oxygen_gauge/empty.png");

    public static final ResourceLocation STEEL_FULL = new ResourceLocation(SecretsOfTheVoid.MODID,
            "textures/gui/oxygen_gauge/shimmersteel/full.png");
    public static final ResourceLocation STEEL_HALF = new ResourceLocation(SecretsOfTheVoid.MODID,
            "textures/gui/oxygen_gauge/shimmersteel/half.png");

    public static final ResourceLocation NETHERITE_FULL = new ResourceLocation(SecretsOfTheVoid.MODID,
            "textures/gui/oxygen_gauge/netherite/full.png");
    public static final ResourceLocation NETHERITE_HALF = new ResourceLocation(SecretsOfTheVoid.MODID,
            "textures/gui/oxygen_gauge/netherite/half.png");

    public static final ResourceLocation SCORIA_FULL = new ResourceLocation(SecretsOfTheVoid.MODID,
            "textures/gui/oxygen_gauge/scoria/full.png");
    public static final ResourceLocation SCORIA_HALF = new ResourceLocation(SecretsOfTheVoid.MODID,
            "textures/gui/oxygen_gauge/scoria/half.png");


    public static final IGuiOverlay OVERLAY = ((gui, poseStack, partialTicks, width, height)
    -> {
        int x = width/2;
        int y = height;
        double oxygen =  0.0D;
        double maxOxygen = 0.0D;
        LocalPlayer player = ClientPacketHandler.getPlayer().orElse(null);
        if(player != null && player.getCapability(CapabilitiesInit.DIVING).isPresent()) {
            DivingCapability cap = player.getCapability(CapabilitiesInit.DIVING).orElse(null);

            List<Pair<ItemStack, IAirTank>> sortedTanks = cap.getEquipmentAirTank(player, Comparator.comparing(airTank -> airTank.getSecond().getMaxOxygen(airTank.getFirst())));
            for (Pair<ItemStack, IAirTank> airTank : sortedTanks) {
                ItemStack stack = airTank.getFirst();
                IAirTank tank = airTank.getSecond();

                if (stack.is(ItemInit.SHIMMERSTEEL_BACKTANK.get())) {
                    FULL = STEEL_FULL;
                    HALF = STEEL_HALF;
                } else if (stack.is(ItemInit.DOUBLE_NETHERITE_BACKTANK.get())) {
                    FULL = NETHERITE_FULL;
                    HALF = NETHERITE_HALF;
                } else if (stack.is(ItemInit.PRESSURIZED_SCORIA_BACKTANK.get())) {
                    FULL = SCORIA_FULL;
                    HALF = SCORIA_HALF;
                }
            }

            oxygen = cap.getOxygen();
            maxOxygen = cap.getMaxOxygen();

            boolean tankPresent = !cap.getEquipmentAirTank(player, null).isEmpty();
            boolean isSurvival = cap.isPlayerSurvival(player);

            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

            double percentage = (oxygen / maxOxygen) * 100;

            //If underwater, move gauge up to not overlap with vanilla oxygen meter
            if(!player.getEyeInFluidType().canDrownIn(player)) {
                y += 9;
            }

            if (isSurvival && tankPresent) {
                for (int i = 0; i < 10; i++) {
                    //Render empty gauge first
                    OxygenOverlay.blitEmpty(poseStack, x + 82 - (i * 8), y - 59);

                    //If tank not empty, render
                    if (oxygen > 0) {
                        if (percentage >= 10) {
                            OxygenOverlay.blitFull(poseStack, x + 82 - (i * 8), y - 59);
                        }

                        if (percentage < 10 && percentage > 0) {
                            OxygenOverlay.blitPartial(poseStack, x + 82 - (i * 8), y - 59);
                        }
                    }

                    percentage -= 10;
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
