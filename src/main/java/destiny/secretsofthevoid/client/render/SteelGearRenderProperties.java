package destiny.secretsofthevoid.client.render;

import destiny.secretsofthevoid.client.models.SteelGearModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class SteelGearRenderProperties implements IClientItemExtensions
{
    public static final SteelGearRenderProperties INSTANCE = new SteelGearRenderProperties();

    public SteelGearRenderProperties()
    {

    }

    @Override
    public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
        return SteelGearModel.INSTANCE;
    }
}
