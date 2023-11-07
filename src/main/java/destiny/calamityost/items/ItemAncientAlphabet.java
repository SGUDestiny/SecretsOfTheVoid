package destiny.calamityost.items;

import destiny.calamityost.CalamityOST;
import destiny.calamityost.client.gui.GUIAncientAlphabet;
import destiny.calamityost.helper.ClientHelper;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ItemAncientAlphabet extends Item {

    public ItemAncientAlphabet(Properties properties) {
        super(properties);
    }
    // Should open a texture on RMB; If present in hotbar, adds a texture to Spelunkery table GUI on the right side
    public InteractionResult interactLivingEntity(ItemStack stack, Player playerIn, LivingEntity target, InteractionHand hand){
        ItemStack itemStackIn = playerIn.getItemInHand(hand);
        if (playerIn instanceof ServerPlayer serverplayerentity) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, itemStackIn);
            serverplayerentity.awardStat(Stats.ITEM_USED.get(this));
        }
        if (playerIn.level().isClientSide) {
            ClientHelper.openGUI(new GUIAncientAlphabet());
        }
        return InteractionResult.CONSUME;
    }

}
