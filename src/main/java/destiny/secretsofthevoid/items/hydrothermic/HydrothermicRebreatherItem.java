package destiny.secretsofthevoid.items.hydrothermic;

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

import static destiny.secretsofthevoid.helper.ItemHelper.OXYGEN_EFFICIENCY;

public class HydrothermicRebreatherItem extends HydrothermicGearItem implements IRebreather {
    public HydrothermicRebreatherItem(ArmorMaterial pMaterial, Type pType, Properties pProperties)
    {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public double getOxygenEfficiency(ItemStack stack)
    {
        if(stack.getTag() != null && stack.getTag().contains(OXYGEN_EFFICIENCY))
            return stack.getTag().getDouble(OXYGEN_EFFICIENCY);
        else return 1;
    }

    @Override
    public void setOxygenEfficiency(ItemStack stack, double oxygenModifier)
    {
        if(stack.getTag() != null)
            stack.getTag().putDouble(OXYGEN_EFFICIENCY, oxygenModifier);
        else stack.getOrCreateTag().putDouble(OXYGEN_EFFICIENCY, oxygenModifier);
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
