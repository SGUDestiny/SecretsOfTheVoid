package destiny.mixin;

import destiny.secretsofthevoid.capabilities.DivingCapability;
import destiny.secretsofthevoid.init.CapabilitiesInit;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.fluids.FluidType;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin
{

    public void sinkInFluid(FluidType type)
    {
        LivingEntity self = ((LivingEntity) (Object) this);
        if(self instanceof Player player)
            if(player.getCapability(CapabilitiesInit.DIVING).isPresent())
            {
                DivingCapability cap = player.getCapability(CapabilitiesInit.DIVING).orElse(null);

                if(cap != null && !cap.getEquipmentFlippers(player, null).isEmpty())
                    return;
            }

        self.setDeltaMovement(self.getDeltaMovement().add(0.0D, (double)-0.04F * self.getAttributeValue(ForgeMod.SWIM_SPEED.get()), 0.0D));

    }
}
