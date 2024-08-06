package destiny.secretsofthevoid.items;

import destiny.secretsofthevoid.helper.IRebreather;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RebreatherItem extends NetheriteDivingGearItem implements IRebreather
{
    public static final String OXYGEN_EFFICIENCY = "oxygenEfficiency";

    public RebreatherItem(ArmorMaterial pMaterial, Type pType, Properties pProperties)
    {
        super(pMaterial, pType, pProperties);
    }

    public static ItemStack getRebreather(RebreatherItem item, double oxygenEfficiency)
    {
        ItemStack stack = new ItemStack(item);
        item.setOxygenEfficiency(stack, oxygenEfficiency);

        return stack;
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
