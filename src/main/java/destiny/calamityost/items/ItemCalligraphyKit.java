package destiny.calamityost.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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

    @Override
    public void onStopUsing(ItemStack stack, LivingEntity entity, int count) {
        stack = ModItemRegistry.ANCIENT_ALPHABET.get().getDefaultInstance();
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.calamityost.calligraphy_kit")
                .setStyle(Style.EMPTY.withItalic(true).withColor(ChatFormatting.GRAY)));
    }
}
