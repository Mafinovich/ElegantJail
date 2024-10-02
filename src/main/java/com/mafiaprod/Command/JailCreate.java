package com.mafiaprod.Command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class JailCreate implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return false;

        Player p = (Player) sender;

        if(!(p.hasPermission("elegantjail.jailcreate"))){
            p.sendMessage(ChatColor.RED + "У вас недостаточно прав!");
            return false;
        }

        if(args.length > 0){
            p.sendMessage(ChatColor.RED + "Данная команда не принимает аргументы!");
            return false;
        }


        return true;
    }
}
