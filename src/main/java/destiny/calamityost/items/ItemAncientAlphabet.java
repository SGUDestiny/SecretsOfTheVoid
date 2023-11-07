package destiny.calamityost.items;

import destiny.calamityost.CalamityOST;
import destiny.calamityost.client.gui.GUIAncientAlphabet;
import destiny.calamityost.helper.ClientHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemAncientAlphabet extends Item {

    public ItemAncientAlphabet(Properties properties) {
        super(properties);
    }
    // Should open a texture on RMB; If present in hotbar, adds a texture to Spelunkery table GUI on the right side
    public @NotNull InteractionResult interactLivingEntity(ItemStack stack, Player playerIn, LivingEntity target, InteractionHand handIn){
        stack = playerIn.getItemInHand(handIn);
        if (playerIn instanceof ServerPlayer serverPlayerEntity) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.awardStat(Stats.ITEM_USED.get(this));
        }
        if (playerIn.level().isClientSide) {
            ClientHelper.openGUI(new GUIAncientAlphabet());
        }
        return InteractionResult.CONSUME;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.calamityost.ancient_alphabet")
                .setStyle(Style.EMPTY.withItalic(true).withColor(ChatFormatting.GRAY)));
    }
}
