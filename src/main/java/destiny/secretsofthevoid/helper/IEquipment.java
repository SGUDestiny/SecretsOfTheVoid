package destiny.secretsofthevoid.helper;

import net.minecraft.world.item.ItemStack;

public interface IEquipment
{
    double getPressureResistance(ItemStack stack);
    void setPressureResistance(ItemStack stack, double pressureResistance);
}
