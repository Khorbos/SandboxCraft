package com.khorbos.sandbox.common.world.gen;

import com.khorbos.sandbox.core.init.BlockInit;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;
import java.util.function.Function;

public class CopperBiomeSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
    public CopperBiomeSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> function) {
        super(function);
    }

    @Override
    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
                             BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        Random rd = new Random();
        int i = rd.nextInt(3);
        if (i == 0){
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed,
                    new SurfaceBuilderConfig(
                            BlockInit.COPPER_GRASS.get().getDefaultState(),
                            BlockInit.COPPER_ORE.get().getDefaultState(), Blocks.STONE.getDefaultState()));
        } else {
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed,
                    new SurfaceBuilderConfig(
                            i == 1? BlockInit.COPPER_BLOCK.get().getDefaultState(): BlockInit.COPPER_GRASS.get().getDefaultState(),
                            BlockInit.COPPER_ORE.get().getDefaultState(), Blocks.STONE.getDefaultState()));
        }
    }
}
