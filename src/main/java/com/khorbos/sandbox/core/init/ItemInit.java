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

    public static final RegistryObject<SandwichItem> SANDWICH = ITEMS.register("sandwich", () -> new SandwichItem());
    public static final RegistryObject<SandboxHammer> SANDBOX_HAMMER = ITEMS.register("sandbox_hammer", () -> new SandboxHammer());
    public static final RegistryObject<SpecialItem> SPECIAL_ITEM = ITEMS.register("special_item", () -> new SpecialItem());
    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", () -> new Item(ItemProperties.BASIC_PROPERTIES));
    public static final RegistryObject<Item> RAW_COPPER = ITEMS.register("raw_copper", () -> new Item(ItemProperties.BASIC_PROPERTIES));
    public static final RegistryObject<EmeraldBoots> EMERALD_BOOTS = ITEMS.register("emerald_boots", () -> new EmeraldBoots());
    public static final RegistryObject<ThuoniumItem> THUONIUM = ITEMS.register("thuonium", () -> new ThuoniumItem());
}
