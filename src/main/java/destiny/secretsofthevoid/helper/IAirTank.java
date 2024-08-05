package destiny.secretsofthevoid.helper;

import net.minecraft.world.item.ItemStack;

public interface IAirTank
{
    double getMaxOxygen(ItemStack stack);
    void setMaxOxygen(ItemStack stack, double oxygen);

    double getStoredOxygen(ItemStack stack);
    void setStoredOxygen(ItemStack stack, double oxygen);
}
