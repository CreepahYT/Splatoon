package com.creepah.splatoon.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.creepah.splatoon.Splatoon;
import com.creepah.splatoon.manager.TeamManager.Team;
import com.creepah.splatoon.util.Utils;

public class JoinQuitListener implements Listener
{

	Splatoon splatoon;

	public JoinQuitListener(Splatoon splatoon) {
		this.splatoon = splatoon;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e)
	{
		Player p = e.getPlayer();

		e.setJoinMessage("§e" + p.getName() + " hat Splatoon betreten.");

		if(splatoon.getTeamOne().getMembers().size() > splatoon.getTeamTwo().getMembers().size())
		{
			splatoon.getTeamManager().joinTeam(p, Team.TEAM2);
		}
		else if(splatoon.getTeamTwo().getMembers().size() > splatoon.getTeamOne().getMembers().size())
		{
			splatoon.getTeamManager().joinTeam(p, Team.TEAM1);
		}
		else
		{
			splatoon.getTeamManager().joinTeam(p, Team.TEAM1);
		}
		
		Utils.clearPlayer(p);
		p.getInventory().setItem(4, Utils.createItemstack(Material.STAINED_CLAY, "§eWähle dein Team", 1, 0));
		p.getInventory().setItem(8, Utils.createItemstack(Material.WATCH, "§eSplatoon verlassen", 1, 0));

		if(p.hasPermission("splatoon.admintools"))
		{
			p.getInventory().setItem(0, Utils.createItemstack(Material.COMPASS, "§eAdminTools", 1, 0));
		}
		
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e)
	{
		Player p = e.getPlayer();
		
		e.setQuitMessage("§e" + p.getName() + " hat Splatoon verlassen.");
		splatoon.getTeamManager().quitTeam(p);
	}

}
