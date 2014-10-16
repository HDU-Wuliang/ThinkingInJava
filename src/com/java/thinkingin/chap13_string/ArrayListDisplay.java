package com.java.thinkingin.chap13_string;

import java.util.ArrayList;

public class ArrayListDisplay {
	public static void main(String []args) {
		ArrayList<Coffee> coffees = new ArrayList<Coffee>();
		
		coffees.add(new Coffee("100", "hello"));
		coffees.add(new Coffee("101", "world"));
		
		System.out.println(coffees);
	}
}
