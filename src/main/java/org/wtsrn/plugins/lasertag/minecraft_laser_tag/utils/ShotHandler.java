package org.wtsrn.plugins.lasertag.minecraft_laser_tag.utils;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import org.bukkit.util.Vector;

import java.util.List;

public class ShotHandler {
    ParticleRender particleRender;
    public ShotHandler() {
        this.particleRender = new ParticleRender();
    }

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
        Location startR = roundLocation(start.getEyeLocation());
        for(int i =1; i<= 10; i++){
            Location temp = roundLocation(start.getEyeLocation()).add(rounded.normalize().multiply(i));
            Block bl = temp.getBlock();
            particleRender.spawnParticleAlongLine(startR, temp, Particle.REDSTONE, 20, 10, 0.2,0.2,0.2, 0D, null , true, l -> l.getBlock().isPassable() );
            if(bl.isSolid()){
                start.playSound(start.getLocation(), Sound.BLOCK_ANVIL_BREAK,1f, 1f);
                break;
            }
            for(Player p :PlayerHandler.getCurrentPlayers()){
                Location tempP = roundLocation(p.getLocation());
                Location tempPE = roundLocation(p.getEyeLocation());
                if(tempP.equals(temp) || tempPE.equals(temp)){
                    particleRender.spawnParticleAlongLine(startR, tempP, Particle.REDSTONE, 20, 10, 0.2,0.2,0.2, 0D, null , true, l -> l.getBlock().isPassable() );
                    shot(p, start);
                    return;
                }
            }


        }
    }

    public void shot(Player shot, Player gunner){
            PlayerHandler.damage(shot);
            gunner.sendMessage(ChatColor.RED + (shot.getDisplayName() + " got hit, they have " + PlayerHandler.getHealth(shot) + " health left"));
            int tempHealth = PlayerHandler.getHealth(shot);
            if(tempHealth == 0){
                PlayerHandler.removePlayer(shot);
            }
    }


}
