package destiny.secretsofthevoid.items;

import destiny.secretsofthevoid.helper.IRebreather;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class RebreatherItem extends ArmorItem implements IRebreather
{
    public static final String OXYGEN_EFFICIENCY = "oxygenEfficiency";
    public ResourceLocation texture;
    public IClientItemExtensions model;

    public RebreatherItem(ArmorMaterial pMaterial, Type pType, Properties pProperties, ResourceLocation texture, IClientItemExtensions extension)
    {
        super(pMaterial, pType, pProperties);
        this.texture = texture;
        this.model = extension;
    }

    public static ItemStack getRebreather(RebreatherItem item, double oxygenEfficiency)
    {
        ItemStack stack = new ItemStack(item);
        item.setOxygenEfficiency(stack, oxygenEfficiency);

        return stack;
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer)
    {
        consumer.accept(model);
    }

    @Override
    public double getOxygenEfficiency(ItemStack stack)
    {
        return stack.getOrCreateTag().getDouble(OXYGEN_EFFICIENCY);
    }

    @Override
    public void setOxygenEfficiency(ItemStack stack, double oxygenModifier)
    {
        stack.getOrCreateTag().putDouble(OXYGEN_EFFICIENCY, oxygenModifier);
    }

    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type)
    {
        return texture.toString();
    }

    public ResourceLocation getRebreatherTexture()
    {
        return texture;
    }

    public IClientItemExtensions getRebreatherModel()
    {
        return model;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level pLevel, List<Component> components, TooltipFlag flag)
    {
        if(!stack.getTag().isEmpty()) {
            MutableComponent efficiency = Component.translatable("tooltip.secretsofthevoid.rebreather_efficiency").withStyle(ChatFormatting.BLUE);
            efficiency.append(Component.literal(getOxygenEfficiency(stack) + "").withStyle(ChatFormatting.BLUE));

            components.add(efficiency);
        }
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return false;
    }
}
