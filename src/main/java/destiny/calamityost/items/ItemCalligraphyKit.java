package destiny.calamityost.items;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

public class ItemCalligraphyKit extends Item {

    public ItemCalligraphyKit(Properties props) {
        super(props);
    }
    // If player looks at enchanting table and holds Shift+RMB on it for 3 seconds with the item,
    // upon letting go it will turn into Ancient Alphabet item
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(ItemStack p_41454_) {
        return 60;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        player.startUsingItem(hand);

        return InteractionResultHolder.success(itemstack);
    }

    @Override
    public void onUseTick(Level worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
        if(count % 8 == 0) {
            livingEntityIn.gameEvent(GameEvent.ITEM_INTERACT_START);
            RandomSource rng = worldIn.getRandom();
            livingEntityIn.playSound(SoundEvents.BOOK_PAGE_TURN, 1.0F, 1.2F + (rng.nextFloat()) * 0.2F);
        }
    }

    public void releaseUsing(ItemStack stack, Level worldIn, LivingEntity livingEntityIn, int i){
        stack = new ItemStack(ModItemRegistry.ANCIENT_ALPHABET.get());
    }
}
