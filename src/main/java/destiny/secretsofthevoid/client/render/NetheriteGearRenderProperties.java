package destiny.secretsofthevoid.client.render;

import destiny.secretsofthevoid.client.models.SteelGearModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class NetheriteGearRenderProperties implements IClientItemExtensions
{
    public static final NetheriteGearRenderProperties INSTANCE = new NetheriteGearRenderProperties();

    public NetheriteGearRenderProperties()
    {

    }

    @Override
    public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
        return SteelGearModel.INSTANCE;
    }
}
