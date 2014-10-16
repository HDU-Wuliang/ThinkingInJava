package com.java.thinkingin.chap13_string;

import java.util.Arrays;
import java.util.regex.Pattern;

import com.java.thinking.simulate.SplitSimulate;

public class SplitDemo {

	public String toString(String[] array) {
		StringBuilder result = new StringBuilder("[");
		int len = array.length;
		for (int i = 0; i < len - 1; i++) {
			result.append(array[i].toString() + ",");
		}
		return result.append(array[len - 1].toString() + "]").toString();
	}

	public static void main(String args[]) {
		String input = "This!! unusual aaa use !! of usexclamation aaa !! uspoints";
		System.out.println(Arrays.toString(Pattern.compile("!!").split(input)));
		System.out.println(Arrays.toString(Pattern.compile("!!")
				.split(input, 3)));
		// 调用自定义模拟split方法
		SplitSimulate simulate = new SplitSimulate();
		simulate.compile("aaa");
		String[] array = simulate.split(input, 2);

		SplitDemo splitDemo = new SplitDemo();

		System.out.println(splitDemo.toString(array));
		
		System.out.println("---------------------------");
		
		String string = ",aaa,bbb,ccc,,,,,";
		String[] resultStr = Pattern.compile(",").split(string);
		System.out.println(resultStr.length);
		System.out.println(Arrays.toString(Pattern.compile(",").split(string)));
	}
}
