package com.java.thinking.simulate;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author LiangGe
 * 模拟pattern的split方法
 */
public class SplitSimulate {
	private Pattern pattern;

	public SplitSimulate() {

	}

	public void compile(String regex) {
		pattern = Pattern.compile(regex);
	}

	public String[] split(CharSequence input) {
		return split(input, 0);
	}

	public String[] split(CharSequence input, int limit) {
		int index = 0;
		// 标记是否是limit限制
		boolean matchLimited = limit > 0;
		ArrayList<String> matchList = new ArrayList<String>();
		Matcher matcher = pattern.matcher(input);
		while (matcher.find()) {
			if (!matchLimited || matchList.size() < limit - 1) {
				String sub = input.subSequence(index, matcher.start())
						.toString();
				matchList.add(sub);
				index = matcher.end();
			} else if (matchList.size() == (limit - 1)) {
				String sub = input.subSequence(index, input.length())
						.toString();
				matchList.add(sub);
				index = matcher.end();
			}
		}
		// 如果没有matcher匹配
		if (index == 0) {
			return new String[] { input.toString() };
		}
		// 剩下片段全部算一段
		if (!matchLimited || matchList.size() < limit) {
			String sub = input.subSequence(index, input.length()).toString();
			matchList.add(sub);
		}
		// *****************************
		// 如果limit==0，则需要把末尾的空字符串去掉
		if(limit == 0) {
			while(matchList.size() > 0 && matchList.get(matchList.size()-1).equals("")) {
				matchList.remove(matchList.size()-1);
			}
		}
		
		int resultSize = matchList.size();
		String[] result = new String[resultSize];
		return matchList.subList(0, resultSize).toArray(result);
	}
}
