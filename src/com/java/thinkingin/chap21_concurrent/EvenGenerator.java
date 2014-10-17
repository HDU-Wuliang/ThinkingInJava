package com.java.thinkingin.chap21_concurrent;

public class EvenGenerator extends IntGenerator {
	private int currentEvenValue = 0;

	@Override
	public int next() {
		// TODO Auto-generated method stub
		++currentEvenValue;
		Thread.yield();
		++currentEvenValue;
		return currentEvenValue;
	}

	public static void main(String[] args) {
		EvenGenerator generator = new EvenGenerator();
		EvenChecker.test(generator);
	}
}
