package net.diego.mod2.util;

import net.diego.mod2.Mod2;
import net.diego.mod2.item.ModItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModRegistries {
    public static void registerModStuffs(){
        registerFuels();
    }

    private static void registerFuels(){
        Mod2.LOGGER.info("Registering fuels for "+Mod2.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.LILAC_FLOWER_BULB,200);
    }
}
