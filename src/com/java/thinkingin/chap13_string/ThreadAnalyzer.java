package com.java.thinkingin.chap13_string;

import java.util.Scanner;
import java.util.regex.MatchResult;

/**
 * @author LiangGe 正则表达式
 */
public class ThreadAnalyzer {
	private static String threatData = "10.1.130.55@01/10/2005\n"
			+ "33.15.130.55@02/11/2009\n" + "22.55.66.588@12/09/2010\n"
			+ "23.06.88.169@22/07/2013\n";

	public static void main(String args[]) {
		Scanner scanner = new Scanner(threatData);
		String pattern = "(\\d+[.]\\d+[.]\\d+[.]\\d+)@"
				+ "(\\d{2}/\\d{2}/\\d{4})";
		// hasNext 判断是否存在下一个匹配的字符串pattern
		while (scanner.hasNext(pattern)) {
			// next 获取下一个匹配的字符串
			String str = scanner.next(pattern);
			// java.util.Scanner.match() 方法返回此scanner所执行的最后扫描操作的匹配结果
			MatchResult match = scanner.match();
			String ip = match.group(1);
			String date = match.group(2);
			System.out.println("str = " + str);
			System.out.format("Threat on %s from %s\n", date, ip);
		}
		scanner.useDelimiter(pattern);

		String s = "Hello World! 3 + 3.0 = 6 ";

		// create a new scanner with the specified String Object
		Scanner scanner2 = new Scanner(s);

		// check if next token is "Hello"
		System.out.println("" + scanner2.hasNext("Hello"));

		// find the last match and print it
		System.out.println("" + scanner2.match());

		// print the line
		System.out.println("" + scanner2.nextLine());

		// close the scanner
		scanner.close();
	}
}
