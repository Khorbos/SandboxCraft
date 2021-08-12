package com.khorbos.sandbox.core.init;

import com.khorbos.sandbox.Sandbox;
import com.khorbos.sandbox.common.blocks.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Sandbox.ID);

    public static final RegistryObject<SandboxBlock> SANDBOX_BLOCK = BLOCKS.register("sandbox_block", () -> new SandboxBlock());
    public static final RegistryObject<CopperOreBlock> COPPER_ORE = BLOCKS.register("copper_ore", () -> new CopperOreBlock());
    public static final RegistryObject<CopperBlock> COPPER_BLOCK = BLOCKS.register("copper_block", () -> new CopperBlock());
    public static final RegistryObject<SpecialBlock> SPECIAL_BLOCK = BLOCKS.register("special_block", () -> new SpecialBlock());
    public static final RegistryObject<QuarryBlock> QUARRY = BLOCKS.register("quarry", () -> new QuarryBlock());

    public static final RegistryObject<Block> COPPER_STAIRS = BLOCKS.register("copper_stairs",
            () -> new StairsBlock(
                    () -> BlockInit.COPPER_BLOCK.get().getDefaultState(),
                    Block.Properties.create(Material.IRON)));

    public static final RegistryObject<SlabBlock> COPPER_SLAB = BLOCKS.register("copper_slab",
            () -> new SlabBlock(Block.Properties.from(COPPER_BLOCK.get())));

    public static final RegistryObject<Block> COPPER_FENCE = BLOCKS.register("copper_fence",
            () -> new FenceBlock(Block.Properties.from(COPPER_BLOCK.get())));

    public static final RegistryObject<WallBlock> COPPER_WALL = BLOCKS.register("copper_wall",
            () -> new WallBlock(Block.Properties.from(COPPER_BLOCK.get())));

    public static final RegistryObject<Block> COPPER_BUTTON = BLOCKS.register("copper_button",
            () -> new CopperButtonBlock(Block.Properties.from(COPPER_BLOCK.get())));

    public static final RegistryObject<Block> COPPER_PRESSURE_PLATE = BLOCKS.register("copper_pressure_plate",
            () -> new CopperPressurePlate(Block.Properties.from(COPPER_BLOCK.get())));

    public static final RegistryObject<Block> CORN_CROP = BLOCKS.register("corn_crop",
            () -> new CornCrop(Block.Properties.from(Blocks.WHEAT)));
}
