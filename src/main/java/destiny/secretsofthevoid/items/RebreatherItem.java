package destiny.secretsofthevoid.items;

import destiny.secretsofthevoid.helper.IAirTank;
import destiny.secretsofthevoid.helper.IRebreather;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class RebreatherItem extends ArmorItem implements IRebreather
{
    public static final String OXYGEN_MODIFIER = "oxygenModifier";

    public RebreatherItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    public static ItemStack getRebreather(RebreatherItem item, double oxygenModifier)
    {
        ItemStack stack = new ItemStack(item);
        item.setOxygenModifier(stack, oxygenModifier);

        return stack;
    }

    @Override
    public double getOxygenModifier(ItemStack stack) {
        return stack.getOrCreateTag().getDouble(OXYGEN_MODIFIER);
    }

    @Override
    public void setOxygenModifier(ItemStack stack, double oxygenModifier) {
        stack.getOrCreateTag().putDouble(OXYGEN_MODIFIER, oxygenModifier);
    }
}
