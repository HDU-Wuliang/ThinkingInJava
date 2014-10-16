package com.java.thinkingin.chap13_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class SimpleRead {
	public static BufferedReader input = new BufferedReader(new StringReader("Hello World!\n22 1.61803"));
	
	public static void main(String args[]) {
		try {
			System.out.println("What is your name?");
			String name  = input.readLine();
			System.out.println(name);
			
			System.out.println("What is your aaa?");
			String numbers = input.readLine();
			System.out.println("numbers = " + numbers);
			String[] numArray = numbers.split(" ");
			int age = Integer.parseInt(numArray[0]);
			double favourite = Double.parseDouble(numArray[1]);
			
			System.out.format("age %d favourite %f", age, favourite);
		} catch(IOException e) {
			
		}		
	} 
}
