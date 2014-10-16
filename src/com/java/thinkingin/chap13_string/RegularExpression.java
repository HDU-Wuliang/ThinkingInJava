package com.java.thinkingin.chap13_string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
	public static void main(String args[]) {
		if(args.length < 2) {
			System.out.println("Usage:..........");
			System.exit(0);
		}
		System.out.println("Input : \"" + args[0] + "\"");
		for(String arg: args) {
			Pattern pattern = Pattern.compile(arg);
			Matcher matcher = pattern.matcher(args[0]);
			while(matcher.find()) {
				System.out.println("Match \"" + matcher.group() + "\" at positions" +  matcher.start() + "-" + (matcher.end()-1));
			}
		}
	}
}
