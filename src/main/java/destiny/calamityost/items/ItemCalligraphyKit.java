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
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.EnchantmentTableBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemCalligraphyKit extends Item {
    public ItemCalligraphyKit(Properties props) {
        super(props);
    }
    // If player looks at enchanting table and holds Shift+RMB on it for 3 seconds with the item,
    // upon letting go it will turn into Ancient Alphabet item

    //@Override
    //public int getUseDuration(ItemStack p_41454_) {
    //    return 60;
    //}
    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level levelIn = context.getLevel();
        BlockPos pos = context.getClickedPos();

        if (context.getPlayer() == null) return InteractionResult.PASS;

        BlockEntity blockEntity = levelIn.getBlockEntity(pos);

        ItemStack itemStack = new ItemStack(ModItemRegistry.ANCIENT_ALPHABET.get());

        if (blockEntity instanceof EnchantmentTableBlockEntity) {
            context.getItemInHand().shrink(1);
            context.getPlayer().addItem(itemStack);

            Level worldIn = context.getLevel();
            RandomSource rng = worldIn.getRandom();
            context.getPlayer().playSound(SoundEvents.BOOK_PAGE_TURN, 1.0F, 1.2F + (rng.nextFloat()) * 0.2F);
            context.getPlayer().playSound(SoundEvents.ENCHANTMENT_TABLE_USE, 1.0F, 1.2F + (rng.nextFloat()) * 0.2F);
            return InteractionResult.SUCCESS;
        }
        else {
            return InteractionResult.PASS;
        }
    }

    //    @Override
    //    public void onUseTick(Level worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
    //        if(count % 8 == 0) {
    //            livingEntityIn.gameEvent(GameEvent.ITEM_INTERACT_START);
    //            RandomSource rng = worldIn.getRandom();
    //            livingEntityIn.playSound(SoundEvents.BOOK_PAGE_TURN, 1.0F, 1.2F + (rng.nextFloat()) * 0.2F);
    //        }
    //    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.calamityost.calligraphy_kit")
                .setStyle(Style.EMPTY.withItalic(true).withColor(ChatFormatting.GRAY)));
    }
}
