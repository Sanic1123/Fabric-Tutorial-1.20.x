package net.sanic.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.sanic.tutorialmod.TutorialMod;
import net.sanic.tutorialmod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup Steel_Group = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TutorialMod.MOD_ID, "steel"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.steel"))
                    .icon(() -> new ItemStack(ModItems.Steel_Ingot)).entries((displayContext, entries) -> {
                        entries.add(ModItems.Steel_Ingot);
                        entries.add(ModItems.Steel_Plate);

                        entries.add(ModItems.Metal_Detector);

                        entries.add(ModBlocks.Steel_Block);
                    }).build());
     public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Register Item Groups for " + TutorialMod.MOD_ID);
    }
}
