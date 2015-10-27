package com.creepah.splatoon.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.creepah.splatoon.Splatoon;
import com.creepah.splatoon.manager.InventoryManager.InventoryType;

public class PlayerInteractListener implements Listener
{
	
	Splatoon splatoon;
	
	public PlayerInteractListener(Splatoon splatoon) {
		this.splatoon = splatoon;
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e)
	{
		Player p = e.getPlayer();
		if(!e.getItem().hasItemMeta())
		{
			return;
		}
		if(!e.getItem().getItemMeta().hasDisplayName())
		{
			return;
		}
		String itemname = e.getItem().getItemMeta().getDisplayName();
		e.setCancelled(true);
		if(itemname.equalsIgnoreCase("§eWähle dein Team"))
		{
			splatoon.getInventoryManager().openInventory(p, InventoryType.CHOOSETEAM);
		}
		if(itemname.equalsIgnoreCase("§eAdminTools"))
		{
			splatoon.getInventoryManager().openInventory(p, InventoryType.ADMINTOOLS);
		}
	}
	
}
