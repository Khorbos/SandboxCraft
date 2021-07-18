package com.khorbos.sandbox.common.blocks;

import com.khorbos.sandbox.Sandbox;
import com.khorbos.sandbox.core.util.BlockProperties;
import com.khorbos.sandbox.core.util.ModTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class QuarryBlock extends Block {
    public QuarryBlock() {
        super(BlockProperties.STONE_PROPERTIES);
        this.setRegistryName("quarry");
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    public BlockItem asBlockItem(){
        return new BlockItem(this, new Item.Properties().group(Sandbox.itemGroup));
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntityTypes.QUARRY.get().create();
    }
}
