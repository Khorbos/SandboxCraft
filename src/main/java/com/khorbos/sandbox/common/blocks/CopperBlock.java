package com.khorbos.sandbox.common.blocks;

import com.khorbos.sandbox.Sandbox;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;

public class CopperBlock extends Block {
    public CopperBlock() {
        super(Block.Properties
                .create(Material.IRON)
                .hardnessAndResistance(4.5F, 3.0F)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
                .sound(SoundType.METAL));
        this.setRegistryName("copper_block");
    }

    public BlockItem asBlockItem(){
        return new BlockItem(this, new Item.Properties().group(Sandbox.itemGroup));
    }
}
