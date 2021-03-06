package com.jarhax.naturalharvest.proxy;

import com.jarhax.naturalharvest.NaturalHarvest;
import com.jarhax.naturalharvest.data.HarvestBlocks;
import com.jarhax.naturalharvest.data.HarvestItems;
import com.jarhax.naturalharvest.item.ItemHarvestFish;

import net.darkhax.bookshelf.util.OreDictUtils;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.SetDamage;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;

/**
 * This class contains code which is meant to be executed on both the client and server. Any
 * overriden methods should super call back to this one.
 */
public class CommonProxy {

    public void preInit (FMLPreInitializationEvent event) {

        // Item Registry
        NaturalHarvest.registry.registerItem(HarvestItems.JELLYFISH, "jellyfish");
        NaturalHarvest.registry.registerItem(HarvestItems.FISH, "fish");

        // Block Registry
        NaturalHarvest.registry.registerBlock(HarvestBlocks.TREE_TAP, "tree_tap");

        // OreDict
        OreDictionary.registerOre(OreDictUtils.SLIMEBALL, HarvestItems.JELLYFISH);

        // Loot
        NaturalHarvest.registry.addLoot(LootTableList.GAMEPLAY_FISHING_FISH, "jellyfish", "main", 2, HarvestItems.JELLYFISH);
        NaturalHarvest.registry.addLoot(LootTableList.GAMEPLAY_FISHING_FISH, "fish", "main", 45, HarvestItems.FISH).addFunction(new SetDamage(new LootCondition[0], new RandomValueRange(0, ItemHarvestFish.VARIANTS.length)));
    }

    public void init (FMLInitializationEvent event) {

    }

    public void postInit (FMLPostInitializationEvent event) {

    }
}
