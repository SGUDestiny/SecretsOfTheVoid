package destiny.secretsofthevoid.helper;

import net.minecraft.world.item.ItemStack;

public interface IAirTank extends IEquipment {
    double getMaxOxygen(ItemStack stack);
    double getStoredOxygen(ItemStack stack);
    void setMaxOxygen(ItemStack stack, double oxygen);
    void setStoredOxygen(ItemStack stack, double oxygen);
}
