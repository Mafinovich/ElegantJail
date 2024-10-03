package com.mafiaprod.Command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;


public class JailCreate implements CommandExecutor {
    public HashMap<String ,int[][]> JailDict = new HashMap<String, int[][]>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return false;

        Player p = (Player) sender;
        int[][] JailCord = new int[1][];
        int[] cord1 = new int[1];
        int[] cord2 = new int[1];

        if(!(p.hasPermission("elegantjail.jailcreate"))){
            p.sendMessage(ChatColor.RED + "У вас недостаточно прав!");
            return false;
        }

        if(args.length >= 3){
            p.sendMessage(ChatColor.RED + "Данная команда не принимает больше трех аргументов!");
            return false;
        }

        try{
            cord1[0] = Integer.parseInt(args[1]);
            cord2[0] = Integer.parseInt(args[3]);

            cord1[1] = Integer.parseInt(args[2]);
            cord2[1] = Integer.parseInt(args[2]);

            JailCord[0] = cord1;
            JailCord[1] = cord2;

            JailDict.put(args[0].toString() ,JailCord);

            p.sendMessage(ChatColor.GREEN + "Тюрьма " + args[0] + " успешно создана!");
        } catch (NumberFormatException e){
            p.sendMessage("Значения указаны в неверном формате! Убедитесь что пишете так: /jailcreate [Имя тюрьмы] [X1] [Z1] [X2] [Z2]");
            e.printStackTrace();
        }

        return true;
    }
}
