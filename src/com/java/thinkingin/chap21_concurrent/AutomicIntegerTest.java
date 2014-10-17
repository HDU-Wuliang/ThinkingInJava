package com.java.thinkingin.chap21_concurrent;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger 可以用原子方式更新的 int 值
 * 
 * @author LiangGe
 * 
 */
public class AutomicIntegerTest implements Runnable {
	AtomicInteger atomic = new AtomicInteger(0);

	public int getAtomicInteger() {
		return atomic.get();
	}

	public void increment() {
		// 加2, 以原子方式将给定值与当前值相加。
		// 不需要关键字synchronized
		atomic.addAndGet(2);
	}

	public void run() {
		while (true) {
			increment();
		}
	}

	public static void main(String args[]) {
		// schedule 在5秒之后执行TimerTask
		new Timer().schedule(new TimerTask() {
			public void run() {
				System.out.println("Aborting");
				System.exit(0);
			}
		}, 5000);

		ExecutorService exec = Executors.newCachedThreadPool();
		AutomicIntegerTest automicIntegerTest = new AutomicIntegerTest();
		for (int i = 0; i < 10; i++) {
			exec.execute(automicIntegerTest);
		}

		while (true) {
			int val = automicIntegerTest.getAtomicInteger();
			if (val % 2 != 0) {
				System.out.println("val = " + val);
				// Terminates the currently running Java Virtual Machine.
				System.exit(0);
			}
		}

	}
}
