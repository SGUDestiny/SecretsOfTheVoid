package destiny.secretsofthevoid.capabilities;

import com.google.common.util.concurrent.AtomicDouble;
import com.mojang.datafixers.util.Pair;
import destiny.secretsofthevoid.helper.IAirTank;
import destiny.secretsofthevoid.helper.IRebreather;
import destiny.secretsofthevoid.init.NetworkInit;
import destiny.secretsofthevoid.network.UpdateDivingPacket;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.INBTSerializable;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class DivingCapability implements INBTSerializable<CompoundTag> {
    public static final String OXYGEN = "oxygen";
    public static final String MAX_OXYGEN = "maxOxygen";
    public static final String OXYGEN_EFFICIENCY = "oxygenEfficiency";
    public static final String SPEED_MODIFIER = "speedModifier";
    public static final String SINKING_MODIFIER = "sinkingModifier";

    public double oxygen = 0.0;
    public double maxOxygen = 0.0;
    public double oxygenEfficiency = 0.0;
    public double speedModifier = 0.0;
    public double sinkingModifier = 0.0;

    public DivingCapability() {
    }

    //Code that runs each tick
    public void tick(Level level, Player player) {
        if(level.isClientSide()) {
            return;
        }

        clientUpdate(level, player);

        calculateStoredOxygen(level, player);
        calculateMaxOxygen(level, player);
        calculateOxygenEfficiency(level, player);

        if(shouldRefillTank(player)) {
            refillTank(player);
        }
        if(shouldConsumeOxygen(level, player)) {
            consumeOxygen(player);
        }
        if(hasOxygen(player)) {
            maxOutAirSupply(player);
        }
    }

    public boolean shouldRefillTank(Player player) {
        return (!player.isInFluidType() || !player.canDrownInFluidType(player.getEyeInFluidType())) && getOxygen() < getMaxOxygen();
    }

    public boolean shouldConsumeOxygen(Level level, Player player) {
        return player.canDrownInFluidType(player.getEyeInFluidType()) && getOxygen() > 0 && level.getGameTime() % 100 == 0;
    }

    public boolean hasOxygen(Player player) {
        return player.canDrownInFluidType(player.getEyeInFluidType()) && getOxygen() > 0;
    }

    public void refillTank(Player player) {
        List<Pair<ItemStack, IAirTank>> sortedTanks = getEquipmentAirTank(player, Comparator.comparing(airTank -> airTank.getSecond().getMaxOxygen(airTank.getFirst())));
        sortedTanks.forEach(
                airTank -> {
                    ItemStack stack = airTank.getFirst();
                    IAirTank tank = airTank.getSecond();

                    if (tank.getStoredOxygen(stack) != tank.getMaxOxygen(stack)) {
                        tank.setStoredOxygen(stack, tank.getStoredOxygen(stack) + (tank.getMaxOxygen(stack) / 60));
                    }
                }
        );
    }

    public void consumeOxygen(Player player) {
        List<Pair<ItemStack, IAirTank>> sortedTanks = getEquipmentAirTank(player, Comparator.comparing(airTank -> airTank.getSecond().getStoredOxygen(airTank.getFirst())));
        Pair<ItemStack, IAirTank> airTank = sortedTanks.get(0);
        ItemStack stack = airTank.getFirst();
        IAirTank tank = airTank.getSecond();

        tank.setStoredOxygen(stack, Math.round(Math.max(0, tank.getStoredOxygen(stack) - (3 * getOxygenEfficiency()))));
    }

    public void maxOutAirSupply(Player player) {
        player.setAirSupply(player.getMaxAirSupply());
    }

    public void clientUpdate(Level level, Player player) {
        if(level != null && !level.isClientSide() && player instanceof ServerPlayer serverPlayer) {
            NetworkInit.sendTo(serverPlayer, new UpdateDivingPacket(getOxygen(), getMaxOxygen(), getOxygenEfficiency()));
        }
    }

    public void calculateMaxOxygen(Level level, Player player) {
        if(level.getGameTime() % 20 == 0) {
            AtomicReference<Double> maxOxygen = new AtomicReference<>(0.0D);

            player.getArmorSlots().forEach(
                    stack -> {
                        if (stack.getItem() instanceof IAirTank airTank) {
                            maxOxygen.set(maxOxygen.get() + airTank.getMaxOxygen(stack));
                        }
                    }
            );

            setMaxOxygen(maxOxygen.get());
        }
    }

    public void calculateStoredOxygen(Level level, Player player) {
        if(level.getGameTime() % 20 == 0) {
            List<Pair<ItemStack, IAirTank>> airTanks = getEquipmentAirTank(player, null);

            AtomicReference<Double> storedOxygen = new AtomicReference<>(0.0D);
            airTanks.forEach(
            airTank -> {
                ItemStack stack = airTank.getFirst();
                IAirTank tank = airTank.getSecond();

                storedOxygen.set(storedOxygen.get()+tank.getStoredOxygen(stack));
            });

            setOxygen(storedOxygen.get());

            if(!airTanks.isEmpty()) {
                fillTanks(getEquipmentAirTank(player, Comparator.comparing(airTank -> airTank.getSecond().getMaxOxygen(airTank.getFirst()))), storedOxygen.get());
            }
        }
    }
    
    public void calculateOxygenEfficiency(Level level, Player player) {
        if(level.getGameTime() % 20 == 0) {
            AtomicDouble oxygenEfficiency = new AtomicDouble(1.0D);
            List<Pair<ItemStack, IRebreather>> rebreathers = getEquipmentRebreather(player, null);
            rebreathers.forEach(rebreather -> {
                ItemStack stack = rebreather.getFirst();
                IRebreather rebreath = rebreather.getSecond();

                oxygenEfficiency.set(oxygenEfficiency.get() - rebreath.getOxygenEfficiency(stack));
            });

            setOxygenEfficiency(oxygenEfficiency.get() / Math.max(1, rebreathers.size()));
        }
    }
    
    public List<Pair<ItemStack, IAirTank>> getEquipmentAirTank(Player player, @Nullable Comparator<Pair<ItemStack, IAirTank>> comparator) {
        List<Pair<ItemStack, IAirTank>> equipmentList = new ArrayList<>();
        player.getArmorSlots().forEach(
        stack -> {
            if(stack.getItem() instanceof IAirTank tank) {
                equipmentList.add(new Pair<>(stack, tank));
            }
        });

        if(comparator != null) {
            return equipmentList.stream().sorted(comparator).toList();
        }

        return equipmentList;
    }

    public List<Pair<ItemStack, IRebreather>> getEquipmentRebreather(Player player, @Nullable Comparator<Pair<ItemStack, IRebreather>> comparator) {
        List<Pair<ItemStack, IRebreather>> equipmentList = new ArrayList<>();
        player.getArmorSlots().forEach(
                stack -> {
                    if(stack.getItem() instanceof IRebreather tank) {
                        equipmentList.add(new Pair<>(stack, tank));
                    }
                }
        );

        if(comparator != null) {
            return equipmentList.stream().sorted(comparator).toList();
        }

        return equipmentList;
    }

    public void fillTanks(List<Pair<ItemStack, IAirTank>> airTanks, double storedOxygen) {
        List<Pair<ItemStack, IAirTank>> sortedByCapacity = airTanks.stream().sorted(Comparator.comparing(func -> func.getSecond().getMaxOxygen(func.getFirst()))).toList();

        for(double i = storedOxygen; i > 0D;) {
            AtomicDouble capacityToRemove = new AtomicDouble(0.0D);
            sortedByCapacity.forEach(
            airTank -> {
                ItemStack stack = airTank.getFirst();
                IAirTank tank = airTank.getSecond();
                double maxCapacity = tank.getMaxOxygen(stack);

                tank.setStoredOxygen(stack, Math.min(storedOxygen, maxCapacity));
                capacityToRemove.set(capacityToRemove.get()+Math.min(storedOxygen, maxCapacity));
            });
            i -= capacityToRemove.get();
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

        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        this.oxygen = tag.getDouble(OXYGEN);
        this.maxOxygen = tag.getDouble(MAX_OXYGEN);
        this.oxygenEfficiency = tag.getDouble(OXYGEN_EFFICIENCY);
        this.speedModifier = tag.getDouble(SPEED_MODIFIER);
        this.sinkingModifier = tag.getDouble(SINKING_MODIFIER);
    }

    public double getOxygen() {
        return oxygen;
    }
    public void setOxygen(double oxygen) {
        this.oxygen = oxygen;
    }

    public double getMaxOxygen() {
        return maxOxygen;
    }
    public void setMaxOxygen(double maxOxygen) {
        this.maxOxygen = maxOxygen;
    }

    public double getOxygenEfficiency() {
        return oxygenEfficiency;
    }
    public void setOxygenEfficiency(double oxygenEfficiency) {
        this.oxygenEfficiency = oxygenEfficiency;
    }

    public double getSpeedModifier() {
        return speedModifier;
    }
    public void setSpeedModifier(double speedModifier) {
        this.speedModifier = speedModifier;
    }

    public double getSinkingModifier() {
        return sinkingModifier;
    }
    public void setSinkingModifier(double sinkingModifier) {
        this.sinkingModifier = sinkingModifier;
    }
}
