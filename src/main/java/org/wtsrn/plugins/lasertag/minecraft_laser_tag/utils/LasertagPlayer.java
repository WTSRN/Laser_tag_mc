package org.wtsrn.plugins.lasertag.minecraft_laser_tag.utils;

import org.bukkit.entity.Player;

public class LasertagPlayer {
    Player player;
    int health;

    public LasertagPlayer(Player p){
        this.player = p;
        this.health = 3;
    }
}
