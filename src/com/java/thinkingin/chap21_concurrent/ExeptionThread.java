package com.java.thinkingin.chap21_concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExeptionThread implements Runnable {
	public void run() {
		throw new RuntimeException();
	}

	public static void main(String args[]) {
		ExecutorService  exec = Executors.newCachedThreadPool();
		exec.execute(new ExeptionThread());
	}
}
