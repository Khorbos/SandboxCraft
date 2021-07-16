package com.khorbos.sandbox.core.init;

import com.khorbos.sandbox.Sandbox;
import com.khorbos.sandbox.core.util.ModItemTier;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Sandbox.ID)
@Mod.EventBusSubscriber(modid = Sandbox.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemInit {
    public static final Item sandwich = null;
    public static final Item sandbox_hammer = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event){
        event.getRegistry().register(new Item(new Item.Properties()
                .group(Sandbox.itemGroup)
                .food(new Food.Builder().hunger(10).saturation(1.2F).effect(new EffectInstance(Effects.ABSORPTION, 6000, 1), 1).build()))
                .setRegistryName("sandwich"));

        event.getRegistry().register(new PickaxeItem(ModItemTier.EMERALD, 2, 2.0F, new Item.Properties().group(Sandbox.itemGroup)).setRegistryName("sandbox_hammer"));
    }


}
