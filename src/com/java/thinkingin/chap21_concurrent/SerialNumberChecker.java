package com.java.thinkingin.chap21_concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SerialNumberChecker {
	private static final int size = 100;
	private static CircularSet set = new CircularSet(200000);
	private static ExecutorService exec = Executors.newCachedThreadPool();

	static class SerialChecker implements Runnable {
		// 任务
		public void run() {
			while (true) {
				int val = SerialNumberGenerator.nextSerialNumber();
				if (set.isContain(val)) {
					System.out.println("Duplicate :" + val);
					System.exit(0);
				}
				set.add(val);
			}
		}
	} 

	public static void main(String args[]) {
		// 创建线程竞争序列数
		for (int i = 0; i < size; i++) {
			exec.execute(new SerialChecker());
		}
		
		try {
			TimeUnit.MILLISECONDS.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("No Duplicate!");
		System.exit(0);
	}
}
