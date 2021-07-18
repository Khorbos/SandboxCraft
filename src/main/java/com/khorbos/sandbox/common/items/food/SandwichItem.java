package com.khorbos.sandbox.common.items.food;

import com.khorbos.sandbox.Sandbox;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class SandwichItem extends Item {
    public SandwichItem() {
        super(new Item.Properties()
                .group(Sandbox.itemGroup)
                .food(new Food.Builder().hunger(10).saturation(1.2F).effect(new EffectInstance(Effects.ABSORPTION, 6000, 1), 1).build())
        );
    }
}
