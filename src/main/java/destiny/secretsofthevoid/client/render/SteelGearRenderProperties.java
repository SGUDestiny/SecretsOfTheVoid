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
    private SteelGearRenderer renderer;

    public SteelGearRenderProperties()
    {

    }

    @Override
    public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
        if(this.renderer == null)
            this.renderer = new SteelGearRenderer();

        this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
        return this.renderer;
    }
}
