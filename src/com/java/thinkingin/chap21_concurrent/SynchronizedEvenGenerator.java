package com.java.thinkingin.chap21_concurrent;

public class SynchronizedEvenGenerator extends IntGenerator {
	private int currentEvenValue = 0;

	@Override
	public synchronized int next() {
		// TODO Auto-generated method stub
		++currentEvenValue;
		Thread.yield();
		++currentEvenValue;

		return currentEvenValue;
	}

	public static void main(String[] args) {
		EvenChecker.test(new SynchronizedEvenGenerator());
	}
}
