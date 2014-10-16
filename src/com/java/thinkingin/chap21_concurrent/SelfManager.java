package com.java.thinkingin.chap21_concurrent;

public class SelfManager implements Runnable {
	private int countDown = 5;
	private Thread thread = new Thread(this);
	
	public SelfManager() {
		thread.start();
	}
	
	public String toString() {
		return Thread.currentThread().getName() + "(" + countDown + ")";
	}
	
	public void run() {
		while(true) {
			System.out.println(this);
			if(--countDown == 0) {
				return;
			}
		}	
	}
	
	public static void main(String args[]) {
		for(int i=0; i< 5; i++) {
			new SelfManager();
		}
	}
}
