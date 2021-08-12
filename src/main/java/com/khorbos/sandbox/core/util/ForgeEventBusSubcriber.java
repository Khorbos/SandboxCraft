package com.khorbos.sandbox.core.util;

import com.khorbos.sandbox.Sandbox;
import com.khorbos.sandbox.core.init.DimensionInit;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Sandbox.ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventBusSubcriber {
    @SubscribeEvent
    public static void registerDimensions(final RegisterDimensionsEvent event){
        if(DimensionType.byName(Sandbox.EXAMPLE_DIM_TYPE) == null){
            DimensionManager.registerDimension(Sandbox.EXAMPLE_DIM_TYPE, DimensionInit.EXAMPLE_DIM.get(), null, true);
        } else if(DimensionType.byName(Sandbox.MINING_DIM_TYPE) == null){
            DimensionManager.registerDimension(Sandbox.MINING_DIM_TYPE, DimensionInit.MINING_DIM.get(), null, true);
        }
        Sandbox.LOGGER.debug("SandboxMod debug : Registered dimension");
    }
}
