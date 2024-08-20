package destiny.secretsofthevoid.items.hydrothermic;

import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class HydrothermicLeggingsItem extends HydrothermicGearItem {
    public HydrothermicLeggingsItem(ArmorMaterial pMaterial, Type pType, Properties pProperties)
    {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return false;
    }
}
