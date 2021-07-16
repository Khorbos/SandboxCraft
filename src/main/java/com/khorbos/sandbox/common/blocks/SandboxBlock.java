package com.khorbos.sandbox.common.blocks;

import com.khorbos.sandbox.Sandbox;
import com.khorbos.sandbox.core.util.BlockProperties;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class SandboxBlock extends Block {
    public SandboxBlock() {
        super(BlockProperties.FURNACE_PROPERTIES);
        this.setRegistryName("sandbox_block");
    }

    public BlockItem asBlockItem(){
        return new BlockItem(this, new Item.Properties().group(Sandbox.itemGroup));
    }
}
