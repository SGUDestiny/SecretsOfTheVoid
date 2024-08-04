package destiny.secretsofthevoid.helper;

import net.minecraft.world.item.ItemStack;

public interface IRebreather
{
    double getOxygenModifier(ItemStack stack);
    void setOxygenModifier(ItemStack stack, double oxygenModifier);
}
