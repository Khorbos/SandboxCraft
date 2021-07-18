package com.khorbos.sandbox.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class CopperOreBlock extends Block {
    public CopperOreBlock() {
        super(Block.Properties
                .create(Material.ROCK)
                .hardnessAndResistance(4.5F, 3.0F)
                .harvestLevel(1)
                .harvestTool(ToolType.PICKAXE)
                .sound(SoundType.STONE));
    }
}
