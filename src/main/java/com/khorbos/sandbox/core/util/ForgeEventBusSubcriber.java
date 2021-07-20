package com.khorbos.sandbox.core.util;

import com.khorbos.sandbox.Sandbox;
import com.khorbos.sandbox.core.init.BiomeInit;
import com.khorbos.sandbox.core.init.BlockInit;
import com.khorbos.sandbox.core.init.DimensionInit;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Sandbox.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ForgeEventBusSubcriber {
    @SubscribeEvent
    public static void registerDimensions(final RegisterDimensionsEvent event){
        if(DimensionType.byName(Sandbox.MINING_DIM) == null){
            DimensionManager.registerDimension(Sandbox.MINING_DIM, DimensionInit.MINING_WORLD.get(), null, true);
        }
        Sandbox.LOGGER.debug("SandboxMod debug : Registered dimension");
    }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event){
        final IForgeRegistry<Item> registry = event.getRegistry();
        BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            final Item.Properties properties = new Item.Properties().group(Sandbox.itemGroup);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });

        Sandbox.LOGGER.debug("SandboxMod debug : Registered BlockItems");
    }

    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event){
        Sandbox.LOGGER.debug("SandboxMod debug : Registered biomes");
        BiomeInit.registerBiomes();
    }
}
