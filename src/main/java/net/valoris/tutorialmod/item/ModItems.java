package net.valoris.tutorialmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.valoris.tutorialmod.TutorialMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.valoris.tutorialmod.item.custom.*;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new FabricItemSettings()));

    public static final Item METAL_DETECTOR = registerItem("metal_detector",
            new MetalDetectorItem(new FabricItemSettings().maxDamage(64)));
    public static final Item DIAMOND_DETECTOR = registerItem("diamond_detector",
            new DiamondDetectorItem(new FabricItemSettings().maxDamage(80)));
    public static final Item COPPER_DETECTOR = registerItem("copper_detector",
            new CopperDetectorItem(new FabricItemSettings().maxDamage(16)));
    public static final Item EMERALD_DETECTOR = registerItem("emerald_detector",
            new EmeraldDetectorItem(new FabricItemSettings().maxDamage(96)));
    public static final Item GOLD_DETECTOR = registerItem("gold_detector",
            new GoldDetectorItem(new FabricItemSettings().maxDamage(48)));
    public static final Item LAPIS_DETECTOR = registerItem("lapis_detector",
            new LapisDetectorItem(new FabricItemSettings().maxDamage(32)));
    public static final Item COAL_DETECTOR = registerItem("coal_detector",
            new CoalDetectorItem(new FabricItemSettings().maxDamage(32)));
    public static final Item NETHERITE_DETECTOR = registerItem("netherite_detector",
            new NetheriteDetectorItem(new FabricItemSettings().maxDamage(8)));
    public static final Item QUARTZ_DETECTOR = registerItem("quartz_detector",
            new QuartzDetectorItem(new FabricItemSettings().maxDamage(16)));
    public static final Item NETHER_DETECTOR = registerItem("nether_detector",
            new NetherDetectorItem(new FabricItemSettings().maxDamage(16)));
    public static final Item REDSTONE_DETECTOR = registerItem("redstone_detector",
            new RedstoneDetectorItem(new FabricItemSettings().maxDamage(24)));

    public static final Item RAW_DIAMOND = registerItem("raw_diamond", new Item(new FabricItemSettings()));


    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
        entries.add(RAW_RUBY);
        entries.add(RAW_DIAMOND);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
