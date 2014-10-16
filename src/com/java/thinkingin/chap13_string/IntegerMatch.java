package com.java.thinkingin.chap13_string;

public class IntegerMatch {
	public static void main(String []args) {
		//  matches告知此字符串是否匹配给定的正则表达式
		System.out.println("-123456".matches("-?\\d+"));
		System.out.println("123456".matches("\\d"));
		System.out.println("123".matches("\\d+"));
	}
}
