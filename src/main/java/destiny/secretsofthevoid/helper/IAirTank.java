package destiny.secretsofthevoid.helper;

import net.minecraft.world.item.ItemStack;

public interface IAirTank
{
    double getMaxOxygen(ItemStack stack);
    double getStoredOxygen(ItemStack stack);
    void setMaxOxygen(ItemStack stack, double oxygen);
    void setStoredOxygen(ItemStack stack, double oxygen);
}
