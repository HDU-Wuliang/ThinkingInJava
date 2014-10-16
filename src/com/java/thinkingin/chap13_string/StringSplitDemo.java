package com.java.thinkingin.chap13_string;

import java.util.Arrays;

import com.java.thinking.simulate.SplitSimulate;

public class StringSplitDemo {
	public static void main(String[] args) {
		String a = "hello,,,";
		String[] aArr = a.split(",");
		System.out.println("aArr.length=" + aArr.length);
		System.out.println(Arrays.toString(aArr));

		System.out.println("-----------------------");

		String b = "boo:and:foo";
		// *********************************************************
		// 如果 n 为零，则模式将被应用尽可能多的次数，数组可有任何长度，并且结尾空字符串将被丢弃。
		String[] bArr = b.split("o");
		System.out.println("bArr.length=" + bArr.length);
		System.out.println(Arrays.toString(bArr));

		String[] cArr = b.split("o", 6);
		System.out.println("cArr.length=" + cArr.length);
		System.out.println(Arrays.toString(cArr));

		System.out.println("-----------------------");
		// 测试自定义, 如果 n 为零
		SplitSimulate splitSimulate = new SplitSimulate();
		splitSimulate.compile("o");
		String[] result = splitSimulate.split(b);
		System.out.println("result.length=" + result.length);
		System.out.println(Arrays.toString(result));
	}
}
