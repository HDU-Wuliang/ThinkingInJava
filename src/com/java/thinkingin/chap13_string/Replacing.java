package com.java.thinkingin.chap13_string;

/**
 * @author LiangGe
 * 执行了替换操作后,源字符串的内容是没有发生改变的.
 */
public class Replacing {
	private static String knights = "That is my father the \\\\  ted is special t d chair in his 256 office.";
	
	public static void main(String args[]) {
		System.out.println(knights.replaceFirst("That", "GGOGOGO"));
		System.out.println(knights);
		
		System.out.println(knights.replaceFirst("Th.t", "XXXXX"));
		System.out.println(knights);
		
		System.out.println(knights.replaceFirst("off*", "GGOGOGO"));	
		System.out.println(knights);

		System.out.println(knights.replaceFirst("f\\w+", "99999"));	
		System.out.println(knights);
		
		System.out.println(knights.replaceAll("th..", "GGOGOGO"));	
		System.out.println(knights);
		// 基于规则表达式的替换
		System.out.println("/".replaceFirst("/", "//"));
		
		System.out.println(knights.replace("is", "8888"));
		
		// 参数是char和CharSequence,字符串替换，不支持正则表达式
		System.out.println(knights.replace("Th.t", "99659"));
		// 参数是regex,即基于规则表达式的替换,比如,可以通过replaceAll("\\d", "*")把一个字符串所有的数字字符都换成星号;
		System.out.println(knights.replaceAll("Th.t", "99659"));
		System.out.println(knights.replaceAll("\\d","**"));
		// 将字符串中的"\"替换成"\\"：
		// '\'在java中是一个转义字符，所以需要用两个代表一个。例如System.out.println( "\\" ) ;只打印出一个"\"。
		// 但是'\'也是正则表达式中的转义字符（replaceAll 的参数就是正则表达式），
		// 需要用两个代表一个。所以：\\\\被java转换成\\,\\又被正则表达式转换成\。
		System.out.println(knights.replaceAll("\\\\","\\\\\\\\"));
	}
}
