package org.wtsrn.plugins.lasertag.minecraft_laser_tag;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.wtsrn.plugins.lasertag.minecraft_laser_tag.commands.TestCommand;
import org.wtsrn.plugins.lasertag.minecraft_laser_tag.listeners.ShotListener;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("test").setExecutor(new TestCommand());
        Bukkit.getServer().getPluginManager().registerEvents(new ShotListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
