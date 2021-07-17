package com.khorbos.sandbox.core.init;

import com.khorbos.sandbox.Sandbox;
import com.khorbos.sandbox.common.blocks.CopperBlock;
import com.khorbos.sandbox.common.blocks.CopperOreBlock;
import com.khorbos.sandbox.common.blocks.SandboxBlock;
import com.khorbos.sandbox.common.blocks.SpecialBlock;
import com.khorbos.sandbox.common.items.tools.HammerItem;
import com.khorbos.sandbox.core.util.BlockProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SandBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Sandbox.ID)
@Mod.EventBusSubscriber(modid = Sandbox.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit {
    public static final SandboxBlock sandbox_block = new SandboxBlock();
    public static final CopperOreBlock copper_ore = new CopperOreBlock();
    public static final CopperBlock copper_block = new CopperBlock();

    public static final Block special_block = new SpecialBlock(Block.Properties.create(Material.SAND)
            .hardnessAndResistance(2F,10F)
            .harvestLevel(5)
            .harvestTool(ToolType.PICKAXE)
            .sound(SoundType.SAND)
            .lightValue(4)
            .slipperiness(1.2F)
            .speedFactor(0.7f)
            .noDrops()).setRegistryName("special_block");

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event){
        event.getRegistry().register(sandbox_block);
        event.getRegistry().register(copper_ore);
        event.getRegistry().register(copper_block);
        event.getRegistry().register(special_block);
    }

    @SubscribeEvent
    public static void registerBlocksItem(final RegistryEvent.Register<Item> event){
        event.getRegistry().register(sandbox_block.asBlockItem().setRegistryName("sandbox_block"));
        event.getRegistry().register(copper_ore.asBlockItem().setRegistryName("copper_ore"));
        event.getRegistry().register(copper_block.asBlockItem().setRegistryName("copper_block"));

        event.getRegistry().register(new BlockItem(special_block, new Item.Properties().group(Sandbox.itemGroup)).setRegistryName("special_block"));
    }
}
