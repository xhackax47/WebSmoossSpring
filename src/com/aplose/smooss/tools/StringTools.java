package com.aplose.smooss.tools;

public class StringTools {
	
	public static String generateRandomString(int length)
	{
	    String str = "";
	    for(int x=0;x<length;x++)
	    {
	       int i = (int)Math.floor(Math.random() * 62);
	       str += "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".charAt(i);
	    }
	    return str;
	} 

}
