package com.khorbos.sandbox.core.util.enums;

import com.khorbos.sandbox.Sandbox;
import com.khorbos.sandbox.core.init.ItemInit;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ModArmorMaterial implements IArmorMaterial {
    EMERALD(Sandbox.ID + ":emerald", 69, new int[]{7, 9, 11, 7}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 4.0F, () -> {
        return Ingredient.fromItems(ItemInit.EMERALD_BOOTS.get());
    });

    private String nameIn;
    private static final int[] MAX_DAMAGE_ARRAY = new int[] {16,16,16,16};
    private final int maxDamageFactor, enchantabilityIn;
    private final int[] damageReductionAmountArray;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final LazyValue<Ingredient> repairMaterial;

    ModArmorMaterial(String nameIn, int maxDamageFactor, int[] damageReductionAmountArray, int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn) {
        this.nameIn = nameIn;
        this.maxDamageFactor = maxDamageFactor;
        this.enchantabilityIn = enchantabilityIn;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.soundEvent = soundEventIn;
        this.toughness = toughnessIn;
        this.repairMaterial = new LazyValue<Ingredient>(repairMaterialIn);
    }


    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()]* this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantabilityIn;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return this.nameIn;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }
}
