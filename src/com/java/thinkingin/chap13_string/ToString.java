package com.java.thinkingin.chap13_string;

public class ToString {
	public static void main(String args[]) {
		String str = "abcdef";
		String str2 = "abc" + new String("def");
		
		String str3 = "abc" + "def";
		System.out.println(str == str2);
		System.out.println(str == str3);
		
		System.out.println("str2 = " + str2);

		String string = "121212";
		System.out.println("toString = " + string.toString());
	}
}
