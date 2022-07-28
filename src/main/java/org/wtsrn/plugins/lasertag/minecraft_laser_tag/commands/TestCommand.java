package org.wtsrn.plugins.lasertag.minecraft_laser_tag.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.wtsrn.plugins.lasertag.minecraft_laser_tag.utils.GunFactory;
import org.wtsrn.plugins.lasertag.minecraft_laser_tag.utils.LasertagPlayer;
import org.wtsrn.plugins.lasertag.minecraft_laser_tag.utils.PlayerHandler;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            sender.sendMessage(ChatColor.GOLD + "Gun recieved");
            Player p = (Player) sender;
            PlayerHandler.addPlayer(new LasertagPlayer(p), 3);
            GunFactory factory = new GunFactory(p);
            p.getInventory().addItem(factory.createGun());
            return true;
        }
        else {
            sender.sendMessage(ChatColor.RED + "Hell nah, console can't test the gun");
            return true;
        }

    }
}
