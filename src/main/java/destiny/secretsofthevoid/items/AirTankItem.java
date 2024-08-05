package destiny.secretsofthevoid.items;

import destiny.secretsofthevoid.client.render.SteelGearRenderProperties;
import destiny.secretsofthevoid.helper.IAirTank;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class AirTankItem extends ArmorItem implements IAirTank {
    public static final String STORED_OXYGEN = "storedOxygen";
    public static final String MAX_OXYGEN = "maxOxygen";
    public ResourceLocation texture;
    public IClientItemExtensions model;

    public AirTankItem(ArmorMaterial pMaterial, Type pType, Properties pProperties, ResourceLocation tankTexture, IClientItemExtensions model)
    {
        super(pMaterial, pType, pProperties);
        this.texture = tankTexture;
        this.model = model;
    }

    public static ItemStack getAirTank(AirTankItem item, double capacity)
    {
        ItemStack stack = new ItemStack(item);
        item.setMaxOxygen(stack, capacity);
        item.setStoredOxygen(stack, capacity);

        return stack;
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer)
    {
        consumer.accept(model);
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return true;
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        return Math.round(13.0F * (float)this.getStoredOxygen(stack) / (float)this.getMaxOxygen(stack));
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return 5592575;
    }

    @Override
    public double getMaxOxygen(ItemStack stack) {
        return stack.getOrCreateTag().getDouble(MAX_OXYGEN);
    }

    @Override
    public void setMaxOxygen(ItemStack stack, double oxygen) {
        stack.getOrCreateTag().putDouble(MAX_OXYGEN, oxygen);
    }

    @Override
    public double getStoredOxygen(ItemStack stack) {
        return stack.getOrCreateTag().getDouble(STORED_OXYGEN);
    }

    @Override
    public void setStoredOxygen(ItemStack stack, double oxygen) {
        stack.getOrCreateTag().putDouble(STORED_OXYGEN, oxygen);
    }

    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return texture.toString();
    }

    public ResourceLocation getAirTankTexture() {
        return texture;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level pLevel, List<Component> components, TooltipFlag flag) {
        if(!stack.getTag().isEmpty()) {
            MutableComponent oxygen = Component.translatable("tooltip.secretsofthevoid.tank_stored_oxygen").withStyle(ChatFormatting.BLUE);

            oxygen.append(Component.literal(Math.round(getStoredOxygen(stack)) + "").withStyle(ChatFormatting.BLUE));
            oxygen.append(Component.literal(" / ")).withStyle(ChatFormatting.BLUE);
            oxygen.append(Component.literal("" + getMaxOxygen(stack)).withStyle(ChatFormatting.BLUE));

            components.add(oxygen);
        }
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return false;
    }
}
