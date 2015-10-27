package com.creepah.splatoon.util;

import java.util.Arrays;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Utils
{

	public static ItemStack createItemstack(Material mat, String name, int amount, int damage)
	{
		ItemStack stack = new ItemStack(mat, amount, (short) damage);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName(name);
		stack.setItemMeta(meta);
		
		return stack;
	}
	
	public static ItemStack createItemstack(Material mat, String name, int amount)
	{
		ItemStack stack = new ItemStack(mat, amount);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName(name);
		stack.setItemMeta(meta);
		
		return stack;
	}
	
	public static ItemStack createItemstack(Material mat, String name, int amount, String... lore)
	{
		ItemStack stack = new ItemStack(mat, amount);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(Arrays.asList(lore));
		stack.setItemMeta(meta);
		
		return stack;
	}
	
	public static ItemStack createItemstack(Material mat, String name, int amount, int damage, String... lore)
	{
		ItemStack stack = new ItemStack(mat, amount, (short) damage);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(Arrays.asList(lore));
		stack.setItemMeta(meta);
		
		return stack;
	}
	
	public static ItemStack createItemstack(Material mat, int amount, int damage)
	{
		ItemStack stack = new ItemStack(mat, amount, (short) damage);
		
		return stack;
	}
	
	public static void clearPlayer(Player player)
	{
		player.setFlying(false);
		player.setAllowFlight(false);
		player.setGameMode(GameMode.SURVIVAL);
		player.setExp(0);
		player.setLevel(0);
		player.setHealth(20);
		player.setFoodLevel(20);
		player.getActivePotionEffects().clear();
		player.getInventory().clear();
		player.setFireTicks(0);
	}
}
