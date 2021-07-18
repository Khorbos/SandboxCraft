package com.khorbos.sandbox.common.blocks;

import com.khorbos.sandbox.Sandbox;
import com.khorbos.sandbox.core.util.BlockProperties;
import com.khorbos.sandbox.core.init.TileEntityTypesInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class QuarryBlock extends Block {
    public QuarryBlock() {
        super(BlockProperties.STONE_PROPERTIES);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return TileEntityTypesInit.QUARRY.get().create();
    }
}
