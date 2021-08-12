package com.khorbos.sandbox.common.items.food;

import com.khorbos.sandbox.Sandbox;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class CornItem extends Item {
    public CornItem() {
        super(new Item.Properties()
                .group(Sandbox.itemGroup)
                .food(new Food.Builder().hunger(10).saturation(1.2F).build())
        );
    }
}
