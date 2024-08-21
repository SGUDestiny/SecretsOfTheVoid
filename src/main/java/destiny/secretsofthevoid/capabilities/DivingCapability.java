package destiny.secretsofthevoid.capabilities;

import com.mojang.datafixers.util.Pair;
import destiny.secretsofthevoid.helper.IAirTank;
import destiny.secretsofthevoid.helper.IFlippers;
import destiny.secretsofthevoid.helper.IRebreather;
import destiny.secretsofthevoid.init.NetworkInit;
import destiny.secretsofthevoid.network.packets.SoundPackets;
import destiny.secretsofthevoid.network.packets.UpdateDivingPacket;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffects;
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
    public static final String SWIMMING_SPEED = "swimmingSpeed";
    public static final String REFILL_SOUND = "refillSound";

    public double oxygen = 0.0;
    public double maxOxygen = 0.0;
    public double oxygenEfficiency = 0.0;
    public double swimmingSpeed = 0.0;
    public boolean refillSound = false;
    public int inhaleTicker = 0;
    public int exhaleTicker = -1;
    public int bubbleTicker = -1;

    public final double oxygenDepthModifier = 0.03;
    public final double oxygenPerBreath = 10;

    public DivingCapability()
    {
    }

    //Code that runs each tick
    public void tick(Level level, Player player)
    {
        if(level.isClientSide() || level.getServer() == null)
            return;

        clientUpdate(level, player);

        //Tank
        calculateMaxOxygen(player);
        calculateStoredOxygen(player);
        calculateOxygenEfficiency(player);
        calculateDepthEfficiency(player);
        refillTank(player);

        if (shouldConsumeOxygen(player) && isPlayerSurvival(player))
            consumeOxygen(level, player);

//        if (hasOxygen(player))
//            maxOutAirSupply(player);
    }

    public boolean isPlayerSurvival(Player player) {
        return !player.isCreative() && !player.isSpectator();
    }

    public boolean shouldConsumeOxygen(Player player)
    {
        return player.canDrownInFluidType(player.getEyeInFluidType())
                && getOxygen() > 0
                && !getEquipmentAirTank(player, null).isEmpty()
                && !player.getActiveEffects().contains(MobEffects.WATER_BREATHING);
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

    public void calculateDepthEfficiency(Player player) {
        if (player.getY() < 64) {
            double depth = (64 - player.getY()) * oxygenDepthModifier;

            setOxygenEfficiency(getOxygenEfficiency() + depth);
        }
    }

    public void consumeOxygen(Level level, Player player)
    {
        List<Pair<ItemStack, IAirTank>> sortedTanks = getEquipmentAirTank(player, Comparator.comparing(airTank -> airTank.getSecond().getStoredOxygen(airTank.getFirst())));
        Pair<ItemStack, IAirTank> airTank = sortedTanks.get(0);
        ItemStack stack = airTank.getFirst();
        IAirTank tank = airTank.getSecond();

        if (inhaleTicker > 200) {
            tank.setStoredOxygen(stack, Math.max(0, tank.getStoredOxygen(stack) - (oxygenPerBreath * getOxygenEfficiency())));
            maxOutAirSupply(player);

            if(!getEquipmentRebreather(player, null).isEmpty()) {
                NetworkInit.sendTo((ServerPlayer) player, new SoundPackets.RebreatherInhale(player.blockPosition()));
            }

            inhaleTicker = 0;
            exhaleTicker = 0;
        } else inhaleTicker++;

        if (exhaleTicker > 60)
        {
            NetworkInit.sendTo((ServerPlayer) player, new SoundPackets.RebreatherExhale(player.blockPosition()));

            exhaleTicker = -1;
            bubbleTicker = 0;
        } else if (exhaleTicker >= 0) {
            exhaleTicker++;
        }

        if (bubbleTicker > 60) {
            bubbleTicker = -1;
        } else if (bubbleTicker >= 0) {
            double x = player.getEyePosition().x();
            double y = player.getEyePosition().y();
            double z = player.getEyePosition().z();

            ((ServerLevel) level).sendParticles(ParticleTypes.BUBBLE, x, y, z, 0, 0, 5, 0, 0.1D);

            bubbleTicker++;
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
        double oxygenEfficiency = 0.0D;
        List<Pair<ItemStack, IRebreather>> rebreathers = getEquipmentRebreather(player, null);
        for(Pair<ItemStack, IRebreather> rebreather : rebreathers)
        {
            ItemStack stack = rebreather.getFirst();
            IRebreather rebreath = rebreather.getSecond();

            oxygenEfficiency += rebreath.getOxygenEfficiency(stack);
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
            if (stack.getItem() instanceof IRebreather rebreather)
                equipmentList.add(new Pair<>(stack, rebreather));
        }

        if (comparator != null) return equipmentList.stream().sorted(comparator).toList();

        return equipmentList;
    }

    public List<Pair<ItemStack, IFlippers>> getEquipmentFlippers(Player player, @Nullable Comparator<Pair<ItemStack, IFlippers>> comparator)
    {
        List<Pair<ItemStack, IFlippers>> equipmentList = new ArrayList<>();
        for (ItemStack stack : player.getArmorSlots())
        {
            if (stack.getItem() instanceof IFlippers flippers)
                equipmentList.add(new Pair<>(stack, flippers));
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

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();

        tag.putDouble(OXYGEN, oxygen);
        tag.putDouble(MAX_OXYGEN, maxOxygen);
        tag.putDouble(OXYGEN_EFFICIENCY, oxygenEfficiency);
        tag.putDouble(SWIMMING_SPEED, swimmingSpeed);
        tag.putBoolean(REFILL_SOUND, refillSound);

        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag)
    {
        this.oxygen = tag.getDouble(OXYGEN);
        this.maxOxygen = tag.getDouble(MAX_OXYGEN);
        this.oxygenEfficiency = tag.getDouble(OXYGEN_EFFICIENCY);
        this.swimmingSpeed = tag.getDouble(SWIMMING_SPEED);
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
        this.oxygenEfficiency = Math.max(0.1, oxygenEfficiency);
    }

    public double getSwimmingSpeed()
    {
        return swimmingSpeed;
    }
    public void setSwimmingSpeed(double swimmingSpeed)
    {
        this.swimmingSpeed = swimmingSpeed;
    }

    public void setRefillSound(boolean refillSound) {
        this.refillSound = refillSound;
    }
    public boolean getRefillSound() {
        return refillSound;
    }
}
