package org.wtsrn.plugins.lasertag.minecraft_laser_tag.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GunFactory {
    public List<String> lore = new ArrayList<>();
    public GunFactory(Player p){
        this.lore.add("Gun of " + p.getName());
    }

    public ItemStack createGun(){

        ItemStack gun = new ItemStack(Material.GOLDEN_HOE);
        ItemMeta gunMeta = gun.getItemMeta();
        gunMeta.setDisplayName("Laser gun");
        gunMeta.setLocalizedName("laser_gun");
        gunMeta.setLore(this.lore);
        gun.setItemMeta(gunMeta);
        return gun;
    }
}
