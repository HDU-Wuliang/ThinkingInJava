package com.java.thinkingin.chap13_string;

/**
 * @author LiangGe
 * 简单正则表达式联系
 */
public class SimpleRegex {
	private static String knights = "That is my father the ted is special t d chair in his office.";
	
	public static void main(String args) {
		System.out.println(knights.replaceFirst("That", "GGOGOGO"));
		System.out.println(knights);
		
		System.out.println(knights.replaceFirst("That", "GGOGOGO"));
		
		System.out.println(knights.replaceFirst("That", "GGOGOGO"));		
	}
}
