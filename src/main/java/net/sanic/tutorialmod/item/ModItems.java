package net.sanic.tutorialmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sanic.tutorialmod.TutorialMod;
import net.sanic.tutorialmod.item.custom.MetalDetectorItem;

public class ModItems {
    public static final Item Steel_Ingot = registerItem("steel_ingot", new Item(new FabricItemSettings()));
    public static final Item Steel_Plate = registerItem("steel_plate", new Item(new FabricItemSettings()));

    public static final Item Metal_Detector = registerItem("metal_detector",
            new MetalDetectorItem(new FabricItemSettings().maxDamage(64)));

    private static void  addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(Steel_Ingot);
        entries.add(Steel_Plate);
        entries.add(Metal_Detector);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }
    public  static  void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
