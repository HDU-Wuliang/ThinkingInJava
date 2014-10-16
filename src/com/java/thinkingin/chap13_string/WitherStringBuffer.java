package com.java.thinkingin.chap13_string;

public class WitherStringBuffer {

	public String implicit(String[] fields) {
		String result = "";
		for (int i = 0; i < fields.length; i++) {
			// java自动优化之后会每次生成StringBuffer对象
			// 每次循环都生成则浪费性能
			result += fields[i];
		}
		return result;
	}
	
	public String explicit(String []fields) {
		StringBuffer result = new StringBuffer();
		for(int i = 0; i < fields.length; i ++) {
			// result += fields[i]; StringBuffer没有重载+=
			result.append(fields[i]);
		}
		return result.toString();
	}
}
