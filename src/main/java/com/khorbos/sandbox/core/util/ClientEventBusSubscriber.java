package com.khorbos.sandbox.core.util;

import com.khorbos.sandbox.Sandbox;
import com.khorbos.sandbox.core.init.BlockInit;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Sandbox.ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent e){
        RenderTypeLookup.setRenderLayer(BlockInit.COPPER_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInit.CORN_CROP.get(), RenderType.getCutout());
    }
}
