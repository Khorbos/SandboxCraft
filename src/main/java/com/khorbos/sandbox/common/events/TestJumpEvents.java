package com.khorbos.sandbox.common.events;

import com.khorbos.sandbox.Sandbox;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Sandbox.ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TestJumpEvents {
//    @SubscribeEvent
//    public static void testJumpEvent(LivingJumpEvent event){
//        LivingEntity livingEntity = event.getEntityLiving();
//        if (livingEntity instanceof PlayerEntity) {
//            Sandbox.LOGGER.info("testJumpEvent fired");
//            livingEntity.addPotionEffect(new EffectInstance(Effects.LEVITATION, 60, 1));
//            livingEntity.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 120, 1));
//        }
//    }
}
