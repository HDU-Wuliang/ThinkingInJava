package com.java.thinkingin.chap21_concurrent;


public class Counter extends Thread {
	public static int n = 0;

	public void run() {
		for (int i = 0; i < 10; i++)
			try {
				n = n + 1;
				sleep(100); // 为了使运行结果更随机，延迟3毫秒

			} catch (Exception e) {
			}
	}

	public static void main(String[] args) throws Exception {

		Thread threads[] = new Thread[1000];
		for (int i = 0; i < threads.length; i++)
			// 建立100个线程
			threads[i] = new Counter();
		for (int i = 0; i < threads.length; i++)
			// 运行刚才建立的100个线程
			threads[i].start();
		for (int i = 0; i < threads.length; i++)
			// 100个线程都执行完后继续
			threads[i].join();
		System.out.println(" n= " + Counter.n);
	}
}
