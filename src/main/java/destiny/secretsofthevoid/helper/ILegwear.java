package destiny.secretsofthevoid.helper;

import net.minecraft.world.item.ItemStack;

public interface ILegwear {
    double getSwimmingSpeed(ItemStack stack);
    void setSwimmingSpeed(ItemStack stack, double swimmingSpeed);
}
