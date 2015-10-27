package com.creepah.splatoon.manager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import com.creepah.splatoon.Splatoon;
import com.creepah.splatoon.util.Utils;

public class InventoryManager {

	Splatoon splatoon;
	
	public InventoryManager(Splatoon splatoon) {
		this.splatoon = splatoon;
	}

	public void openInventory(Player player, InventoryType type)
	{
		
		if(type == InventoryType.CHOOSETEAM)
		{
			
			String[] membersone = new String[splatoon.getTeamOne().getMembers().size() + 1];
			String[] memberstwo = new String[splatoon.getTeamTwo().getMembers().size() + 1];
			
			for(int i = 0; i < splatoon.getTeamOne().getMembers().size(); i++)
			{
				membersone[i] = "§9" + (i + 1) + ". " + splatoon.getTeamOne().getMembers().get(i).getName();
			}
			
			for(int i = 0; i < splatoon.getTeamTwo().getMembers().size(); i++)
			{
				memberstwo[i] = "§9" + (i + 1) + ". " + splatoon.getTeamTwo().getMembers().get(i).getName();
			}
			
			Inventory inv = Bukkit.createInventory(null, org.bukkit.event.inventory.InventoryType.HOPPER, "           §eWähle dein Team");
			inv.setItem(1, Utils.createItemstack(Material.STAINED_CLAY, "§eTeam " + splatoon.getTeamOne().getInkColor().getName(), 1, splatoon.getTeamOne().getInkColor().getColor(), membersone));
			inv.setItem(3, Utils.createItemstack(Material.STAINED_CLAY, "§eTeam " + splatoon.getTeamTwo().getInkColor().getName(), 1, splatoon.getTeamTwo().getInkColor().getColor(), memberstwo));
			player.openInventory(inv);
		}
		else
		{
			player.sendMessage(Splatoon.prefix + "§cComing soon!");
		}
	}
	
	public enum InventoryType
	{
		CHOOSETEAM,
		ADMINTOOLS;
	}
}
