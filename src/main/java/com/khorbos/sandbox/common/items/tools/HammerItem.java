package com.khorbos.sandbox.common.items.tools;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class HammerItem extends PickaxeItem {
    public HammerItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    public boolean onBlockDestroyed(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity living) {
        if(living instanceof PlayerEntity && !world.isRemote) {
            switch(determineOrientation(world, pos, living)) {
                case 0:
                    for(int x1 = -1; x1 < 2; x1++) {
                        for(int z1 = -1; z1 < 2; z1++) {
                            if(world.getBlockState(pos.add(x1, 0, z1)).getBlockHardness(world, pos) >= 0.0F) {
                                world.getBlockState(pos.add(x1, 0, z1)).canHarvestBlock(world, pos, (PlayerEntity)living);
                                world.setBlockState(pos.add(x1, 0, z1), state.getBlockState());
                            }
                        }
                    }
                    break;
                case 1:
                    for(int y1 = -1; y1 < 2; y1++) {
                        for(int z1 = -1; z1 < 2; z1++) {
                            if(world.getBlockState(pos.add(0, y1, z1)).getBlockHardness(world, pos) >= 0.0F) {
                                world.getBlockState(pos.add(0, y1, z1)).canHarvestBlock(world, pos, (PlayerEntity)living);
                                world.setBlockState(pos.add(0, y1, z1), state.getBlockState());
                            }
                        }
                    }
                    break;
                case 2:
                    for(int x1 = -1; x1 < 2; x1++){
                        for(int y1 = -1; y1 < 2; y1++){
                            if(world.getBlockState(pos.add(x1, y1,0)).getBlockHardness(world, pos) >= 0.0F){
                                world.getBlockState(pos.add(x1, y1,0)).canHarvestBlock(world, pos, (PlayerEntity)living);
                                world.setBlockState(pos.add(x1, y1,0), state.getBlockState());
                            }
                        }
                    }
                    break;
            }
        }
        return super.onBlockDestroyed(stack, world, state, pos, living);
    }

    public int determineOrientation(World world, BlockPos pos, LivingEntity living){
        if(MathHelper.abs((float)living.getPosX() - pos.getX()) < 2.0F && MathHelper.abs((float)living.getPosZ() - pos.getZ()) < 2.0F){
            double d0 = living.getPosY() + 1.82D - (double)living.getYOffset();
            if(d0 - pos.getY() > 2.0D || pos.getY() - d0 > 0.0D){
                return 0;
            }
        }
        float rotation = MathHelper.abs(living.rotationYaw);
        return (rotation > 45F && rotation < 135F) || (rotation > 225F && rotation < 315F) ? 1 : 2;
    }
}
