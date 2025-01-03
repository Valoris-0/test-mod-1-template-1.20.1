package net.valoris.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.valoris.tutorialmod.TutorialMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.valoris.tutorialmod.block.ModBlocks;

public class ModItemGroups {
    // Define the first item group
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TutorialMod.MOD_ID, "ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
                    .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {

                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.RAW_RUBY);

                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RAW_RUBY_BLOCK);

                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                        entries.add(ModBlocks.NETHER_RUBY_ORE);
                        entries.add(ModBlocks.END_STONE_RUBY_ORE);

                        entries.add(ModItems.RAW_DIAMOND);
                        entries.add(Items.DIAMOND);

                        entries.add(ModItems.TOMATO);

                        entries.add(ModItems.COAL_BRIQUETTE);

                        entries.add(ModBlocks.SOUND_BLOCK);

                    }).build());

    // Define the second item group
    public static final ItemGroup CUSTOM_LOGS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TutorialMod.MOD_ID, "logs"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.logs"))
                    .icon(() -> new ItemStack(ModBlocks.FROZEN_OAK_LOG)).entries((displayContext, entries) -> {

                        entries.add(ModBlocks.FROZEN_OAK_LOG);

                    }).build());

    public static final ItemGroup ORE_DETECTORS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TutorialMod.MOD_ID, "detectors"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.detectors"))
                    .icon(() -> new ItemStack(ModItems.METAL_DETECTOR)).entries((displayContext, entries) -> {

                        entries.add(ModItems.COAL_DETECTOR);
                        entries.add(ModItems.EMERALD_DETECTOR);
                        entries.add(ModItems.LAPIS_DETECTOR);
                        entries.add(ModItems.DIAMOND_DETECTOR);
                        entries.add(ModItems.NETHERITE_DETECTOR);
                        entries.add(ModItems.QUARTZ_DETECTOR);
                        entries.add(ModItems.METAL_DETECTOR);
                        entries.add(ModItems.COPPER_DETECTOR);
                        entries.add(ModItems.NETHER_DETECTOR);
                        entries.add(ModItems.GOLD_DETECTOR);
                        entries.add(ModItems.REDSTONE_DETECTOR);

                        entries.add(ModItems.ULTIMATE_DETECTOR);

                    }).build());

    // Method to initialize item groups
    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }
}