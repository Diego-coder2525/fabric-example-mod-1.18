package net.diego.mod2.util;

import net.diego.mod2.Mod2;
import net.diego.mod2.command.ReturnHomeCommand;
import net.diego.mod2.command.SetHomeCommand;
import net.diego.mod2.event.ModPlayerEventCopyFrom;
import net.diego.mod2.item.ModItems;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModRegistries {
    public static void registerModStuffs(){
        registerCommands();
        registerEvents();
        registerFuels();
    }

    private static void registerFuels(){
        Mod2.LOGGER.info("Registering fuels for "+Mod2.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.LILAC_FLOWER_BULB,200);
    }
    private static void registerCommands(){
        CommandRegistrationCallback.EVENT.register(SetHomeCommand::register);
        CommandRegistrationCallback.EVENT.register(ReturnHomeCommand::register);
    }
    private static void registerEvents(){
        ServerPlayerEvents.COPY_FROM.register(new ModPlayerEventCopyFrom());
    }

}
