package com.khorbos.sandbox;

import com.khorbos.sandbox.common.world.gen.SandboxOreGen;
import com.khorbos.sandbox.core.init.BiomeInit;
import com.khorbos.sandbox.core.init.BlockInit;
import com.khorbos.sandbox.core.init.ItemInit;
import com.khorbos.sandbox.core.itemgroups.MainItemGroup;
import com.khorbos.sandbox.core.init.TileEntityTypesInit;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Sandbox.ID)
@Mod.EventBusSubscriber(modid = Sandbox.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Sandbox
{
    public static final String ID = "sandbox";
    public static final MainItemGroup itemGroup = new MainItemGroup();
    public static Sandbox instance;
    public static final Logger LOGGER = LogManager.getLogger();

    public Sandbox() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        TileEntityTypesInit.TILE_ENTITY_TYPES.register(modEventBus);
        BiomeInit.BIOMES.register(modEventBus);

        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event){
        final IForgeRegistry<Item> registry = event.getRegistry();
        BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            final Item.Properties properties = new Item.Properties().group(Sandbox.itemGroup);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });

        LOGGER.debug("SandboxMod debug : Registered BlockItems");
    }

    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event){
        LOGGER.debug("SandboxMod debug : Registered biomes");
        BiomeInit.registerBiomes();
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    private void doClientStuff(final FMLClientSetupEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {

    }

    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event){
        SandboxOreGen.generateOre();
    }
}
