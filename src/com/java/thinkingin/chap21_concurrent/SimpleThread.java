package com.java.thinkingin.chap21_concurrent;

public class SimpleThread extends Thread {
	
	public void run() {
		System.out.println("SimpleThread ... ");
	}
	
	public static void main(String args[]) {
		SimpleThread thread = new SimpleThread();
		thread.start();
	}
}
