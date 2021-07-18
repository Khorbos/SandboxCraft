package com.khorbos.sandbox.core.init;

import com.khorbos.sandbox.Sandbox;
import com.khorbos.sandbox.common.items.SpecialItem;
import com.khorbos.sandbox.common.items.ThuoniumItem;
import com.khorbos.sandbox.common.items.armor.EmeraldBoots;
import com.khorbos.sandbox.common.items.food.SandwichItem;
import com.khorbos.sandbox.common.items.tools.SandboxHammer;
import com.khorbos.sandbox.core.util.ItemProperties;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Sandbox.ID);

    public static final RegistryObject<SandwichItem> sandwich = ITEMS.register("sandwich", () -> new SandwichItem());
    public static final RegistryObject<SandboxHammer> sandbox_hammer = ITEMS.register("sandbox_hammer", () -> new SandboxHammer());
    public static final RegistryObject<SpecialItem> special_item = ITEMS.register("special_item", () -> new SpecialItem());
    public static final RegistryObject<Item> copper_ingot = ITEMS.register("copper_ingot", () -> new Item(ItemProperties.BASIC_PROPERTIES));
    public static final RegistryObject<Item> raw_copper = ITEMS.register("raw_copper", () -> new Item(ItemProperties.BASIC_PROPERTIES));
    public static final RegistryObject<EmeraldBoots> emerald_boots = ITEMS.register("emerald_boots", () -> new EmeraldBoots());
    public static final RegistryObject<ThuoniumItem> thuonium = ITEMS.register("thuonium", () -> new ThuoniumItem());
}
