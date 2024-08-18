package destiny.secretsofthevoid.items.netherite;

import destiny.secretsofthevoid.helper.IFlippers;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;

import java.util.List;

import static destiny.secretsofthevoid.helper.ItemHelper.*;

public class NetheriteFlippersItem extends NetheriteGearItem implements IFlippers
{
    public NetheriteFlippersItem(ArmorMaterial pMaterial, Type pType, Properties pProperties)
    {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public double getSpeedModifier(ItemStack stack)
    {
        if(stack.getTag() != null && stack.getTag().contains(SPEED_MODIFIER))
            return stack.getTag().getDouble(SPEED_MODIFIER);
        else return 1D;
    }

    @Override
    public void setSpeedModifier(ItemStack stack, double speedModifier)
    {
        if(stack.getTag() != null)
            stack.getTag().putDouble(SPEED_MODIFIER, speedModifier);
        else stack.getOrCreateTag().putDouble(SPEED_MODIFIER, speedModifier);
    }

    @Override
    public double getSinkingModifier(ItemStack stack)
    {
        if(stack.getTag() != null && stack.getTag().contains(SINKING_MODIFIER))
            return stack.getTag().getDouble(SINKING_MODIFIER);
        else return 1D;
    }

    @Override
    public void setSinkingModifier(ItemStack stack, double sinkingModifier)
    {
        if(stack.getTag() != null)
            stack.getTag().putDouble(SINKING_MODIFIER, sinkingModifier);
        else stack.getOrCreateTag().putDouble(SINKING_MODIFIER, sinkingModifier);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level pLevel, List<Component> components, TooltipFlag flag)
    {
        if(!stack.getTag().isEmpty()) {
            MutableComponent sinking = Component.translatable("tooltip.secretsofthevoid.flippers_sinking").withStyle(ChatFormatting.BLUE);
            sinking.append(Component.literal(getSinkingModifier(stack) + "").withStyle(ChatFormatting.BLUE));

            MutableComponent speed = Component.translatable("tooltip.secretsofthevoid.flippers_speed").withStyle(ChatFormatting.BLUE);
            speed.append(Component.literal(getSpeedModifier(stack) + "").withStyle(ChatFormatting.BLUE));

            components.add(sinking);
            components.add(speed);
        }
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return false;
    }
}
