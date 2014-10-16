package com.java.thinkingin.chap13_string;

import java.util.Scanner;

/**
 * @author LiangGe
 * nextInt()/nextDouble() 最终都调用next(pattern)
 */
public class ScannerNextLine {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		String str1, str2;

		System.out.println("请输入第一个字符串：");
		// next()方法遇见第一个有效字符（非空格，换行符）时开始扫描，
		// 当遇见第一个分隔符或结束符(空格或换行符)时，结束扫描
		str1 = scanner.next();
		scanner.nextLine(); // 读取next后的enter键
		System.out.println("请输入第二个字符：");
		// nextLine()方法返回的是Enter键之前的所有字符
		str2 = scanner.nextLine();
		System.out.print("输入的字符串是str1=" + str1 + "\nstr2=" + str2);
		
		System.out.println("\n请输入一个int整数：");
		int age = scanner.nextInt();
		
		String name = scanner.nextLine();
		
		System.out.format("age=%d name=%s\n", age, name);
	}
}
