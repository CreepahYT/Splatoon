package com.creepah.splatoon.util;

import java.util.ArrayList;
import java.util.List;

public enum InkColor {
	
	MAGENTA(2, "Magenta"),
	ORANGE(1, "Orange"),
	SKYBLUE(3, "Himmelblau"),
	LIMEGREEN(5, "Limonengrün"),
	RED(14, "Rot"),
	BLUE(11, "Blau");
	
	int blockid;
	String name;
	
	private InkColor(int blockid, String name)
	{
		this.name = name;
		this.blockid = blockid;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getColor()
	{
		return blockid;
	}
	
	public static List<InkColor> getInkColors()
	{
		List<InkColor> colors = new ArrayList<InkColor>();
		colors.add(MAGENTA);
		colors.add(ORANGE);
		colors.add(SKYBLUE);
		colors.add(LIMEGREEN);
		colors.add(RED);
		colors.add(BLUE);
		return colors;
	}
}
