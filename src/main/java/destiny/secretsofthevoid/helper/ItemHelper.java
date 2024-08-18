package destiny.secretsofthevoid.helper;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ItemHelper
{
    public static final String STORED_OXYGEN = "storedOxygen";
    public static final String MAX_OXYGEN = "maxOxygen";
    public static final String OXYGEN_EFFICIENCY = "oxygenEfficiency";
    public static final String SINKING_MODIFIER = "sinkingModifier";
    public static final String SPEED_MODIFIER = "speedModifier";

    public static  <T extends Item & IAirTank> ItemStack makeAirTank
        (T item, double maxOxygen, double storedOxygen)
    {
        ItemStack stack = new ItemStack(item);
        item.setMaxOxygen(stack, maxOxygen);
        item.setStoredOxygen(stack, storedOxygen);

        return stack;
    }

    public static  <T extends Item & IAirTank> ItemStack makeAirTank
            (T item, double maxOxygen)
    {
        ItemStack stack = new ItemStack(item);
        item.setMaxOxygen(stack, maxOxygen);
        item.setStoredOxygen(stack, maxOxygen);

        return stack;
    }

    public static  <T extends Item & IRebreather> ItemStack makeRebreather
            (T item, double oxygenEfficiency)
    {
        ItemStack stack = new ItemStack(item);
        item.setOxygenEfficiency(stack, oxygenEfficiency);

        return stack;
    }

    public static  <T extends Item & IFlippers> ItemStack makeFlipperss
            (T item, double sinkingModifier, double speedModifier)
    {
        ItemStack stack = new ItemStack(item);
        item.setSinkingModifier(stack, sinkingModifier);
        item.setSpeedModifier(stack, speedModifier);

        return stack;
    }
}
