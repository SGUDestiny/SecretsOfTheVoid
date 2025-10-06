package destiny.secretsofthevoid.helper;

import net.minecraft.world.item.ItemStack;

public interface IMask
{
    double getMaskEfficiency(ItemStack stack);
    void setMaskEfficiency(ItemStack stack, double maskEfficiency);
}
