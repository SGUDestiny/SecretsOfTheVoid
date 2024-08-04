package destiny.secretsofthevoid.client.render.airtanks;

import destiny.secretsofthevoid.client.models.airtanks.SteelAirTank;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

public class AirTankRenderProperties implements IClientItemExtensions
{
    public static final AirTankRenderProperties INSTANCE = new AirTankRenderProperties();

    public AirTankRenderProperties()
    {

    }

    @Override
    public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
        return SteelAirTank.INSTANCE;
    }
}
