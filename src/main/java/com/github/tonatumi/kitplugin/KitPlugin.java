package com.github.tonatumi.kitplugin;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class KitPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("start:KitPlugin...");
        getCommand("kit").setExecutor(new KitCommands(this));
        getServer().getPluginManager().registerEvents(new Events(this), this);
        saveDefaultConfig();
        FileConfiguration config = getConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("stop:KitPlugin...");
    }
}
