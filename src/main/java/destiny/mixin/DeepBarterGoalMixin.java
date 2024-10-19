package destiny.mixin;

import com.github.alexmodguy.alexscaves.server.block.blockentity.AbyssalAltarBlockEntity;
import com.github.alexmodguy.alexscaves.server.entity.ai.DeepOneBarterGoal;
import com.github.alexmodguy.alexscaves.server.entity.living.DeepOneBaseEntity;
import com.github.alexmodguy.alexscaves.server.entity.living.DeepOneEntity;
import com.github.alexmodguy.alexscaves.server.entity.living.DeepOneKnightEntity;
import com.github.alexmodguy.alexscaves.server.entity.living.DeepOneMageEntity;
import destiny.secretsofthevoid.init.BlockInit;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DeepOneBarterGoal.class)
public class DeepBarterGoalMixin
{
    @Shadow(remap = false)
    private DeepOneBaseEntity mob;

    @Inject(method = "canUse()Z", at = @At(value = "RETURN", ordinal = 1), cancellable = true)
    public void canUseInject(CallbackInfoReturnable<Boolean> cir)
    {
        DeepOneBarterGoal goal = ((DeepOneBarterGoal) (Object) this);
        if (mob.level() != null && mob.level().getBlockEntity(mob.getLastAltarPos()) instanceof AbyssalAltarBlockEntity altar)
        {
            if(!mob.level().getBlockState(altar.getBlockPos().below()).is(BlockInit.ABYSSMARINE_SIGIL_KNIGHT.get())
            && !mob.level().getBlockState(altar.getBlockPos().below()).is(BlockInit.ABYSSMARINE_SIGIL_COMMONER.get())
            && !mob.level().getBlockState(altar.getBlockPos().below()).is(BlockInit.ABYSSMARINE_SIGIL_MAGE.get()))
                cir.setReturnValue(true);

            if(mob instanceof DeepOneKnightEntity)
                cir.setReturnValue(mob.level().getBlockState(altar.getBlockPos().below()).is(BlockInit.ABYSSMARINE_SIGIL_KNIGHT.get()));

            if(mob instanceof DeepOneMageEntity)
                cir.setReturnValue(mob.level().getBlockState(altar.getBlockPos().below()).is(BlockInit.ABYSSMARINE_SIGIL_MAGE.get()));

            if(mob instanceof DeepOneEntity)
                cir.setReturnValue(mob.level().getBlockState(altar.getBlockPos().below()).is(BlockInit.ABYSSMARINE_SIGIL_COMMONER.get()));

        }
    }

}
