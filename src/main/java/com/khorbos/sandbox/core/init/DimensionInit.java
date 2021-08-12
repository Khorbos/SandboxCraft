package com.khorbos.sandbox.core.init;

import com.khorbos.sandbox.Sandbox;
import com.khorbos.sandbox.common.world.dimensions.ExampleModDimension;
import com.khorbos.sandbox.common.world.dimensions.MiningWorldModDimension;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DimensionInit {
    public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = DeferredRegister.create(ForgeRegistries.MOD_DIMENSIONS, Sandbox.ID);

    public static final RegistryObject<ModDimension> MINING_DIM = MOD_DIMENSIONS.register("mining_dim", MiningWorldModDimension::new);
    public static final RegistryObject<ModDimension> EXAMPLE_DIM = MOD_DIMENSIONS.register("example_dim", ExampleModDimension::new);
}
