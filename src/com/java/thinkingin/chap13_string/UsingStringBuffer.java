package com.java.thinkingin.chap13_string;

import java.util.Random;

public class UsingStringBuffer {
	private static Random rand = new Random(47);

	public String toString() {
		StringBuffer result = new StringBuffer("[");
		for (int i = 0; i < 2; i++) {
			result.append(rand.nextInt(100));
			result.append("..");
		}
		// 去除最后小点
		result.delete(result.length() - 2, result.length());
		result.append("]");
		return result.toString();
	}

	public static void main(String[] args) {
		UsingStringBuffer usb = new UsingStringBuffer();
		System.out.println(usb);
	}
}
