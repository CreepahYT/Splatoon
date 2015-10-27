package com.creepah.splatoon;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.creepah.creepahplugin.CreepahPlugin;
import com.creepah.splatoon.command.MoveCommand;
import com.creepah.splatoon.listeners.InventoryClickListener;
import com.creepah.splatoon.listeners.JoinQuitListener;
import com.creepah.splatoon.listeners.LobbyListener;
import com.creepah.splatoon.listeners.PlayerInteractListener;
import com.creepah.splatoon.manager.InventoryManager;
import com.creepah.splatoon.manager.TeamManager;
import com.creepah.splatoon.manager.TeleportManager;
import com.creepah.splatoon.util.Countdown;
import com.creepah.splatoon.util.FileManager;
import com.creepah.splatoon.util.InkColor;
import com.creepah.splatoon.util.State;
import com.creepah.splatoon.util.Team;

public class Splatoon extends CreepahPlugin
{
	
	public static String prefix = "§9Splatoon §8| §7";
	
	TeamManager teamManager;
	InventoryManager inventoryManager;
	TeleportManager teleportManager;
	FileManager fileManager;
	Splatoon splatoon;
	State state;
	
	Team team1;
	Team team2;
	
	@Override
	public void onEnable() {
		commands();
		managers();
		events();
		chooseColors();	
		startCountdown();
	}

	private void startCountdown() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Countdown(this), 20, 20);
	}

	private void commands() {
		getCommand("move").setExecutor(new MoveCommand(this));
	}

	private void chooseColors() {
		Random r = new Random();
		
		InkColor inkcolor1 = InkColor.getInkColors().get(r.nextInt(InkColor.getInkColors().size()));
		InkColor inkcolor2 = InkColor.getInkColors().get(r.nextInt(InkColor.getInkColors().size()));
		
		while(inkcolor2 == inkcolor1)
		{
			inkcolor2 = InkColor.getInkColors().get(r.nextInt(InkColor.getInkColors().size()));
		}
		
		team1 = new Team(inkcolor1);
		team2 = new Team(inkcolor2);
	}

	private void managers() {
		splatoon = this;
		teamManager = new TeamManager(this);
		inventoryManager = new InventoryManager(this);
		teleportManager = new TeleportManager(this);
		fileManager = new FileManager(this);
		state = State.LOBBY;
	}
	
	public TeleportManager getTeleportManager() {
		return teleportManager;
	}
	
	public FileManager getFileManager() {
		return fileManager;
	}
	
	public State getState() {
		return state;
	}
	
	private void events() {
		registerEvent(new JoinQuitListener(this));
		registerEvent(new InventoryClickListener(this));
		registerEvent(new PlayerInteractListener(this));
		registerEvent(new LobbyListener(this));
	}
	
	public Splatoon getSplatoon() {
		return splatoon;
	}
	
	public TeamManager getTeamManager() {
		return teamManager;
	}
	
	public Team[] getChosenTeams() {
		Team[] teams = new Team[2];
		teams[0] = team1;
		teams[1] = team2;
		return teams;
	}
	
	public Team getTeamOne()
	{
		return team1;
	}
	
	public Team getTeamTwo()
	{
		return team2;
	}

	public InventoryManager getInventoryManager() {
		return inventoryManager;
	}
	
}
