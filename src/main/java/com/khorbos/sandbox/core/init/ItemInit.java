package com.khorbos.sandbox.core.init;

import com.khorbos.sandbox.Sandbox;
import com.khorbos.sandbox.common.items.ThuoniumItem;
import com.khorbos.sandbox.common.items.SpecialItem;
import com.khorbos.sandbox.common.items.food.SandwichItem;
import com.khorbos.sandbox.common.items.tools.HammerItem;
import com.khorbos.sandbox.core.util.ModArmorMaterial;
import com.khorbos.sandbox.core.util.ModItemTier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Sandbox.ID)
@Mod.EventBusSubscriber(modid = Sandbox.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemInit {
    public static final SandwichItem sandwich = new SandwichItem();
    public static final HammerItem sandbox_hammer = null;
    public static final Item special_item = null;
    public static final Item copper_ingot = null;
    public static final Item raw_copper = null;
    public static final Item emerald_boots = null;
    public static final Item thuonium = new ThuoniumItem();

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event){
        event.getRegistry().register(sandwich);
        event.getRegistry().register(new HammerItem(ModItemTier.EMERALD, 2, 2.0F, new Item.Properties().group(Sandbox.itemGroup)).setRegistryName("sandbox_hammer"));

        event.getRegistry().register(new Item(new Item.Properties().group(Sandbox.itemGroup)).setRegistryName("copper_ingot"));
        event.getRegistry().register(new Item(new Item.Properties().group(Sandbox.itemGroup)).setRegistryName("raw_copper"));

        event.getRegistry().register(new ArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.FEET, new Item.Properties().group(Sandbox.itemGroup)).setRegistryName("emerald_boots"));
        event.getRegistry().register(new SpecialItem().setRegistryName("special_item"));

        event.getRegistry().register(thuonium);
    }


}
