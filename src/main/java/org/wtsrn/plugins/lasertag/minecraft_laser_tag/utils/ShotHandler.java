package org.wtsrn.plugins.lasertag.minecraft_laser_tag.utils;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import org.bukkit.util.Vector;

import java.util.List;

public class ShotHandler {

    public ShotHandler() {}

    public Location roundLocation(Location loc){
        Double X, Y, Z;
        X = new Long(Math.round(loc.getX())).doubleValue();
        Y = new Long(Math.round(loc.getY())).doubleValue();
        Z = new Long(Math.round(loc.getZ())).doubleValue();
        return new Location(loc.getWorld(), X, Y, Z);
    }


    public void distanceTest(Player start){
        int X, Y, Z;
        X = (int)Math.round(start.getEyeLocation().getDirection().getX());
        Y = (int)Math.round(start.getEyeLocation().getDirection().getY());
        Z = (int)Math.round(start.getEyeLocation().getDirection().getZ());
        Vector rounded = new Vector(X,Y,Z);
        for(int i =1; i<= 10; i++){
            Location temp = roundLocation(start.getEyeLocation()).add(rounded.normalize().multiply(i));
            Block bl = temp.getBlock();
            if(bl.isSolid()){
                start.playSound(start.getLocation(), Sound.BLOCK_ANVIL_BREAK,1f, 1f);
                break;
            }
            for(LasertagPlayer p :PlayerHandler.getCurrentPlayers()){
                Location tempP = roundLocation(p.getPlayer().getLocation());
                if(tempP.equals(temp)){
                    shot(p, start);
                    break;
                }
            }


        }
    }

    public void shot(LasertagPlayer shot, Player gunner){
            PlayerHandler.damage(shot);
            gunner.sendMessage(ChatColor.RED + (shot.getPlayer().displayName() + " got hit, they have " + PlayerHandler.getHealth(shot) + " health left"));
            int tempHealth = PlayerHandler.getHealth(shot);
            if(tempHealth == 0){
                PlayerHandler.removePlayer(shot);
            }
    }


}
