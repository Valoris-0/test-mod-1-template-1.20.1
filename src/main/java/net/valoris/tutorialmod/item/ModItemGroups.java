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

                        entries.add(ModItems.RAW_DIAMOND);
                        entries.add(Items.DIAMOND);

                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RAW_RUBY_BLOCK);

                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                        entries.add(ModBlocks.NETHER_RUBY_ORE);
                        entries.add(ModBlocks.END_STONE_RUBY_ORE);

                    }).build());

    // Define the second item group
    public static final ItemGroup CUSTOM_LOGS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TutorialMod.MOD_ID, "logs"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.logs"))
                    .icon(() -> new ItemStack(ModBlocks.FROZEN_OAK_LOG)).entries((displayContext, entries) -> {

                        entries.add(ModBlocks.FROZEN_OAK_LOG);

                    }).build());

    // Method to initialize item groups
    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }
}