package destiny.secretsofthevoid.items.netherite;

import destiny.secretsofthevoid.helper.IFlippers;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.animatable.GeoItem;

import static destiny.secretsofthevoid.helper.ItemHelper.*;

public class NetheriteFlippersItem extends NetheriteGearItem implements IFlippers
{
    public NetheriteFlippersItem(ArmorMaterial pMaterial, Type pType, Properties pProperties)
    {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public double getSpeedModifier(ItemStack stack)
    {
        if(stack.getTag() != null && stack.getTag().contains(SPEED_MODIFIER))
            return stack.getTag().getDouble(SPEED_MODIFIER);
        else return 1D;
    }

    @Override
    public void setSpeedModifier(ItemStack stack, double speedModifier)
    {
        if(stack.getTag() != null)
            stack.getTag().putDouble(SPEED_MODIFIER, speedModifier);
        else stack.getOrCreateTag().putDouble(SPEED_MODIFIER, speedModifier);
    }

    @Override
    public double getSinkingModifier(ItemStack stack)
    {
        if(stack.getTag() != null && stack.getTag().contains(SINKING_MODIFIER))
            return stack.getTag().getDouble(SINKING_MODIFIER);
        else return 1D;
    }

    @Override
    public void setSinkingModifier(ItemStack stack, double sinkingModifier)
    {
        if(stack.getTag() != null)
            stack.getTag().putDouble(SINKING_MODIFIER, sinkingModifier);
        else stack.getOrCreateTag().putDouble(SINKING_MODIFIER, sinkingModifier);
    }
}
