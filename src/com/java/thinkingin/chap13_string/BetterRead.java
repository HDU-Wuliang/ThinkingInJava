package com.java.thinkingin.chap13_string;

import java.util.Scanner;

public class BetterRead {
	public static void main(String args[]) {
		Scanner stdin = new Scanner(SimpleRead.input);
		System.out.println("What is your name?");
		String name = stdin.nextLine();
		System.out.println(name);
		System.out.println("What is your aaa?");
		int age = stdin.nextInt();
		double favourite = stdin.nextDouble();
		
		System.out.format("age %d favourite %f", age, favourite);
	}
}
