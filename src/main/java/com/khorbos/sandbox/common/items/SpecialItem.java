package com.khorbos.sandbox.common.items;

import com.khorbos.sandbox.Sandbox;
import com.khorbos.sandbox.core.init.BlockInit;
import com.khorbos.sandbox.core.util.KeyboardHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class SpecialItem extends Item {
    public SpecialItem() {
        super(new Item.Properties().group(Sandbox.itemGroup));
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (KeyboardHelper.isHoldingShift()){
            tooltip.add(new StringTextComponent("Test infos"));
        } else {
            tooltip.add(new StringTextComponent("\u00A7e"+"Hold SHIFT for more details"));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        playerIn.addPotionEffect(new EffectInstance(Effects.STRENGTH, 500, 2));
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
        entity.getEntityWorld().setBlockState(entity.getPosition().down(), BlockInit.sandbox_block.getDefaultState());
        return super.onEntityItemUpdate(stack, entity);
    }
}
