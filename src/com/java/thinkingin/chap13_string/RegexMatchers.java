package com.java.thinkingin.chap13_string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatchers {
	public static void main(String args[]) {
		// 按指定模式在字符串查找
		String line = "This order was placed for QT3000! OK?";
		String patternStr = "(.*)(\\d+)(.*)";
		// pattern对象是一个正则表达式的编译表示。Pattern类没有公共构造方法。
		// 要创建一个Pattern对象，你必须首先调用其公共静态编译方法，它返回一个Pattern对象。
		// 该方法接受一个正则表达式作为它的第一个参数。
		Pattern pattern = Pattern.compile(patternStr);
		// Matcher对象是对输入字符串进行解释和匹配操作的引擎。
		Matcher matcher = pattern.matcher(line);
		if(matcher.find()) {
			System.out.println("Found value :" + matcher.group(0));
			System.out.println("Found value :" + matcher.group(1));
			System.out.println("Found value :" + matcher.group(2));
			System.out.println("Found value :" + matcher.group(3));
		}
	}
}
