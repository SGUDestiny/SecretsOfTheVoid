package destiny.secretsofthevoid.capabilities;

import com.mojang.datafixers.util.Pair;
import destiny.secretsofthevoid.helper.IAirTank;
import destiny.secretsofthevoid.helper.IRebreather;
import destiny.secretsofthevoid.init.NetworkInit;
import destiny.secretsofthevoid.network.packets.SoundPackets;
import destiny.secretsofthevoid.network.packets.UpdateDivingPacket;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.INBTSerializable;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DivingCapability implements INBTSerializable<CompoundTag>
{
    public static final String OXYGEN = "oxygen";
    public static final String MAX_OXYGEN = "maxOxygen";
    public static final String OXYGEN_EFFICIENCY = "oxygenEfficiency";
    public static final String SPEED_MODIFIER = "speedModifier";
    public static final String SINKING_MODIFIER = "sinkingModifier";
    public static final String REFILL_SOUND = "refillSound";

    public double oxygen = 0.0;
    public double maxOxygen = 0.0;
    public double oxygenEfficiency = 0.0;
    public double speedModifier = 0.0;
    public double sinkingModifier = 0.0;
    public boolean refillSound = false;

    public DivingCapability()
    {
    }

    //Code that runs each tick
    public void tick(Level level, Player player)
    {
        if(level.isClientSide())
        {
            return;
        }

        clientUpdate(level, player);

        //Rebreather
        if(shouldCalculateRebreather(player)) {
            rebreatherExhaleSound(level, player);
        }

        //Tank
        calculateMaxOxygen(player);
        calculateStoredOxygen(player);
        refillTank(player);
        calculateOxygenEfficiency(player);

        if(shouldConsumeOxygen(level, player))
            consumeOxygen(player);
        
        if(hasOxygen(player))
            maxOutAirSupply(player);
        
    }

    public boolean shouldCalculateTank(Player player)
    {
        return !getEquipmentAirTank(player, null).isEmpty();
    }

    public boolean shouldCalculateRebreather(Player player)
    {
        return !getEquipmentRebreather(player, null).isEmpty();
    }

    public boolean shouldConsumeOxygen(Level level, Player player)
    {
        return player.canDrownInFluidType(player.getEyeInFluidType()) && getOxygen() > 0 && !getEquipmentAirTank(player, null).isEmpty() && level.getGameTime() % 60 == 0;
    }

    public boolean hasOxygen(Player player)
    {
        return player.canDrownInFluidType(player.getEyeInFluidType()) && getOxygen() > 0;
    }

    public void refillTank(Player player) {
        List<Pair<ItemStack, IAirTank>> sortedTanks = getEquipmentAirTank(player, Comparator.comparing(airTank -> airTank.getSecond().getMaxOxygen(airTank.getFirst())));
        for(Pair<ItemStack, IAirTank> airTank : sortedTanks)
        {
            ItemStack stack = airTank.getFirst();
            IAirTank tank = airTank.getSecond();

            if (!player.getEyeInFluidType().canDrownIn(player) && getOxygen() < getMaxOxygen()) {
                if (tank.getStoredOxygen(stack) != tank.getMaxOxygen(stack)) {
                    tank.setStoredOxygen(stack, tank.getStoredOxygen(stack) + (tank.getMaxOxygen(stack) / 60));
                }
                if (!getRefillSound()) {
                    NetworkInit.sendTo((ServerPlayer) player, new SoundPackets.TankRefill(player.blockPosition()));
                    setRefillSound(true);
                }
            }
            if (getRefillSound() && player.getEyeInFluidType().canDrownIn(player)) {
                setRefillSound(false);
            }
        }
    }

    public void consumeOxygen(Player player)
    {
        List<Pair<ItemStack, IAirTank>> sortedTanks = getEquipmentAirTank(player, Comparator.comparing(airTank -> airTank.getSecond().getStoredOxygen(airTank.getFirst())));
        Pair<ItemStack, IAirTank> airTank = sortedTanks.get(0);
        ItemStack stack = airTank.getFirst();
        IAirTank tank = airTank.getSecond();

        tank.setStoredOxygen(stack, Math.max(0, tank.getStoredOxygen(stack) - (3 * getOxygenEfficiency())));

        if(!getEquipmentRebreather(player, null).isEmpty()) {
            NetworkInit.sendTo((ServerPlayer) player, new SoundPackets.RebreatherInhale(player.blockPosition()));
        } else {
            NetworkInit.sendTo((ServerPlayer) player, new SoundPackets.RebreatherExhale(player.blockPosition()));
        }
    }


    public void maxOutAirSupply(Player player)
    {
        player.setAirSupply(player.getMaxAirSupply());
    }

    public void clientUpdate(Level level, Player player)
    {
        if(level != null && !level.isClientSide() && player instanceof ServerPlayer serverPlayer)
        {
            NetworkInit.sendTo(serverPlayer, new UpdateDivingPacket(getOxygen(), getMaxOxygen(), getOxygenEfficiency()));
        }
    }

    public void calculateMaxOxygen(Player player) {
        List<Pair<ItemStack, IAirTank>> airTanks = getEquipmentAirTank(player, null);
        double maxOxygen = 0.0D;

        for(Pair<ItemStack, IAirTank> airTank : airTanks)
        {
            ItemStack stack = airTank.getFirst();
            IAirTank tank = airTank.getSecond();

            maxOxygen += tank.getMaxOxygen(stack);
        }

        setMaxOxygen(maxOxygen);
    }

    public void calculateStoredOxygen(Player player) {
        List<Pair<ItemStack, IAirTank>> airTanks = getEquipmentAirTank(player, null);

        double storedOxygen = 0.0D;
        for(Pair<ItemStack, IAirTank> airTank : airTanks)
        {
            ItemStack stack = airTank.getFirst();
            IAirTank tank = airTank.getSecond();

            storedOxygen += tank.getStoredOxygen(stack);
        }
        setOxygen(storedOxygen);

        if(!airTanks.isEmpty()) {
            fillTanks(getEquipmentAirTank(player, Comparator.comparing(airTank -> airTank.getSecond().getMaxOxygen(airTank.getFirst()))), storedOxygen);
        }
    }
    
    public void calculateOxygenEfficiency(Player player)
    {
        double oxygenEfficiency = 1.0D;
        List<Pair<ItemStack, IRebreather>> rebreathers = getEquipmentRebreather(player, null);
        for(Pair<ItemStack, IRebreather> rebreather : rebreathers)
        {
            ItemStack stack = rebreather.getFirst();
            IRebreather rebreath = rebreather.getSecond();

            oxygenEfficiency -= rebreath.getOxygenEfficiency(stack);
        }

        setOxygenEfficiency(oxygenEfficiency);
    }
    
    public List<Pair<ItemStack, IAirTank>> getEquipmentAirTank(Player player, @Nullable Comparator<Pair<ItemStack, IAirTank>> comparator)
    {
        List<Pair<ItemStack, IAirTank>> equipmentList = new ArrayList<>();
        for (ItemStack stack : player.getArmorSlots())
        {
            if (stack.getItem() instanceof IAirTank tank)
                equipmentList.add(new Pair<>(stack, tank));
        }

        if (comparator != null) return equipmentList.stream().sorted(comparator).toList();

        return equipmentList;
    }

    public List<Pair<ItemStack, IRebreather>> getEquipmentRebreather(Player player, @Nullable Comparator<Pair<ItemStack, IRebreather>> comparator)
    {
        List<Pair<ItemStack, IRebreather>> equipmentList = new ArrayList<>();
        for (ItemStack stack : player.getArmorSlots())
        {
            if (stack.getItem() instanceof IRebreather tank)
                equipmentList.add(new Pair<>(stack, tank));
        }

        if (comparator != null) return equipmentList.stream().sorted(comparator).toList();

        return equipmentList;
    }

    public void fillTanks(List<Pair<ItemStack, IAirTank>> airTanks, double storedOxygen)
    {
        for(double i = storedOxygen; i > 0D;) {
            for(Pair<ItemStack, IAirTank> airTank : airTanks)
            {
                ItemStack stack = airTank.getFirst();
                IAirTank tank = airTank.getSecond();
                double maxCapacity = tank.getMaxOxygen(stack);

                tank.setStoredOxygen(stack, Math.min(storedOxygen, maxCapacity));
                i -= Math.min(storedOxygen, maxCapacity);
            }
        }
    }

    public void rebreatherExhaleSound(Level level, Player player)
    {
        if(!getEquipmentRebreather(player, null).isEmpty() && player.canDrownInFluidType(player.getEyeInFluidType()) && getOxygen() > 0 && level.getGameTime() % 300 == 0) {
            NetworkInit.sendTo((ServerPlayer) player, new SoundPackets.RebreatherExhale(player.blockPosition()));
        }
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();

        tag.putDouble(OXYGEN, oxygen);
        tag.putDouble(MAX_OXYGEN, maxOxygen);
        tag.putDouble(OXYGEN_EFFICIENCY, oxygenEfficiency);
        tag.putDouble(SPEED_MODIFIER, speedModifier);
        tag.putDouble(SINKING_MODIFIER, sinkingModifier);
        tag.putBoolean(REFILL_SOUND, refillSound);

        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag)
    {
        this.oxygen = tag.getDouble(OXYGEN);
        this.maxOxygen = tag.getDouble(MAX_OXYGEN);
        this.oxygenEfficiency = tag.getDouble(OXYGEN_EFFICIENCY);
        this.speedModifier = tag.getDouble(SPEED_MODIFIER);
        this.sinkingModifier = tag.getDouble(SINKING_MODIFIER);
        this.refillSound = tag.getBoolean(REFILL_SOUND);
    }

    public double getOxygen()
    {
        return oxygen;
    }
    public void setOxygen(double oxygen)
    {
        this.oxygen = oxygen;
    }

    public double getMaxOxygen()
    {
        return maxOxygen;
    }
    public void setMaxOxygen(double maxOxygen)
    {
        this.maxOxygen = maxOxygen;
    }

    public double getOxygenEfficiency()
    {
        return oxygenEfficiency;
    }
    public void setOxygenEfficiency(double oxygenEfficiency)
    {
        this.oxygenEfficiency = oxygenEfficiency;
    }

    public double getSpeedModifier()
    {
        return speedModifier;
    }
    public void setSpeedModifier(double speedModifier)
    {
        this.speedModifier = speedModifier;
    }

    public double getSinkingModifier()
    {
        return sinkingModifier;
    }
    public void setSinkingModifier(double sinkingModifier)
    {
        this.sinkingModifier = sinkingModifier;
    }

    public void setRefillSound(boolean refillSound) {
        this.refillSound = refillSound;
    }
    public boolean getRefillSound() {
        return refillSound;
    }
}
