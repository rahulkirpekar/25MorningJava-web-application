package com.royal.util;

public class StringUtils 
{
	public static boolean isValidStr(String value) 
	{
		if((value != null) && (value.trim().length() > 0)) 
		{
			return true;
		}
		return false;
	}
}
