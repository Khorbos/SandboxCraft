package com.khorbos.sandbox.core.init;

import com.khorbos.sandbox.Sandbox;
import com.khorbos.sandbox.common.blocks.*;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Sandbox.ID);

    public static final RegistryObject<SandboxBlock> sandbox_block = BLOCKS.register("sandbox_block", () -> new SandboxBlock());
    public static final RegistryObject<CopperOreBlock> copper_ore = BLOCKS.register("copper_ore", () -> new CopperOreBlock());
    public static final RegistryObject<CopperBlock> copper_block = BLOCKS.register("copper_block", () -> new CopperBlock());
    public static final RegistryObject<SpecialBlock> special_block = BLOCKS.register("special_block", () -> new SpecialBlock());
    public static final RegistryObject<QuarryBlock> quarry = BLOCKS.register("quarry", () -> new QuarryBlock());
}
