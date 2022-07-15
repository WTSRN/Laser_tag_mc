package org.wtsrn.plugins.lasertag.minecraft_laser_tag.utils;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PlayerHandler {
    Map<LasertagPlayer, Integer> currPlayers = new HashMap<>();

    public PlayerHandler() {

    }

    public int getHealth(LasertagPlayer p) {
        return currPlayers.get(p);
    }

    public boolean hasPlayer(LasertagPlayer p) {
        return currPlayers.containsKey(p);
    }

    public void addPlayer(LasertagPlayer p, Integer health) {
        currPlayers.put(p, health);
    }

    public Set<LasertagPlayer> getCurrentPlayers() {
        return currPlayers.keySet();
    }

    public void removePlayer(LasertagPlayer p){
        currPlayers.remove(p);
    }


}
