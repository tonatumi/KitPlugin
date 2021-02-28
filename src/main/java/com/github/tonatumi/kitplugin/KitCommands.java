package com.github.tonatumi.kitplugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class KitCommands implements CommandExecutor {

    private final KitPlugin plugin;

    public KitCommands(KitPlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if(!(sender instanceof Player)){
            return true;
        }

        Player p = (Player) sender;

        //kit
        if(label.equalsIgnoreCase("kit") && args.length == 0){
            showHelp(p);
            return true;
        }

        //kit set
        if(args[0].equalsIgnoreCase("set") && args.length == 1){
            ItemStack item;
            for(int i=0; i<36; i++){
                item = p.getInventory().getItem(i);
                plugin.getConfig().set(String.valueOf(i),item);
            }
            plugin.saveConfig();
            p.sendMessage("kit saved!");
            return true;
        }

        //kit give
        if(args[0].equalsIgnoreCase("give") && args.length == 1){
            plugin.getConfig();
            ItemStack kitItem;
            for(int j = 0; j<36; j++){
                kitItem = new ItemStack((Material) plugin.getConfig().get("kits."+j+".type"),plugin.getConfig().getInt("kits."+j+".amount"));
                p.getInventory().setItem(j,kitItem);
            }
            p.sendMessage("kit set!");
            return true;
        }

        //kit reload
        if(args[0].equalsIgnoreCase("reload") && args.length == 1){
            plugin.reloadConfig();
            plugin.getConfig();
            p.sendMessage("reload config!");
            return true;
        }
        return false;

    }
     public void showHelp(Player p){
        p.sendMessage("/kit:show help");
        p.sendMessage("/kit set:set a kit by your inventory");
        p.sendMessage("/kit give:rewrite your inventory by kit");
        p.sendMessage("/kit reload:reload config");
     }

}
