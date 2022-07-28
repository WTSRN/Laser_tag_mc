package org.wtsrn.plugins.lasertag.minecraft_laser_tag.utils;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PlayerHandler {



    static Map<LasertagPlayer, Integer> currPlayers = new HashMap<>();

    public static void damage(LasertagPlayer key){
        currPlayers.replace(key, getHealth(key) - 1);
    }

    public static int getHealth(LasertagPlayer p) {
        return currPlayers.get(p);
    }

    public static boolean hasPlayer(LasertagPlayer p) {
        return currPlayers.containsKey(p);
    }

    public static void addPlayer(LasertagPlayer p, Integer health) {
        currPlayers.put(p, health);
    }

    public static Set<LasertagPlayer> getCurrentPlayers() {
        return currPlayers.keySet();
    }

    public static void removePlayer(LasertagPlayer p){
        currPlayers.remove(p);
    }


}
