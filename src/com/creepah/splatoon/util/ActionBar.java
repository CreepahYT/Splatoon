package com.creepah.splatoon.util;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R2.IChatBaseComponent;
import net.minecraft.server.v1_8_R2.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R2.PacketPlayOutChat;
import net.minecraft.server.v1_8_R2.PlayerConnection;

import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ActionBar
{
	
	private String message = "";
	
	public ActionBar()
	{
		
	}
	
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	public void send(Player player)
	{
		if(message == null) message = "";
		message = ChatColor.translateAlternateColorCodes('&', message);
		message = message.replaceAll("%PLAYER%", player.getDisplayName());
		
		PlayerConnection con = ((CraftPlayer)player).getHandle().playerConnection;
		
		IChatBaseComponent chat = ChatSerializer.a("{\"text\": \"" + message + "\"}");
		PacketPlayOutChat packet = new PacketPlayOutChat(chat, (byte) 2);
		con.sendPacket(packet);	
	}
}
