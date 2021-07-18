package com.khorbos.sandbox.core.util.enums;

import com.khorbos.sandbox.core.init.ItemInit;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

public enum ModItemTier implements IItemTier {
    EMERALD(4, 2402, 10F, 4.0F, 10, () -> {
        return Ingredient.fromItems(ItemInit.sandbox_hammer.get());
    });

    private final int harvestLevel;
    private final int maxUsesIn;
    private final float efficiencyIn;
    private final float attackDamageIn;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;

    ModItemTier(int harvestLevel, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUsesIn = maxUsesIn;
        this.efficiencyIn = efficiencyIn;
        this.attackDamageIn = attackDamageIn;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyValue<Ingredient>(repairMaterial);
    }

    @Override
    public int getMaxUses() {
        return this.maxUsesIn;
    }

    @Override
    public float getEfficiency() {
        return this.efficiencyIn;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamageIn;
    }

    @Override
    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }
}
