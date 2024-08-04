package destiny.secretsofthevoid.items;

import destiny.secretsofthevoid.helper.IAirTank;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import org.jline.utils.Colors;

public class AirTankItem extends ArmorItem implements IAirTank
{
    public static final String STORED_OXYGEN = "storedOxygen";
    public static final String MAX_OXYGEN = "maxOxygen";

    public AirTankItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    public static ItemStack getAirTank(AirTankItem item, double maxCapacity)
    {
        ItemStack stack = new ItemStack(item);
        item.setMaxOxygen(stack, maxCapacity);
        item.setStoredOxygen(stack, maxCapacity);

        return stack;
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return true;
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        return Math.round(13.0F - (float)this.getMaxOxygen(stack) * 13.0F / (float)this.getStoredOxygen(stack));
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return 5592575;
    }

    @Override
    public double getMaxOxygen(ItemStack stack) {
        return stack.getOrCreateTag().getDouble(MAX_OXYGEN);
    }

    @Override
    public double getStoredOxygen(ItemStack stack) {
        return stack.getOrCreateTag().getDouble(STORED_OXYGEN);
    }

    @Override
    public void setMaxOxygen(ItemStack stack, double oxygen) {
        stack.getOrCreateTag().putDouble(MAX_OXYGEN, oxygen);
    }

    @Override
    public void setStoredOxygen(ItemStack stack, double oxygen) {
        stack.getOrCreateTag().putDouble(STORED_OXYGEN, oxygen);
    }
}
