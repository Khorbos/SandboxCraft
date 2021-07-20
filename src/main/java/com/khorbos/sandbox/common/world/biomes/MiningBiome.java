package com.khorbos.sandbox.common.world.biomes;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class MiningBiome extends Biome {
    public MiningBiome() {
        this(new Biome.Builder()
                .precipitation(RainType.RAIN)
                .depth(0.125F)
                .scale(0.05F)
                .temperature(0.8F)
                .downfall(0.4F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .category(Category.MUSHROOM)
                .parent(null)
                .surfaceBuilder(SurfaceBuilder.DEFAULT,
                        new SurfaceBuilderConfig(
                                Blocks.STONE.getDefaultState(),
                                Blocks.ANDESITE.getDefaultState(),
                                Blocks.OBSIDIAN.getDefaultState()
                        )
                )
        );
    }

    public MiningBiome(Builder biomeBuilder) {
        super(biomeBuilder);
        this.addCarver(GenerationStage.Carving.AIR, createCarver(WorldCarver.CANYON, new ProbabilityConfig(0.5445254F)));
        this.addCarver(GenerationStage.Carving.AIR, createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.2505254F)));
        this.addStructure(Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.08D, MineshaftStructure.Type.NORMAL)));
        DefaultBiomeFeatures.addOres(this);
        DefaultBiomeFeatures.addStoneVariants(this);
        DefaultBiomeFeatures.addMonsterRooms(this);
        DefaultBiomeFeatures.addFossils(this);
        this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PIG, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.COW, 8, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.HORSE, 5, 2, 6));
        this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.DONKEY, 1, 1, 3));
        this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
    }
}
