package com.khorbos.sandbox.common.events;

import com.khorbos.sandbox.Sandbox;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.living.LivingDestroyBlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Sandbox.ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TestBreakBlockEvents {
//    @SubscribeEvent
//    public static void testBreakBlockEvent(LivingDestroyBlockEvent event){
//        Sandbox.LOGGER.info("testDigEvent fired");
//        LivingEntity livingEntity = event.getEntityLiving();
//        livingEntity.addPotionEffect(new EffectInstance(Effects.HASTE, 120, 2));
//    }
}
