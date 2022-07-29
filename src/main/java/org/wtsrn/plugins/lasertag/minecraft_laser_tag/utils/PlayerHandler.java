package org.wtsrn.plugins.lasertag.minecraft_laser_tag.utils;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PlayerHandler {



    static Map<Player, Integer> currPlayers = new HashMap<>();

    public static void damage(Player key){
        currPlayers.replace(key, getHealth(key) - 1);
    }

    public static int getHealth(Player p) {
        return currPlayers.get(p);
    }

    public static boolean hasPlayer(Player p) {
        return currPlayers.containsKey(p);
    }

    public static void addPlayer(Player p, Integer health) {
        currPlayers.put(p, health);
    }

    public static Set<Player> getCurrentPlayers() {
        return currPlayers.keySet();
    }

    public static void removePlayer(Player p){
        currPlayers.remove(p);
    }


}
