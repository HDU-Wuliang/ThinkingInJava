package com.java.thinkingin.chap13_string;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JGrp {
	public static void main(String args[]) {
		Pattern pattern = Pattern.compile("s[abcdef]\\w+9");
		Scanner scanner = new Scanner(System.in);
		Matcher matcher = pattern.matcher("");
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			matcher.reset(line);
			while (matcher.find()) {
				System.out.println("group=" + matcher.group() + "   start="
						+ matcher.start());
			}
		}
	}
}
