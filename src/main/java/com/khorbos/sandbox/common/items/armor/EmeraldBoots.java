package com.khorbos.sandbox.common.items.armor;

import com.khorbos.sandbox.Sandbox;
import com.khorbos.sandbox.core.util.enums.ModArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

public class EmeraldBoots extends ArmorItem {
    public EmeraldBoots() {
        super(ModArmorMaterial.EMERALD, EquipmentSlotType.FEET, new Item.Properties().group(Sandbox.itemGroup));
    }
}
