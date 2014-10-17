package com.java.thinkingin.chap21_concurrent;

public class CircularSet {
	private int[] array;
	private int len;
	private int index;

	public CircularSet(int size) {
		this.len = size;
		array = new int[size];

		for (int i = 0; i < len; i++) {
			array[i] = -1;
		}
	}

	public void add(int serial) {
		array[index] = serial;
		index = ++index % len;
	}

	public boolean isContain(int serial) {
		for (int i = 0; i < len; i++) {
			if (array[i] == serial) {
				return true;
			}
		}
		return false;
	}

}
