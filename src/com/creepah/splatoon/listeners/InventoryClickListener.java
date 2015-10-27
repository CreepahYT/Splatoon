package com.creepah.splatoon.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.creepah.splatoon.Splatoon;
import com.creepah.splatoon.manager.TeamManager.Team;

public class InventoryClickListener implements Listener
{
	Splatoon splatoon;

	public InventoryClickListener(Splatoon splatoon) {
		this.splatoon = splatoon;
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e)
	{
		Player p = (Player) e.getWhoClicked();

		e.setCancelled(true);

		if(e.getClickedInventory().getTitle().equalsIgnoreCase("           §eWähle dein Team"))
		{
			if(e.getSlot() == 1)
			{
				splatoon.getTeamManager().addPlayer(p, Team.TEAM1);
			}
			else if(e.getSlot() == 3)
			{
				splatoon.getTeamManager().addPlayer(p, Team.TEAM2);
			}
			p.closeInventory();
		}
	}

}
