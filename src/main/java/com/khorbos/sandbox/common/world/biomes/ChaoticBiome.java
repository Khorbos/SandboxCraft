package com.khorbos.sandbox.common.world.biomes;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.HeightWithChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ChaoticBiome extends Biome {
    public ChaoticBiome() {
        this(new Biome.Builder()
                .precipitation(RainType.NONE)
                .scale(1.0F)
                .temperature(2.0F)
                .waterColor(16724581)
                .waterFogColor(3746350)
                .category(Category.DESERT)
                .downfall(0.0F)
                .depth(0.1F)
                .parent(null)
                .surfaceBuilder(SurfaceBuilder.NETHER,
                        new SurfaceBuilderConfig(
                                Blocks.NETHERRACK.getDefaultState(),
                                Blocks.NETHER_WART_BLOCK.getDefaultState(),
                                Blocks.MAGMA_BLOCK.getDefaultState()
                        )
                )
        );
    }

    public ChaoticBiome(Builder biomeBuilder) {
        super(biomeBuilder);
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BLAZE, 25, 4, 4));
        this.addStructure(Feature.NETHER_BRIDGE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        this.addCarver(GenerationStage.Carving.AIR, createCarver(WorldCarver.HELL_CAVE, new ProbabilityConfig(0.015254F)));
        this.addCarver(GenerationStage.Carving.AIR, createCarver(WorldCarver.CANYON, new ProbabilityConfig(0.1845254F)));
        this.addCarver(GenerationStage.Carving.AIR, createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.0245254F)));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
                Feature.FOSSIL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(128))));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG).withPlacement(Placement.COUNT_CHANCE_HEIGHTMAP_DOUBLE.configure(new HeightWithChanceConfig(1, 0.125F))));

        DefaultBiomeFeatures.addOres(this);
        DefaultBiomeFeatures.addMushrooms(this);
        DefaultBiomeFeatures.addHugeMushrooms(this);
    }


}
