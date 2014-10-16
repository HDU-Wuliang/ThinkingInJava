package com.java.thinkingin.chap21_concurrent;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class ExceptionThread2 implements Runnable {
	public void run() {
		Thread thread = Thread.currentThread();

		System.out.println("runing by " + thread.getName());
		System.out.println("eh:" + thread.getUncaughtExceptionHandler());

		throw new RuntimeException();
	}
}

class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {
	// 最终未捕获的异常通过未捕获异常处理函数
	public void uncaughtException(Thread thread, Throwable e) {

		System.out.println("Thread:" + thread.getName());
		System.out.println("caught " + e);

	}
}

class HandlerThreadFactory implements ThreadFactory {
	public Thread newThread(Runnable r) {
		System.out.println("start create new Thread");
		Thread thread = new Thread(r);
		thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		System.out.println("eh:" + thread.getUncaughtExceptionHandler());
		return thread;
	}
}

public class CaptureUnCaughtException {
	public static void main(String[] args) {
		ExecutorService exec = Executors
				.newCachedThreadPool(new HandlerThreadFactory());
		exec.execute(new ExceptionThread2());
	}
}
