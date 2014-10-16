package com.java.thinkingin.chap13_string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiangGe
 * List<InfiniteRecursion> toString
 */
public class InfiniteRecursion {
	public String toString() {
		// String字符串重载+流程是，编译器遇到String后面+，判断后面紧接是否对象String，
		// 如果不是String对象就将this转换成string，也即调用this对象的toString，导致递归调用
		// return "InfiniteRecursion address is " + this + "\n";
		return "Infinit eRecursion address is " + super.toString() + "\n";
	}
	
	public static void main(String args[]) {
		List<InfiniteRecursion> list = new ArrayList<InfiniteRecursion>();
		for(int i=0; i<3; i++) {
			list.add(new InfiniteRecursion());
		}
		System.out.println(list);
	}
}
