package org.wtsrn.plugins.lasertag.minecraft_laser_tag.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.wtsrn.plugins.lasertag.minecraft_laser_tag.utils.ShotHandler;
import sun.font.TrueTypeFont;

public class ShotListener implements Listener {

    @EventHandler
    public void onShot(PlayerInteractEvent event){
        ShotHandler handler = new ShotHandler();
        if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            Player shooter = event.getPlayer();
            if(shooter.getInventory().getItemInMainHand().hasItemMeta() && !(shooter.getInventory().getItemInMainHand().getType().equals(Material.AIR)) && shooter.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("laser_gun") && shooter.getInventory().getItemInMainHand().getType().equals(Material.GOLDEN_HOE)){
                event.setCancelled(true);
                handler.distanceTest(shooter);
            }
        }
    }
}
