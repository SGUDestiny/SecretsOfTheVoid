package destiny.mixin;

import destiny.secretsofthevoid.init.CapabilitiesInit;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.extensions.IForgeLivingEntity;
import net.minecraftforge.fluids.FluidType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(IForgeLivingEntity.class)
public abstract class ForgeLivingEntityMixin
{
    @Shadow public abstract LivingEntity self();

    @Inject(method = "sinkInFluid(Lnet/minecraftforge/fluids/FluidType;)V", at = @At("HEAD"), cancellable = true)
    public void dontSinkWithFlippers(FluidType type, CallbackInfo ci)
    {
        if(self() instanceof Player player)
            player.getCapability(CapabilitiesInit.DIVING).ifPresent(
            cap -> {
                if (!cap.getEquipmentFlippers(player, null).isEmpty())
                    ci.cancel();
            });
    }
}
