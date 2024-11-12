package com.example.examplemod;

import com.example.examplemod.mc_01_myblock.BlockMyBlock;
import com.example.examplemod.mc_02_fortuneblock.BlockFortune;
import com.example.examplemod.mc_03_magicstick.ItemMagicStick;
import com.example.examplemod.mc_04_hipotion.ItemHiPotion;
import com.example.examplemod.mc_05_mysword.ItemMySword;
import com.example.examplemod.mc_06_rainbowblock.BlockRainbow;
import com.example.examplemod.mc_07_soundblock.BlockSound;
import com.example.examplemod.mc_08_woodcut.BlockBreakEventHandler;
import com.example.examplemod.mc_09_redstone.BlockRedstoneClock;
import com.example.examplemod.mc_09_redstone.BlockRedstoneInput;
import com.example.examplemod.mc_09_redstone.BlockSensor;
import com.example.examplemod.mc_102_flower.*;
import com.example.examplemod.mc_102_flower.ItemOpenUmbrella;
import com.example.examplemod.mc_102_flower.ItemUmbrella;
import com.example.examplemod.mc_103_custom_eventhandler.EnderEventHandle;
import com.example.examplemod.mc_105_potion.ItemZombiePotion;
import com.example.examplemod.mc_105_potion.PotionZombie;
import com.example.examplemod.mc_106_custom_fluid.CustomFluid;
import com.example.examplemod.mc_10_snowball_fight.EntityMyCustomSnowball;
import com.example.examplemod.mc_10_snowball_fight.EntityMySnowball;
import com.example.examplemod.mc_10_snowball_fight.ItemMyCustomSnowball;
import com.example.examplemod.mc_10_snowball_fight.ItemMySnowball;
import com.example.examplemod.mc_11_footprints_sand.BlockFootprintsSand;
import com.example.examplemod.mc_12_biome.BiomeMyBiome;
import com.example.examplemod.mc_12_biome.MyBiomeProvider;
import com.example.examplemod.mc_13_explosive_arrow.EntityExplosiveArrow;
import com.example.examplemod.mc_13_explosive_arrow.ItemExplosiveArrow;
import com.example.examplemod.mc_13_explosive_arrow.RenderExplosiveArrow;
import com.example.examplemod.mc_14_bull_fighting.EntityBull;
import com.example.examplemod.mc_14_bull_fighting.RenderBull;
import com.example.examplemod.mc_15_tobisuke.*;
import com.example.examplemod.mc_16_buildingblock.BlockBuilding;
import com.example.examplemod.mc_103_custom_eventhandler.MyPickaxeJudgeHandler;
import com.example.examplemod.mc_100_tools.*;
import com.example.examplemod.mc_101_different_color.*;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.*;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import terrablender.api.BiomeProviders;

import static net.minecraft.world.item.Items.BUCKET;

@Mod("examplemod")
public class ExampleMod {

    //MODID
    public static final String MODID = "examplemod";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public static CreativeModeTab ORIGINAL_TAB = new OriginalTab();

    public static final MobEffect POTION_ZOMBIE = new PotionZombie();

    public static final Item ITEM_ZOMBIE_POTION =
            new ItemZombiePotion().setRegistryName(MODID, "zombie_potion");

    // Block
    public static final Block BLOCK_MYBLOCK =
            new BlockMyBlock().setRegistryName(MODID, "block_myblock");

    public static final Block BLOCK_FORTUNE =
            new BlockFortune().setRegistryName(MODID, "block_fortune");

    public static final Block BLOCK_RAINBOW =
            new BlockRainbow().setRegistryName(MODID, "block_rainbow");

    public static final Block BLOCK_SOUND =
            new BlockSound().setRegistryName(MODID, "block_sound");

    public static final Block BLOCK_REDSTONE_INPUT =
            new BlockRedstoneInput().setRegistryName(MODID, "block_redstone_input");

    public static final Block BLOCK_REDSTONE_CLOCK =
            new BlockRedstoneClock().setRegistryName(MODID, "block_redstone_clock");

    public static final Block BLOCK_FOOTPRINTS_SAND =
            new BlockFootprintsSand().setRegistryName(MODID, "block_footprints_sand");

    public static final Block BLOCK_BUILDING =
            new BlockBuilding().setRegistryName(MODID, "block_building_block");

    public static final Block BLOCK_DIA_DETECTION =
            new BlockDiaDetection().setRegistryName(MODID, "block_dia_detection");

    public static final Block HYDRANGEA =
            new Hydrangea().setRegistryName(MODID, "hydrangea");

    public static final Block HIGH_HYDRANGEA =
            new HighHydrangea().setRegistryName(MODID, "high_hydrangea");

    public static final Block BLOCK_SENSOR =
            new BlockSensor().setRegistryName(MODID, "block_sensor");

    // Entity
    public static final EntityType<EntityMySnowball> ENTITY_MY_SNOWBALL =
            EntityType.Builder.<EntityMySnowball>of(EntityMySnowball::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .setShouldReceiveVelocityUpdates(true)
                    .build("my_snowball");

    public static final EntityType<EntityMyCustomSnowball> ENTITY_MY_CUSTOM_SNOWBALL =
            EntityType.Builder.<EntityMyCustomSnowball>of(EntityMyCustomSnowball::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .setShouldReceiveVelocityUpdates(true)
                    .build("my_custom_snowball");

    public static final EntityType<EntityExplosiveArrow> ENTITY_EXPLOSIVE_ARROW =
            EntityType.Builder.<EntityExplosiveArrow>of(EntityExplosiveArrow::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .setShouldReceiveVelocityUpdates(true)
                    .build("explosive_arrow");

    public static final EntityType<EntityBull> ENTITY_BULL =
            EntityType.Builder.of(EntityBull::new, MobCategory.CREATURE)
                    .sized(0.9f, 1.4f)
                    .setTrackingRange(32)
                    .setShouldReceiveVelocityUpdates(true)
                    .build("bull");

    public static final EntityType<EntityTobisuke> ENTITY_TOBISUKE =
            EntityType.Builder.of(EntityTobisuke::new, MobCategory.CREATURE)
                    .sized(0.9f, 0.9f)
                    .setTrackingRange(32)
                    .setUpdateInterval(1)
                    .setShouldReceiveVelocityUpdates(true)
                    .build("tobisuke");

    public static final EntityType<EntityTobisuke2> ENTITY_TOBISUKE_ORIGINAL =
            EntityType.Builder.of(EntityTobisuke2::new, MobCategory.CREATURE)
                    .sized(0.9f, 0.9f)
                    .setTrackingRange(32)
                    .setUpdateInterval(1)
                    .setShouldReceiveVelocityUpdates(true)
                    .build("tobisuke_original");

    public static final EntityType<EntityTobisuke2> ENTITY_TOBISUKE_WING =
            EntityType.Builder.of(EntityTobisuke2::new, MobCategory.CREATURE)
                    .sized(0.9f, 0.9f)
                    .setTrackingRange(32)
                    .setUpdateInterval(1)
                    .setShouldReceiveVelocityUpdates(true)
                    .build("tobisuke_wing");

    public static final EntityType<EntityAxolotl> ENTITY_AXOLOTLDIF =
            EntityType.Builder.of(EntityAxolotl::new, MobCategory.CREATURE)
                    .setShouldReceiveVelocityUpdates(true)
                    .build("axolotl_dif");

    public static final EntityType<EntityMyFireball> ENTITY_MY_FIREBALL =
            EntityType.Builder.<EntityMyFireball>of(EntityMyFireball::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .setShouldReceiveVelocityUpdates(true)
                    .build("my_fireball");

    public static final EntityType<EntityOriginalSkeleton> ENTITY_ORIGINAL_SKELETON =
            EntityType.Builder.of(EntityOriginalSkeleton::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .build("original_skeleton");

    public static final EntityType<EntityOriginalWitherSkeleton> ENTITY_ORIGINAL_WITHER_SKELETON =
            EntityType.Builder.of(EntityOriginalWitherSkeleton::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .fireImmune()
                    .immuneTo(Blocks.WITHER_ROSE)
                    .build("original_wither_skeleton");

    public static final EntityType<EntityOriginalCat> ENTITY_ORIGINAL_CAT =
            EntityType.Builder.of(EntityOriginalCat::new, MobCategory.CREATURE)
                    .setShouldReceiveVelocityUpdates(true)
                    .build("original_cat");

    public static final EntityType<EntityOriginalCreeper> ENTITY_ORIGINAL_CREEPER =
            EntityType.Builder.of(EntityOriginalCreeper::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .build("original_creeper");

    public static final EntityType<FireworkRocketEntity> FIREWORK_ROCKET =
            EntityType.Builder.<FireworkRocketEntity>of(FireworkRocketEntity::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F)
                    .clientTrackingRange(4)
                    .updateInterval(10)
                    .build("firework_rocket");

    public static final EntityType<MyAnimalEntity> MY_ANIMAL =
            EntityType.Builder
                    .of(MyAnimalEntity::new, MobCategory.CREATURE)
                    .sized(0.9f, 0.9f)
                    .setTrackingRange(32)
                    .setUpdateInterval(1)
                    .setShouldReceiveVelocityUpdates(true) // 速度の更新を受け取るか
                    .build("my_animal");

    public static final EntityType<EntityGhost> ENTITY_GHOST =
            EntityType.Builder.of(EntityGhost::new, MobCategory.MONSTER)
                    .sized(0.9f, 0.9f)
                    .setTrackingRange(32)
                    .setUpdateInterval(1)
                    .setShouldReceiveVelocityUpdates(true)
                    .build("ghost");

    // Item
    public static final Item ITEM_MAGIC_STICK =
            new ItemMagicStick().setRegistryName(MODID, "magic_stick");

    public static final Item ITEM_HI_POTION =
            new ItemHiPotion().setRegistryName(MODID, "hi_potion");

    public static final Item ITEM_MY_SWORD =
            new ItemMySword().setRegistryName(MODID, "my_sword");

    public static final Item ITEM_MY_SNOWBALL =
            new ItemMySnowball().setRegistryName(MODID, "my_snowball");

    public static final Item ITEM_MY_CUSTOM_SNOWBALL =
            new ItemMyCustomSnowball().setRegistryName(MODID, "my_custom_snowball");

    public static final Item ITEM_EXPLOSIVE_ARROW =
            new ItemExplosiveArrow().setRegistryName(MODID, "explosive_arrow");

    public static final Item ITEM_UMBRELLA =
            new ItemUmbrella().setRegistryName(MODID, "umbrella");

    public static final Item ITEM_OPEN_UMBRELLA =
            new ItemOpenUmbrella().setRegistryName(MODID, "open_umbrella");

    public static final Item ITEM_PICKAXE =
            new MyPickaxeJudgeHandler().setRegistryName(MODID, "pickaxe");

    public static final Item BULL_SPAWN_EGG =
            new SpawnEggItem(ENTITY_BULL,
                    0x00FF00,
                    0x0000FF,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)
            ).setRegistryName(MODID, "bull_spawn_egg");

    public static final Item TOBISUKE_SPAWN_EGG =
            new SpawnEggItem(ENTITY_TOBISUKE,
                    0xFF0000,
                    0x00FF00,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)
            ).setRegistryName(MODID, "tobisuke_spawn_egg");

    public static final Item TOBISUKE_RANDOM_SPAWN_EGG =
            new SpawnEggItem(ENTITY_TOBISUKE_WING,
                    0xFFB6C1,
                    0xFFFACD,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)
            ).setRegistryName(MODID, "tobisuke_spawn_egg2");

    public static final Item AXOLOTLDIF_SPAWN_EGG =
            new SpawnEggItem(ENTITY_AXOLOTLDIF,
                    0xF0F8FF,
                    0xFF8C00,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)
            ).setRegistryName(MODID, "axolotldif_spawn_egg");

    public static final Item ORIGINAL_SKELETON_SPAWN_EGG =
            new SpawnEggItem(ENTITY_ORIGINAL_SKELETON,
                    0xFFFFFF,
                    0xF067A6,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)
            ).setRegistryName(MODID, "original_skeleton_spawn_egg");

    public static final Item ORIGINAL_WITHER_SKELETON_SPAWN_EGG =
            new SpawnEggItem(ENTITY_ORIGINAL_WITHER_SKELETON,
                    0x000000,
                    0xF067A6,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)
            ).setRegistryName(MODID, "original_wither_skeleton_spawn_egg");

    public static final Item ORIGINAL_CAT_SPAWN_EGG =
            new SpawnEggItem(ENTITY_ORIGINAL_CAT,
                    0xAAAAAA,
                    0xA9CEEC,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)
            ).setRegistryName(MODID, "original_cat_spawn_egg");

    public static final Item ORIGINAL_CREEPER_SPAWN_EGG =
            new SpawnEggItem(ENTITY_ORIGINAL_CREEPER,
                    0x000000,
                    0xA260BF,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)
            ).setRegistryName(MODID, "original_creeper_spawn_egg");

    public static final Item GHOST_SPAWN_EGG =
            new SpawnEggItem(ENTITY_GHOST,
                    0xFFFFFF,
                    0x000000,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)
            ).setRegistryName(MODID, "ghost_spawn_egg");

    public static final Item ITEM_MY_FIREBALL =
            new ItemMyFireball().setRegistryName(MODID, "my_fireball");

    public static final Item ITEM_MONSTER_BALL =
            new ItemMonsterBall().setRegistryName(MODID, "monster_ball");

    public static final Item ITEM_MY_PICKAXE =
            new MyPickaxeItem().setRegistryName(MODID, "my_pickaxe");

    public static final Item ITEM_MY_AXE =
            new MyAxeItem().setRegistryName(MODID, "my_axe");

    public static final Item ITEM_MY_SHOVEL =
            new MyShovelItem().setRegistryName(MODID, "my_shovel");

    public static final Item ITEM_MY_HOE =
            new MyHoeItem().setRegistryName(MODID, "my_hoe");

    public static final Item MY_ANIMAL_SPAWN_EGG =
            new SpawnEggItem(MY_ANIMAL,
                    0xff0000,
                    0x00FF00,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)
            ).setRegistryName(MODID, "my_animal_spawn_egg");

    public static final ResourceKey<Biome> MY_BIOME =
            ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ExampleMod.MODID, "my_biome"));

    public static final Fluid FLOWING_CUSTOM_FLUID =
            new CustomFluid.Flowing().setRegistryName("flowing_custom_fluid");

    public static final Fluid CUSTOM_FLUID =
            new CustomFluid.Source().setRegistryName("custom_fluid");

    public static final Item CUSTOM_FLUID_BUCKET =
            new BucketItem(ExampleMod.CUSTOM_FLUID, (new Item.Properties()).craftRemainder(BUCKET).stacksTo(1).tab(CreativeModeTab.TAB_MISC)).setRegistryName("custom_fluid_bucket");

//    public static final Block BLOCK_CUSTOM_FLUID =
//            new LiquidBlock(ExampleMod.CUSTOM_FLUID, BlockBehaviour.Properties.of(Material.LAVA).noCollission()).setRegistryName("block_custom_fluid");
//
//    public static final Block BLOCK_CUSTOM_FLUID =
//            new LiquidBlock((FlowingFluid) ExampleMod.CUSTOM_FLUID, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noDrops());


    public ExampleMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new BlockBreakEventHandler());
        MinecraftForge.EVENT_BUS.register(new EnderEventHandle());

    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            BiomeProviders.register(new MyBiomeProvider(new ResourceLocation(MODID, "biome_provider"), 50));
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(HYDRANGEA, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HIGH_HYDRANGEA, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BLOCK_FORTUNE, RenderType.cutout());
        EntityRenderers.register(ENTITY_MY_SNOWBALL, ThrownItemRenderer::new);
        EntityRenderers.register(ENTITY_EXPLOSIVE_ARROW, RenderExplosiveArrow::new);
        EntityRenderers.register(ENTITY_BULL, RenderBull::new);
        EntityRenderers.register(ENTITY_TOBISUKE, RenderTobisuke::new);
        EntityRenderers.register(ENTITY_TOBISUKE_ORIGINAL, TobisukeRenderer::new);
        EntityRenderers.register(ENTITY_TOBISUKE_WING, TobisukeRenderer::new);
        EntityRenderers.register(ENTITY_MY_FIREBALL, ThrownItemRenderer::new);
        EntityRenderers.register(ENTITY_AXOLOTLDIF, RenderAxolotlDif::new);
        EntityRenderers.register(ENTITY_ORIGINAL_SKELETON, RenderOriginalSkeleton::new);
        EntityRenderers.register(ENTITY_ORIGINAL_WITHER_SKELETON, RenderOriginalWitherSkeleton::new);
        EntityRenderers.register(ENTITY_ORIGINAL_CAT, RenderOriginalCat::new);
        EntityRenderers.register(ENTITY_ORIGINAL_CREEPER, RenderOriginalCreeper::new);
        EntityRenderers.register(MY_ANIMAL, MyAnimalRender::new);
        EntityRenderers.register(ENTITY_MY_CUSTOM_SNOWBALL, ThrownItemRenderer::new);
        EntityRenderers.register(ENTITY_GHOST, RenderGhost::new);
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        private static final RegisterBlockData[] registerBlocks = {
                // ここにBlockを書いてね！
                new RegisterBlockData(BLOCK_MYBLOCK),
                new RegisterBlockData(BLOCK_FORTUNE),
                new RegisterBlockData(BLOCK_SOUND),
                new RegisterBlockData(BLOCK_REDSTONE_INPUT),
                new RegisterBlockData(BLOCK_REDSTONE_CLOCK),
                new RegisterBlockData(BLOCK_FOOTPRINTS_SAND),
                new RegisterBlockData(BLOCK_BUILDING),
                new RegisterBlockData(BLOCK_DIA_DETECTION),
                new RegisterBlockData(HYDRANGEA),
                new RegisterBlockData(HIGH_HYDRANGEA),
                new RegisterBlockData(BLOCK_SENSOR),
//                new RegisterBlockData(BLOCK_CUSTOM_FLUID),
        };

        private static final RegisterFireResistantBlockData[] registerFireResistantBlocks = {
                new RegisterFireResistantBlockData(BLOCK_RAINBOW, CreativeModeTab.TAB_BUILDING_BLOCKS)
        };

        private static final Item[] registerItems = {
                // ここにItemを書いてね！
                ITEM_MAGIC_STICK,
                ITEM_HI_POTION,
                ITEM_MY_SWORD,
                ITEM_MY_SNOWBALL,
                ITEM_MY_CUSTOM_SNOWBALL,
                ITEM_EXPLOSIVE_ARROW,
                BULL_SPAWN_EGG,
                TOBISUKE_SPAWN_EGG,
                TOBISUKE_RANDOM_SPAWN_EGG,
                ITEM_MY_FIREBALL,
                AXOLOTLDIF_SPAWN_EGG,
                ITEM_MONSTER_BALL,
                ORIGINAL_SKELETON_SPAWN_EGG,
                ORIGINAL_WITHER_SKELETON_SPAWN_EGG,
                ORIGINAL_CAT_SPAWN_EGG,
                ORIGINAL_CREEPER_SPAWN_EGG,
                ITEM_UMBRELLA,
                ITEM_OPEN_UMBRELLA,
                ITEM_MY_PICKAXE,
                ITEM_MY_AXE,
                ITEM_MY_SHOVEL,
                ITEM_MY_HOE,
                ITEM_PICKAXE,
                MY_ANIMAL_SPAWN_EGG,
                CUSTOM_FLUID_BUCKET,
                ITEM_ZOMBIE_POTION,
                GHOST_SPAWN_EGG
        };

        private static final Fluid[] registerFluids = {
                FLOWING_CUSTOM_FLUID,
                CUSTOM_FLUID
        };

        @SubscribeEvent
        public static void registerBiomes(RegistryEvent.Register<Biome> event) {
            IForgeRegistry<Biome> registry = event.getRegistry();
            registry.register(BiomeMyBiome.makeMyBiome().setRegistryName(MY_BIOME.location()));
        }

        @SubscribeEvent
        public static void onAttributeCreation(final EntityAttributeCreationEvent event) {
            event.put(ENTITY_BULL, EntityBull.registerAttributes().build());
            event.put(ENTITY_TOBISUKE, EntityTobisuke.registerAttributes().build());
            event.put(ENTITY_TOBISUKE_ORIGINAL, EntityTobisuke2.registerAttributes().build());
            event.put(ENTITY_TOBISUKE_WING, EntityTobisuke2.registerAttributes().build());
            event.put(ENTITY_AXOLOTLDIF, EntityAxolotl.registerAttributes().build());
            event.put(ENTITY_ORIGINAL_SKELETON, EntityOriginalSkeleton.registerAttributes().build());
            event.put(ENTITY_ORIGINAL_WITHER_SKELETON, EntityOriginalWitherSkeleton.registerAttributes().build());
            event.put(ENTITY_ORIGINAL_CAT, EntityOriginalCat.registerAttributes().build());
            event.put(ENTITY_ORIGINAL_CREEPER, EntityOriginalCreeper.registerAttributes().build());
            event.put(MY_ANIMAL, MyAnimalEntity.registerAttributes().build());
            event.put(ENTITY_GHOST, EntityGhost.registerAttributes().build());
        }

        @SubscribeEvent
        public static void onEntitiesRegistry(final RegistryEvent.Register<EntityType<?>> event) {
            event.getRegistry().register(ENTITY_MY_SNOWBALL.setRegistryName(MODID, "my_snowball"));
            event.getRegistry().register(ENTITY_EXPLOSIVE_ARROW.setRegistryName(MODID, "explosive_arrow"));
            event.getRegistry().register(ENTITY_BULL.setRegistryName(MODID, "bull"));
            event.getRegistry().register(ENTITY_TOBISUKE.setRegistryName(MODID, "tobisuke"));
            ForgeHooksClient.registerLayerDefinition(RenderTobisuke.modelLayerLocation, ModelTobisukeTest::createLayer);
            event.getRegistry().register(ENTITY_TOBISUKE_ORIGINAL.setRegistryName(MODID, "tobisuke_original"));
            ForgeHooksClient.registerLayerDefinition(TobisukeRenderer.modelLayerLocation1, ModelOriginalTobisuke::createLayer);
            event.getRegistry().register(ENTITY_TOBISUKE_WING.setRegistryName(MODID, "tobisuke_wing"));
            ForgeHooksClient.registerLayerDefinition(TobisukeRenderer.modelLayerLocation2, ModelTobisukeWing::createLayer);
            event.getRegistry().register(ENTITY_AXOLOTLDIF.setRegistryName(MODID, "axolotl_dif"));
            event.getRegistry().register(ENTITY_ORIGINAL_SKELETON.setRegistryName(MODID, "original_skeleton"));
            event.getRegistry().register(ENTITY_ORIGINAL_WITHER_SKELETON.setRegistryName(MODID, "original_wither_skeleton"));
            event.getRegistry().register(ENTITY_ORIGINAL_CAT.setRegistryName(MODID, "original_cat"));
            event.getRegistry().register(ENTITY_ORIGINAL_CREEPER.setRegistryName(MODID, "original_creeper"));
            event.getRegistry().register(MY_ANIMAL.setRegistryName(MODID, "my_animal"));
            ForgeHooksClient.registerLayerDefinition(MyAnimalRender.modelLayerLocation, MyAnimalModel::createLayer);
            event.getRegistry().register(ENTITY_GHOST.setRegistryName(MODID, "ghost"));
            ForgeHooksClient.registerLayerDefinition(RenderGhost.modelLayerLocation, ModelGhost::createLayer);
        }

        // ======================================================================================================
        // ここから下はいじらないよ！

        private static void setupBiome(Biome biome, int weight, BiomeManager.BiomeType biomeType, BiomeDictionary.Type... types) {
            ResourceKey<Biome> key = ResourceKey.create(ForgeRegistries.Keys.BIOMES, ForgeRegistries.BIOMES.getKey(biome));

            BiomeDictionary.addTypes(key, types);
            BiomeManager.addBiome(biomeType, new BiomeManager.BiomeEntry(key, weight));
        }

        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            LOGGER.info("HELLO from Register Block");
            for (RegisterBlockData data : registerBlocks) {
                event.getRegistry().register(data.block);
            }

            for (RegisterFireResistantBlockData data : registerFireResistantBlocks) {
                event.getRegistry().register(data.block);
            }
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            for (RegisterBlockData data : registerBlocks) {
                event.getRegistry().register(new BlockItem(data.block, new Item.Properties().tab(data.creativeModeTab)).setRegistryName(data.block.getRegistryName()));
            }

            for (RegisterFireResistantBlockData data : registerFireResistantBlocks) {
                event.getRegistry().register(new BlockItem(data.block, new Item.Properties().tab(data.creativeModeTab).fireResistant()).setRegistryName(data.block.getRegistryName()));
            }

            for (Item item : registerItems) {
                event.getRegistry().register(item);
            }
        }

        @SubscribeEvent
        public static void onFluidsRegistry(final RegistryEvent.Register<Fluid> event) {
            for (Fluid fluid : registerFluids) {
                for (FluidState fluidstate : fluid.getStateDefinition().getPossibleStates()) {
                    Fluid.FLUID_STATE_REGISTRY.add(fluidstate);
                }
            }
        }

        static class RegisterBlockData {
            Block block;
            CreativeModeTab creativeModeTab;

            public RegisterBlockData(Block block) {
                this.block = block;
                creativeModeTab = CreativeModeTab.TAB_BUILDING_BLOCKS;
            }

            public RegisterBlockData(Block block, CreativeModeTab creativeModeTab) {
                this.block = block;
                this.creativeModeTab = creativeModeTab;
            }
        }

        static class RegisterFireResistantBlockData {
            Block block;
            CreativeModeTab creativeModeTab;

            public RegisterFireResistantBlockData(Block block, CreativeModeTab creativeModeTab) {
                this.block = block;
                this.creativeModeTab = creativeModeTab;
            }
        }
    }
}
