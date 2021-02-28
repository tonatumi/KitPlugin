package com.github.tonatumi.kitplugin;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;

public class Events implements Listener {

    KitPlugin plugin;
    public Events(KitPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerLoginEvent event){
        Player p = event.getPlayer();
        if(!(p.hasPlayedBefore())){
            p.getInventory().addItem(new ItemStack(Material.ALLIUM,2));
            p.sendMessage("hello kit");
        }
    }
}
