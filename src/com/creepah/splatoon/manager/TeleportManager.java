package com.creepah.splatoon.manager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import com.creepah.splatoon.Splatoon;
import com.creepah.splatoon.manager.TeamManager.Team;

public class TeleportManager {

	Splatoon splatoon;
	
	public TeleportManager(Splatoon splatoon) {
		this.splatoon = splatoon;
	}
	
	public void teleport(Player player)
	{
		Team team = splatoon.getTeamManager().getTeam(player);
		if(team == Team.TEAM1)
		{
			player.teleport(getLocation("team1"));
		}
		else if(team == Team.TEAM2)
		{
			player.teleport(getLocation("team2"));
		}
		else
		{
			player.kickPlayer("§cERROR! No team found.");
		}
	}
	
	private Location getLocation(String location)
	{
		World world = Bukkit.getWorld(splatoon.getFileManager().getLocationFileConfiguration().getString(location + ".world"));
		double x = splatoon.getFileManager().getLocationFileConfiguration().getDouble(location + ".x");
		double y = splatoon.getFileManager().getLocationFileConfiguration().getDouble(location + ".y");
		double z = splatoon.getFileManager().getLocationFileConfiguration().getDouble(location + ".z");
		float pitch = splatoon.getFileManager().getLocationFileConfiguration().getInt(location + ".pitch");
		float yaw = splatoon.getFileManager().getLocationFileConfiguration().getInt(location + ".yaw");
		
		Location loc = new Location(world, x, y, z);
		loc.setPitch(pitch);
		loc.setYaw(yaw);
		
		return loc;
	}

}
