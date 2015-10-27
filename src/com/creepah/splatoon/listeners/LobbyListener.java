package com.creepah.splatoon.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import com.creepah.splatoon.Splatoon;
import com.creepah.splatoon.util.State;

public class LobbyListener implements Listener
{

	Splatoon splatoon;
	
	public LobbyListener(Splatoon splatoon) {
		this.splatoon = splatoon;
	}
	
	@EventHandler
	public void onFoodChange(FoodLevelChangeEvent e)
	{
		if(e.getFoodLevel() < 20)
		{
			e.setFoodLevel(20);
		}
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e)
	{
		if(splatoon.getState() == State.LOBBY)
		{
			e.setDamage(0);
		}
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e)
	{
		e.setCancelled(true);
	}
}
