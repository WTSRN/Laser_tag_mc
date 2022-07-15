package org.wtsrn.plugins.lasertag.minecraft_laser_tag;

import org.bukkit.plugin.java.JavaPlugin;
import org.wtsrn.plugins.lasertag.minecraft_laser_tag.commands.TestCommand;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("test").setExecutor(new TestCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
