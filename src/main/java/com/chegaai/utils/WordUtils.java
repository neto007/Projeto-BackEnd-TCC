package com.chegaai.utils;

public class WordUtils {

	public static String capitalize(String string) {
		return Character.toUpperCase(string.charAt(0)) + string.substring(1).toLowerCase();
	}

}
