package com.khorbos.sandbox.core.init;

import com.khorbos.sandbox.Sandbox;
import com.khorbos.sandbox.core.util.BlockProperties;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Sandbox.ID)
@Mod.EventBusSubscriber(modid = Sandbox.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit {
    public static final Block sandbox_block = null;

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event){
        event.getRegistry().register(new Block(BlockProperties.FURNACE_PROPERTIES).setRegistryName("sandbox_block"));
    }

    @SubscribeEvent
    public static void registerBlocksItem(final RegistryEvent.Register<Item> event){
        event.getRegistry().register(new BlockItem(sandbox_block, new Item.Properties().group(Sandbox.itemGroup)).setRegistryName("sandbox_block"));
    }
}
