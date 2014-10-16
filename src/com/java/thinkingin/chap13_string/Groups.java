package com.java.thinkingin.chap13_string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Groups {
	public static String POEM = " Evening ising fulling ofing theing linnet'sing wingsing";
	public static void main(String[] args) {
		Matcher matcher = Pattern.compile("(\\w+)i(\\w+)").matcher(POEM);
		while(matcher.find()) {
			for(int i=0; i<=matcher.groupCount(); i++) {
				System.out.print("[" + matcher.group(i) + "]");
				System.out.print("[" + "start= " + matcher.start(i) + "end=" + matcher.end(i) + "]");				
			}
			System.out.print("\n");
		}
		System.out.print("-----------------------\n");
		Matcher matcher2 = Pattern.compile("(\\w+)").matcher(POEM);
		while(matcher2.find()) {
			for(int i=0; i<=matcher2.groupCount(); i++) {
				System.out.print("[" + matcher2.group(i) + "]");
				System.out.print("[" + "start= " + matcher2.start(i) + "end=" + matcher2.end(i) + "]");				
			}
			System.out.print("\n");
		}
		System.out.print("-----------------------\n");
		Matcher matcher3 = Pattern.compile("(\\w+)").matcher(POEM);
		// 需要正则表达式与输入的最开始处就开始匹配才会成功
		if(matcher3.lookingAt()) {
			System.out.print("[" + matcher3.group(1) + "]");
			System.out.print("[" + "start= " + matcher3.start(1) + "end=" + matcher3.end(1) + "]");				
		}
	}
}
