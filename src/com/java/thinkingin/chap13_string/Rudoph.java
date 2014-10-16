package com.java.thinkingin.chap13_string;

public class Rudoph {
	public static void main(String args[]) {
		String []string = new String[] {"Rudoph","[Rr][ahdUu]doph","[Rr][aeiou][a-z]oph",".*","R.*"};
		for(String pattern : string) {
			// public boolean matches(String regex) {}
			System.out.println("Rudoph".matches(pattern));
		}
	}
}
