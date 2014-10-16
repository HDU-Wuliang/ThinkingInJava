package com.java.thinkingin.chap13_string;

public class StringMethod {
	public static void main(String args[]) {
		StringMethod stringMethod = new StringMethod();
		String str = "1238888888";
		System.out.println(str.length());
		System.out.println(str.charAt(2));
		System.out.println(str.startsWith("1"));		
		System.out.println(str.endsWith("1"));		
		System.out.println(str.indexOf("23888"));		
		System.out.println(str.indexOf("8"));
		
		System.out.println(str.lastIndexOf("8"));
		System.out.println(str.substring(2,5));
		
		System.out.println(str.replace("123", "999"));
		
	}
}
