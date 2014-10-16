package com.java.thinkingin.chap13_string;

import java.util.Arrays;

public class Splitting {
	private static String knights = "That is my father the ted is special t d chair in his office.";
	private static String[] arrays;

	public static String toString(Object[] a) {
		if(a == null) {
			return null;
		}
		int maxIndex = a.length - 1;
		if(maxIndex == -1) {
			return "[]";
		}
		StringBuffer result = new StringBuffer("[");
		for(int i=0; i<=maxIndex; i++) {
			result.append(a[i].toString());
			if(i != maxIndex) {
				result.append(",");
			}
		}
		result.append("]");
		return result.toString();
	}
	
	public static void split(String regex) {
		arrays = knights.split(regex);
		System.out.println(Splitting.toString(arrays));
	}

	public static void main(String args[]) {
		split(" ");
		
		split("\\W"); // \W 非单独字符 [^a-zA-Z_0-9]
		split("\\w"); // \w 单独字符 [a-zA-Z_0-9]
		
		split("t.d");
	}
}
