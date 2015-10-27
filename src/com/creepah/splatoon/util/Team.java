package com.creepah.splatoon.util;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class Team
{
	
	List<Player> members = new ArrayList<>();
	InkColor inkColor;

	public Team(InkColor inkColor)
	{
		this.inkColor = inkColor;
	}
	
	public void addMember(Player player)
	{
		members.add(player);
	}
	
	public void addMembers(Player... player)
	{
		for(Player players : player)
		{
			members.add(players);
		}
	}
	
	public void kickMember(Player player)
	{
		members.remove(player);
	}
	
	public void kickMembers(Player... player)
	{
		for(Player players : player)
		{
			members.remove(players);
		}
	}
	
	public List<Player> getMembers()
	{
		return members;
	}
	
	public InkColor getInkColor()
	{
		return inkColor;
	}
	
}
