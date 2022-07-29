package org.wtsrn.plugins.lasertag.minecraft_laser_tag.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.wtsrn.plugins.lasertag.minecraft_laser_tag.utils.GunFactory;
import org.wtsrn.plugins.lasertag.minecraft_laser_tag.utils.PlayerHandler;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            for (int i = 0; i <= 35; i++) {

                ItemStack air = new ItemStack(Material.AIR);
                ItemStack tempItem = p.getInventory().getItem(i);
                if(tempItem == null){
                    continue;
                }
                if (tempItem.hasItemMeta() && tempItem.getType().equals(Material.GOLDEN_HOE) && tempItem.getItemMeta().getLocalizedName().equals("laser_gun")) {
                    p.getInventory().setItem(i, air);
                }
                }
                sender.sendMessage(ChatColor.GOLD + "Gun recieved");
                if (!PlayerHandler.hasPlayer(p)) {
                    PlayerHandler.addPlayer(p, 3);
                }
                GunFactory factory = new GunFactory(p);
                p.getInventory().addItem(factory.createGun());
            }
        else{
                sender.sendMessage(ChatColor.RED + "Hell nah, console can't test the gun");
            }
            return true;

        }
    }


