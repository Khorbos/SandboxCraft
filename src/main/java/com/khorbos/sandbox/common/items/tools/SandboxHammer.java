package com.khorbos.sandbox.common.items.tools;

import com.khorbos.sandbox.Sandbox;
import com.khorbos.sandbox.core.util.enums.ModItemTier;
import net.minecraft.item.Item;

public class SandboxHammer extends HammerItem{
    public SandboxHammer() {
        super(ModItemTier.EMERALD, 2, 2.0F, new Item.Properties().group(Sandbox.itemGroup));
    }
}
