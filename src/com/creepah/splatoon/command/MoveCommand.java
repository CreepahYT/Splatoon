package com.creepah.splatoon.command;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.creepah.splatoon.Splatoon;
import com.creepah.splatoon.manager.TeamManager.Team;

public class MoveCommand implements CommandExecutor
{

	Splatoon splatoon;

	public MoveCommand(Splatoon splatoon) {
		this.splatoon = splatoon;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(args.length < 2)
		{
			sender.sendMessage(Splatoon.prefix + "§c/move <Spieler> <Team>");
		}
		else
		{
			OfflinePlayer player = Bukkit.getOfflinePlayer(args[0]);
			if(player.isOnline())
			{
				if(args[1].equalsIgnoreCase("team1"))
				{
					if(splatoon.getTeamOne().getMembers().size() < 4)
					{
						splatoon.getTeamManager().forceAddPlayer(player.getPlayer(), Team.TEAM1, sender);
					}
					else
					{
						sender.sendMessage(Splatoon.prefix + "§cDieses Team ist voll!");
					}
				}
				else if(args[1].equalsIgnoreCase("team2"))
				{
					if(splatoon.getTeamTwo().getMembers().size() < 4)
					{
						splatoon.getTeamManager().forceAddPlayer(player.getPlayer(), Team.TEAM2, sender);
					}
					else
					{
						sender.sendMessage(Splatoon.prefix + "§cDieses Team ist voll!");
					}
				}
				else
				{
					sender.sendMessage(Splatoon.prefix + "§cVerfügbare Teams: team1, team2");
				}
			}
			else
			{
				sender.sendMessage(Splatoon.prefix + "§cDieser Spieler ist nicht online!");
			}
		}

		return true;
	}

}