package com.khorbos.sandbox.common.tiles;

import com.khorbos.sandbox.core.util.ModTileEntityTypes;
import com.khorbos.sandbox.core.util.helpers.NBTHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;

// L'interface ITickableTileEntity n'est utile que si l'on souhaite spécifier un fonctionnement pendant les ticks.
public class QuarryTileEntity extends TileEntity implements ITickableTileEntity {
    public int posX, posY, posZ, tick;
    boolean isInitialized = false;

    public QuarryTileEntity(final TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public QuarryTileEntity() {
        this(ModTileEntityTypes.QUARRY.get());
    }

    @Override
    public void tick() {
        if (!isInitialized){
            this.init();
        }
        tick++;
        if (tick == 40){
            tick = 0;
            if (posY > 2){
                this.execute();
            }
        }
    }

    private void init() {
        isInitialized = true;
        this.posX = this.pos.getX() - 1;
        this.posY = this.pos.getY() - 1;
        this.posZ = this.pos.getZ() - 1;
        tick = 0;
    }

    private void execute() {
        int idx = 0;
        Block[] blocksRemoved = new Block[16];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                BlockPos blockPosToBreak = new BlockPos(this.posX + i, this.posY, this.posZ + j);
                blocksRemoved[idx] = this.world.getBlockState(blockPosToBreak).getBlock();
                this.breakBlock(blockPosToBreak, true, null);
                idx++;
            }
        }
        this.posY--;
    }

    private boolean breakBlock(BlockPos pos, boolean dropBlock, Entity entity) {
        BlockState state = this.world.getBlockState(pos);
        if (state.isAir(this.world, pos)){
            return false;
        } else {
            IFluidState iFluidState = this.world.getFluidState(pos);
            this.world.playEvent(2001, pos, Block.getStateId(state));
            if (dropBlock){
                TileEntity te = state.hasTileEntity()? this.world.getTileEntity(pos) : null;
                Block.spawnDrops(state, this.world, this.pos.add(0, 1.5, 0), te, entity, ItemStack.EMPTY);
            }
            return this.world.setBlockState(pos, iFluidState.getBlockState(), 3);
        }
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("initvalues", NBTHelper.toNBT(this));
        return super.write(compound);
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        CompoundNBT initvalues= compound.getCompound("initvalues");
        if (initvalues != null){
            this.posX = initvalues.getInt("x");
            this.posY = initvalues.getInt("y");
            this.posZ = initvalues.getInt("z");
            this.tick = 0;
            this.isInitialized = true;
            return;
        }
        this.init();
    }
}
