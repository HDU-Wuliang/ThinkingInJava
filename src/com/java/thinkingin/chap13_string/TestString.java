package com.java.thinkingin.chap13_string;

public class TestString {
	public void change(String str) {
		str += "world";
	}
	
	public static void main(String[] args) {
		String s1 = "Monday";
		String s2 = "Monday";
		String s3 = "Mon" + "day";
		String mon = "Mon";
		String day = "day";

		String s4 = mon + day;

		System.out.println("s1 == s2 :" + (s1 == s2));
		System.out.println("s1 == s2 :" + (s1 == s2));
		System.out.println("s1 == s3 :" + (s1 == s3));
		System.out.println("s1 == s4 :" + (s1 == s4));
		
		TestString testString = new TestString();
		String str = "Hello";
		testString.change(str);
		System.out.println("str :" + str);
	}
}
