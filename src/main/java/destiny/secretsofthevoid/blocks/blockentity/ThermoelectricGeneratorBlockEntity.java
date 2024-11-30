package destiny.secretsofthevoid.blocks.blockentity;

import destiny.secretsofthevoid.init.BlockEntitiesInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class ThermoelectricGeneratorBlockEntity extends BlockEntity implements GeoBlockEntity {

    private static final RawAnimation ACTIVE = RawAnimation.begin().thenLoop("active");
    private static final RawAnimation INACTIVE = RawAnimation.begin().thenPlayAndHold("inactive");

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public ThermoelectricGeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntitiesInit.THERMOELECTRIC_GENERATOR.get(), pos, state);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 10, state -> {
            return state.setAndContinue(INACTIVE);
                })
                .triggerableAnim("active", ACTIVE)
                .triggerableAnim("inactive", INACTIVE)
        );
    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}