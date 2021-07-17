package com.khorbos.sandbox.common.blocks;

import com.khorbos.sandbox.Sandbox;
import com.khorbos.sandbox.core.util.BlockProperties;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;

public class CopperOreBlock extends Block {
    public CopperOreBlock() {
        super(Block.Properties
                .create(Material.ROCK)
                .hardnessAndResistance(4.5F, 3.0F)
                .harvestLevel(1)
                .harvestTool(ToolType.PICKAXE)
                .sound(SoundType.STONE));
        this.setRegistryName("copper_ore");
    }

    public BlockItem asBlockItem(){
        return new BlockItem(this, new Item.Properties().group(Sandbox.itemGroup));
    }
}
