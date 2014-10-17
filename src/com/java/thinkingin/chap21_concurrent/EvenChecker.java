package com.java.thinkingin.chap21_concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {
	private IntGenerator generator;
	private final int id;

	public EvenChecker(IntGenerator ge, int id) {
		this.generator = ge;
		this.id = id;
	}

	public void run() {
		while (!generator.isCanceled()) {
			int val = generator.next();
			if (val % 2 != 0) {
				System.out.println(val + "not even!");
				generator.cancel();
			}
			if(val == 10000) {
				System.out.println("val = " + 10000);
				generator.cancel();
			}
		}
	}

	public static void test(IntGenerator ge, int count) {
		System.out.println("press Ctrol-c to exit");
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < count; i++) {
			exec.execute(new EvenChecker(ge, count));
		}
		exec.shutdown();
	}

	public static void test(IntGenerator ge) {
		test(ge, 10);
	}
}
