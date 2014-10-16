package com.java.thinkingin.chap13_string;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ScannerDelimiter {
	public static void main(String args[]) {
		Scanner scanner = new Scanner("12,32,            56, 87, 10");
		// \s 空白符号  , * 特定字符出现0次以上时
		scanner.useDelimiter("\\s*,\\s*");
		while(scanner.hasNextInt()) {
			System.out.println(scanner.nextInt());
		}
		
		Pattern pattern = scanner.delimiter();
	}
}

