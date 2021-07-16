package com.khorbos.sandbox.core.itemgroups;

import com.khorbos.sandbox.core.init.BlockInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class MainItemGroup extends ItemGroup {
    public MainItemGroup() {
        super(ItemGroup.GROUPS.length, "Sandbox Mod");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(BlockInit.sandbox_block);
    }
}
