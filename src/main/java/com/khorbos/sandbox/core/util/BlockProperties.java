package com.khorbos.sandbox.core.util;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlockProperties {
    public static final Block.Properties FURNACE_PROPERTIES = Block.Properties
            .create(Material.IRON)
            .hardnessAndResistance(5.0F)
            .harvestLevel(1)
            .harvestTool(ToolType.PICKAXE)
            .sound(SoundType.METAL)
            .lightValue(13);

    public static final Block.Properties STONE_PROPERTIES = Block.Properties
            .create(Material.ROCK)
            .sound(SoundType.STONE);
}
