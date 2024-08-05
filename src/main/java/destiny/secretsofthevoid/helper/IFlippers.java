package destiny.secretsofthevoid.helper;

import net.minecraft.world.item.ItemStack;

public interface IFlippers
{
    double getSpeedModifier(ItemStack stack);
    void setSpeedModifier(ItemStack stack, double speedModifier);

    double getSinkingModifier(ItemStack stack);
    void setSinkingModifier(ItemStack stack, double sinkingModifier);
}
