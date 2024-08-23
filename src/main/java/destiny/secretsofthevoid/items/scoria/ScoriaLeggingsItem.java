package destiny.secretsofthevoid.items.scoria;

import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class ScoriaLeggingsItem extends ScoriaGearItem {
    public ScoriaLeggingsItem(ArmorMaterial pMaterial, Type pType, Properties pProperties)
    {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return false;
    }
}
