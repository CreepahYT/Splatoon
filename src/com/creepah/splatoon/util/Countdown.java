package com.creepah.splatoon.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.creepah.splatoon.Splatoon;

public class Countdown implements Runnable
{
	int countdown = 120;
	Splatoon splatoon;

	public Countdown(Splatoon splatoon) {
		this.splatoon = splatoon;
	}

	@Override
	public void run() {
		ActionBar bar = new ActionBar();
		bar.setMessage("§7Das Spiel startet in §6" + countdown + " Sekunden");
		for(Player all : Bukkit.getOnlinePlayers())
		{
			bar.send(all);
		}
		
		if(countdown == 0)
		{
			for(Player all : Bukkit.getOnlinePlayers())
			{
				splatoon.getTeleportManager().teleport(all);
			}
		}
		countdown--;
	}
}
