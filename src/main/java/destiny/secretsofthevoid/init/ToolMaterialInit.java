package destiny.secretsofthevoid.init;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public enum ToolMaterialInit implements Tier
{
    STEEL(3, 900, 10.0F, 3F, 8, ItemInit.STEEL_INGOT.get()),
    SCORIA(5, 3800, 15.0F, 5F, 15, ItemInit.SCORIA_INGOT.get());

    private float attackDamage, efficiency;
    private int durability, harvestLevel, enchantability;
    private Item repairMaterial;

    private ToolMaterialInit(int harvestLevel, int durability, float efficiency, float attackDamage, int enchantability, Item repairMaterial)
    {
        this.harvestLevel = harvestLevel;
        this.durability = durability;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getUses()
    {
        return this.durability;
    }

    @Override
    public float getSpeed()
    {
        return this.efficiency;
    }

    @Override
    public float getAttackDamageBonus()
    {
        return this.attackDamage;
    }

    @Override
    public int getLevel()
    {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantmentValue()
    {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return Ingredient.of(repairMaterial);
    }
}