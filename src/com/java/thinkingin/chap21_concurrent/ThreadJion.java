package com.java.thinkingin.chap21_concurrent;

import java.util.concurrent.TimeUnit;

class Sleeper extends Thread {
	private int sleepTime;

	public Sleeper(String name, int sleepTime) {
		super(name);
		this.sleepTime = sleepTime;
		start();
	}

	public void run() {
		try {
			TimeUnit.MILLISECONDS.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(getName() + " " + "was interrupted!");
		} finally {
			System.out.println(getName() + " " + "has done!");
		}
	}
}

class Joiner extends Thread {
	private Sleeper sleeper;
	
	public Joiner(String name, Sleeper sleeper) {
		super(name);
		this.sleeper = sleeper;
		start();
	}
	
	public void run() {
		try {
			sleeper.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Iterrupted!");
		}
		
		System.out.println(getName() + " " + "join completed!");
	}
}

public class ThreadJion {
	public static void main(String args[]) {
		Sleeper sleepy = new Sleeper("Sleepy", 3000);
		Sleeper grumpy = new Sleeper("Grumpy", 1500);
		
		Joiner dopey = new Joiner("Dopey", sleepy);
	}
}
