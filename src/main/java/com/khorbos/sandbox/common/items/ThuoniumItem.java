package com.khorbos.sandbox.common.items;

import com.khorbos.sandbox.Sandbox;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ThuoniumItem extends Item {
    public ThuoniumItem() {
        super(new Item.Properties().group(Sandbox.itemGroup));
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 3200;
    }
}
