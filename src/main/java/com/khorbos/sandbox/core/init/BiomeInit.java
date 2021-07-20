package com.khorbos.sandbox.core.init;

import com.electronwill.nightconfig.core.ConfigSpec;
import com.khorbos.sandbox.Sandbox;
import com.khorbos.sandbox.common.world.biomes.ChaoticBiome;
import com.khorbos.sandbox.common.world.biomes.MiningBiome;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Sandbox.ID);

    public static final RegistryObject<Biome> CHAOTIC_BIOME = BIOMES.register("chaotic_biome", ChaoticBiome::new);
    public static final RegistryObject<Biome> MINING_BIOME = BIOMES.register("mining_biome", MiningBiome::new);

    public static void registerBiomes(){
        registerBiome(CHAOTIC_BIOME.get(), BiomeDictionary.Type.OVERWORLD);
        registerBiome(MINING_BIOME.get(), BiomeDictionary.Type.PLAINS);
    }

    private static void registerBiome(Biome biome, BiomeDictionary.Type... types){
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }

}
