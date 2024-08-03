package destiny.secretsofthevoid.capabilities;

import com.mojang.datafixers.util.Pair;
import destiny.secretsofthevoid.helper.IAirTank;
import destiny.secretsofthevoid.init.NetworkInit;
import destiny.secretsofthevoid.network.UpdateBreathingPacket;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class BreathingCapability implements INBTSerializable<CompoundTag>
{
    public static final String OXYGEN = "oxygen";
    public static final String MAX_OXYGEN = "maxOxygen";
    public static final String OXYGEN_MODIFIER = "oxygenModifier";
    public static final String MOVEMENT_MODIFIER = "movementModifier";
    public static final String SINKING_MODIFIER = "sinkingModifier";

    public double oxygen = 0.0;
    public double maxOxygen = 45.0;
    public double oxygenModifier = 1.0;
    public double movementModifier = 1.0;
    public double sinkingModifier = 1.0;

    public BreathingCapability()
    {

    }

    public void tick(Level level, Player player)
    {
        if(level.isClientSide())
            return;

        clientUpdate(level, player);

        calculateMaxOxygen(level, player);

        if(shouldIncreaseOxygen(level, player))
            increaseOxygen();
        if(shouldDecreaseOxygen(level, player))
            decreaseOxygen();
    }

    public boolean shouldIncreaseOxygen(Level level, Player player)
    {
        return !player.isInFluidType() || !player.canDrownInFluidType(player.getEyeInFluidType());
    }

    public boolean shouldDecreaseOxygen(Level level, Player player)
    {
        return player.canDrownInFluidType(player.getEyeInFluidType()) && level.getGameTime() % 20 == 0;
    }

    public void increaseOxygen()
    {
        setOxygen(getOxygen()+(getMaxOxygen()/60));

        if(getOxygen() >= getMaxOxygen())
            this.setOxygen(getMaxOxygen());
    }

    public void decreaseOxygen()
    {
        setOxygen(getOxygen()-(3*getOxygenModifier()));

        if(getOxygen() <= 0)
            setOxygen(0);
    }

    public void clientUpdate(Level level, Player player)
    {
        if(level != null && !level.isClientSide() && player instanceof ServerPlayer serverPlayer)
        {
            NetworkInit.sendTo(serverPlayer, new UpdateBreathingPacket(getOxygen(), getMaxOxygen()));
        }
    }

    public void calculateMaxOxygen(Level level, Player player)
    {
        if(level.getGameTime() % 20 == 0) {
            AtomicReference<Double> maxOxygen = new AtomicReference<>(45.0D);

            player.getArmorSlots().forEach(
            stack -> {
                if (stack.getItem() instanceof IAirTank airTank)
                    maxOxygen.set(maxOxygen.get() + airTank.getMaxOxygen(stack));
            });

            setMaxOxygen(maxOxygen.get());
        }
    }

    public void calculateStoredOxygen(Level level, Player player)
    {
        if(level.getGameTime() % 20 == 0)
        {
            List<Pair<ItemStack, IAirTank>> airTanks = new ArrayList<>();
            player.getArmorSlots().forEach(
            stack -> {
                if(stack.getItem() instanceof IAirTank airTank)
                    airTanks.add(new Pair<>(stack, airTank));
            });

            AtomicReference<Double> storedOxygen = new AtomicReference<>(0.0D);
            airTanks.forEach(
            airTank -> {
                ItemStack stack = airTank.getFirst();
                IAirTank tank = airTank.getSecond();

                storedOxygen.set(storedOxygen.get()+tank.getStoredOxygen(stack));
            });
            setOxygen(storedOxygen.get());

            fillTanks(airTanks, storedOxygen.get());
        }
    }

    public void fillTanks(List<Pair<ItemStack, IAirTank>> airTanks, double storedOxygen)
    {
        airTanks.forEach(
        airTank -> {
              ItemStack stack = airTank.getFirst();
              IAirTank tank = airTank.getSecond();

              tank.setStoredOxygen(stack, storedOxygen-tank.getMaxOxygen(stack));
        });
    }

    @Override
    public CompoundTag serializeNBT()
    {
        CompoundTag tag = new CompoundTag();

        tag.putDouble(OXYGEN, oxygen);
        tag.putDouble(MAX_OXYGEN, maxOxygen);
        tag.putDouble(OXYGEN_MODIFIER, oxygenModifier);
        tag.putDouble(MOVEMENT_MODIFIER, movementModifier);
        tag.putDouble(SINKING_MODIFIER, sinkingModifier);

        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag)
    {
        this.oxygen = tag.getDouble(OXYGEN);
        this.maxOxygen = tag.getDouble(MAX_OXYGEN);
        this.oxygenModifier = tag.getDouble(OXYGEN_MODIFIER);
        this.movementModifier = tag.getDouble(MOVEMENT_MODIFIER);
        this.sinkingModifier = tag.getDouble(SINKING_MODIFIER);
    }

    public double getOxygen()
    {
        return oxygen;
    }

    public double getMaxOxygen()
    {
        return maxOxygen;
    }

    public double getOxygenModifier()
    {
        return oxygenModifier;
    }

    public double getMovementModifier()
    {
        return movementModifier;
    }

    public double getSinkingModifier()
    {
        return sinkingModifier;
    }

    public void setOxygen(double oxygen)
    {
        this.oxygen = oxygen;
    }

    public void setMaxOxygen(double maxOxygen)
    {
        this.maxOxygen = maxOxygen;
    }

    public void setOxygenModifier(double oxygenModifier)
    {
        this.oxygenModifier = oxygenModifier;
    }

    public void setMovementModifier(double movementModifier)
    {
        this.movementModifier = movementModifier;
    }

    public void setSinkingModifier(double sinkingModifier)
    {
        this.sinkingModifier = sinkingModifier;
    }
}