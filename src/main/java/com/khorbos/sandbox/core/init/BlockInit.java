package com.khorbos.sandbox.core.init;

import com.khorbos.sandbox.Sandbox;
import com.khorbos.sandbox.common.blocks.SandboxBlock;
import com.khorbos.sandbox.core.util.BlockProperties;
import net.minecraft.block.Block;
import net.minecraft.block.SandBlock;
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
    public static final SandboxBlock sandbox_block = new SandboxBlock();

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event){
        event.getRegistry().register(sandbox_block);
    }

    @SubscribeEvent
    public static void registerBlocksItem(final RegistryEvent.Register<Item> event){
        event.getRegistry().register(sandbox_block.asBlockItem().setRegistryName("sandbox_block"));
    }
}
