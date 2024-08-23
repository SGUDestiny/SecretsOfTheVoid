package destiny.secretsofthevoid.client.render;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class ScoriaGearRenderProperties implements IClientItemExtensions
{
    public static final ScoriaGearRenderProperties INSTANCE = new ScoriaGearRenderProperties();
    private ScoriaGearRenderer renderer;

    public ScoriaGearRenderProperties()
    {

    }

    @Override
    public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
        if(this.renderer == null)
            this.renderer = new ScoriaGearRenderer();

        this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
        return this.renderer;
    }
}
