package com.creepah.splatoon.util;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.creepah.splatoon.Splatoon;

public class FileManager {

	Splatoon splatoon;
	
	public FileManager(Splatoon splatoon) {
		this.splatoon = splatoon;
	}
	
	public File getLocationFile()
	{
		return new File("plugins/Splatoon", "locs.yml");
	}
	
	public FileConfiguration getLocationFileConfiguration()
	{
		return YamlConfiguration.loadConfiguration(getLocationFile());
	}
}
