package destiny.secretsofthevoid.client.render;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class NetheriteGearRenderProperties implements IClientItemExtensions {
    public static final NetheriteGearRenderProperties INSTANCE = new NetheriteGearRenderProperties();
    private NetheriteGearRenderer renderer;

    public NetheriteGearRenderProperties() {}

    @Override
    public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
        if(this.renderer == null)
            this.renderer = new NetheriteGearRenderer();

        this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
        return this.renderer;
    }
}
