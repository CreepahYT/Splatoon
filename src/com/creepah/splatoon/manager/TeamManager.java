package com.creepah.splatoon.manager;

import java.util.ArrayList;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.creepah.splatoon.Splatoon;

public class TeamManager {

	private ArrayList<Player> team1 = new ArrayList<>();
	private ArrayList<Player> team2 = new ArrayList<>();
	private Splatoon splatoon;


	public TeamManager(Splatoon splatoon) {
		this.splatoon = splatoon;
	}

	public void addPlayer(Player player, Team team) {
		if(team == Team.TEAM2)
		{
			if(team1.contains(player))
			{
				if(team2.size() < 4)
				{
					team1.remove(player);
					splatoon.getTeamOne().kickMember(player);
					team2.add(player);
					player.sendMessage(Splatoon.prefix + "Du bist Team §6" + splatoon.getTeamTwo().getInkColor().getName() + " §7beigetreten.");
					splatoon.getTeamTwo().addMember(player);
				}
				else
				{
					player.sendMessage(Splatoon.prefix + "§cDas Team §6" + splatoon.getTeamTwo().getInkColor().getName() + "§c ist voll!");
				}
			}
			else if(team2.contains(player))
			{
				player.sendMessage(Splatoon.prefix + "Du bist schon in Team §6" + splatoon.getTeamTwo().getInkColor().getName() + "§7!");
			}
			else
			{
				team2.add(player);
				player.sendMessage(Splatoon.prefix + "Du bist Team §6" + splatoon.getTeamTwo().getInkColor().getName() + " §7beigetreten.");
				splatoon.getTeamTwo().addMember(player);
			}
		}
		else if(team == Team.TEAM1)
		{
			if(team2.contains(player))
			{
				if(team1.size() < 4)
				{
					team2.remove(player);
					splatoon.getTeamTwo().kickMember(player);
					team1.add(player);
					player.sendMessage(Splatoon.prefix + "Du bist Team §6" + splatoon.getTeamOne().getInkColor().getName() + " §7beigetreten.");
					splatoon.getTeamOne().addMember(player);
				}
				else
				{
					player.sendMessage(Splatoon.prefix + "§cDas Team §6" + splatoon.getTeamOne().getInkColor().getName() + "§c ist voll!");
				}
			}
			else if(team1.contains(player))
			{
				player.sendMessage(Splatoon.prefix + "Du bist schon in Team §6" + splatoon.getTeamOne().getInkColor().getName() + "§7!");
			}
			else
			{
				team1.add(player);
				player.sendMessage(Splatoon.prefix + "Du bist Team §6" + splatoon.getTeamOne().getInkColor().getName() + " §7beigetreten.");
				splatoon.getTeamOne().addMember(player);
			}
		}
		else
		{
			if(team2.contains(player))
			{
				if(team1.size() < 4)
				{
					team1.add(player);
					player.sendMessage(Splatoon.prefix + "Du bist Team §6" + splatoon.getTeamOne().getInkColor().getName() + " §7beigetreten.");
					splatoon.getTeamOne().addMember(player);
				}
			}
			if(team1.contains(player))
			{
				if(team2.size() < 4)
				{
					team2.add(player);
					player.sendMessage(Splatoon.prefix + "Du bist Team §6" + splatoon.getTeamTwo().getInkColor().getName() + " §7beigetreten.");
					splatoon.getTeamOne().addMember(player);
				}
			}
			else
			{
				player.sendMessage(Splatoon.prefix + "§cBeide Teams sind voll!");
			}
		}

	}

	public void joinTeam(Player player, Team team) {
		if(team == Team.TEAM2)
		{
			if(team2.size() < 4)
			{
				team1.remove(player);
				splatoon.getTeamOne().kickMember(player);
				team2.add(player);
				splatoon.getTeamTwo().addMember(player);
			}
		}
		else if(team == Team.TEAM1)
		{
			if(team1.size() < 4)
			{
				team2.remove(player);
				splatoon.getTeamTwo().kickMember(player);
				team1.add(player);
				splatoon.getTeamOne().addMember(player);
			}
		}
		else
		{
			if(team1.size() < 4)
			{
				team1.add(player);
				splatoon.getTeamOne().addMember(player);
			}
			else if(team2.size() < 4)
			{
				team2.add(player);
				splatoon.getTeamTwo().addMember(player);
			}
		}

	}

	public void forceAddPlayer(Player player, Team team, CommandSender sender) {
		if(team == Team.TEAM2)
		{
			if(team1.contains(player))
			{
				if(team2.size() < 4)
				{
					team1.remove(player);
					splatoon.getTeamOne().kickMember(player);
					team2.add(player);
					player.sendMessage(Splatoon.prefix + "Du wurdest von §6" + sender.getName() + " §7in das Team §6" + splatoon.getTeamTwo().getInkColor().getName() + " §7verschoben!");
					sender.sendMessage(Splatoon.prefix + "Du hast §6" + player.getName() + " §7in das Team §6" + splatoon.getTeamTwo().getInkColor().getName() + " §7verschoben!");
					splatoon.getTeamTwo().addMember(player);
				}
				else
				{
					sender.sendMessage(Splatoon.prefix + "§cDas Team §6" + splatoon.getTeamTwo().getInkColor().getName() + "§c ist voll!");
				}
			}
			else
			{
				team2.add(player);
				player.sendMessage(Splatoon.prefix + "Du wurdest von §6" + sender.getName() + " §7in das Team §6" + splatoon.getTeamTwo().getInkColor().getName() + " §7verschoben!");
				sender.sendMessage(Splatoon.prefix + "Du hast §6" + player.getName() + " §7in das Team §6" + splatoon.getTeamTwo().getInkColor().getName() + " §7verschoben!");
				splatoon.getTeamTwo().addMember(player);
			}
		}
		else if(team == Team.TEAM1)
		{
			if(team2.contains(player))
			{
				if(team1.size() < 4)
				{
					team2.remove(player);
					splatoon.getTeamTwo().kickMember(player);
					team1.add(player);
					player.sendMessage(Splatoon.prefix + "Du wurdest von §6" + sender.getName() + " §7in das Team §6" + splatoon.getTeamOne().getInkColor().getName() + " §7verschoben!");
					sender.sendMessage(Splatoon.prefix + "Du hast §6" + player.getName() + " §7in das Team §6" + splatoon.getTeamOne().getInkColor().getName() + " §7verschoben!");
					splatoon.getTeamOne().addMember(player);
				}
				else
				{
					sender.sendMessage(Splatoon.prefix + "§cDas Team §6" + splatoon.getTeamOne().getInkColor().getName() + "§c ist voll!");
				}
			}
			else
			{
				team1.add(player);
				player.sendMessage(Splatoon.prefix + "Du wurdest von §6" + sender.getName() + " §7in das Team §6" + splatoon.getTeamOne().getInkColor().getName() + " §7verschoben!");
				sender.sendMessage(Splatoon.prefix + "Du hast §6" + player.getName() + " §7in das Team §6" + splatoon.getTeamOne().getInkColor().getName() + " §7verschoben!");
				splatoon.getTeamOne().addMember(player);
			}
		}
		else
		{
			if(team1.size() < 4)
			{
				team1.add(player);
				player.sendMessage(Splatoon.prefix + "Du wurdest von §6" + sender.getName() + " §7in das Team §6" + splatoon.getTeamOne().getInkColor().getName() + " §7verschoben!");
				splatoon.getTeamOne().addMember(player);
			}
			else if(team2.size() < 4)
			{
				team2.add(player);
				player.sendMessage(Splatoon.prefix + "Du wurdest von §6" + sender.getName() + " §7in das Team §6" + splatoon.getTeamTwo().getInkColor().getName() + " §7verschoben!");
				splatoon.getTeamTwo().addMember(player);
			}
			else
			{
				sender.sendMessage(Splatoon.prefix + "§cBeide Teams sind voll!");
			}
		}

	}

	public void quitTeam(Player player) {
		if(team1.contains(player))
		{
			team1.remove(player);
			splatoon.getTeamOne().kickMember(player);
		}
		else if(team2.contains(player))
		{
			team2.remove(player);
			splatoon.getTeamTwo().kickMember(player);
		}
	}
	
	public Team getTeam(Player player)
	{
		if(team1.contains(player))return Team.TEAM1;
		else if(team2.contains(player));
		return null;
	}

	public enum Team
	{
		TEAM1,
		TEAM2;
	}
}
