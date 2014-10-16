package com.java.thinkingin.chap21_concurrent;

import java.util.concurrent.TimeUnit;

class Daemon implements Runnable {
	private Thread []threads = new Thread[10];
	public void run() {
		for(int i=0; i<threads.length; i++) {
			threads[i] = new Thread(new DaemonSpawn());
			threads[i].start();
			System.out.println(Thread.currentThread() + " started!");
		}
		
		for(int i=0; i<threads.length; i++) {
			System.out.println(Thread.currentThread() + "isDaemon()" + threads[i].isDaemon());
		}
		while(true) {
			Thread.yield();
		}
	}
}

class DaemonSpawn implements Runnable {
	public void run() {
		while(true) {
			Thread.yield();
		}
	}
}

public class Daemons {
	public static void main(String args[]) throws Exception {
		Thread thread = new Thread(new Daemon());
		thread.setDaemon(true);
		thread.start();
		System.out.println(thread.getName() + "isdaemon()" + thread.isDaemon());
		System.out.println(Thread.currentThread() + "isdaemon()" + Thread.currentThread().isDaemon());
		TimeUnit.SECONDS.sleep(500);
	}
}
