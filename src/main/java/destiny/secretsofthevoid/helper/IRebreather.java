package destiny.secretsofthevoid.helper;

import net.minecraft.world.item.ItemStack;

public interface IRebreather
{
    double getOxygenEfficiency(ItemStack stack);
    void setOxygenEfficiency(ItemStack stack, double oxygenEfficiency);
}
