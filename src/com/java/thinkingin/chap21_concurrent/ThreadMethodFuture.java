package com.java.thinkingin.chap21_concurrent;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class TaskWithResult implements Callable<String> {
	public String call() {
		try {
			TimeUnit.MILLISECONDS.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "result call ...";
	}
}

class ThreadMethod2 {
	private Thread thread;
	private String name;
	private ExecutorService exec;

	public ThreadMethod2(String name) {
		this.name = name;
	}

	public void runTask(int num) {
		if (thread == null) {
			thread = new Thread(name) {
				public void run() {
					System.out.println("runing ...");
				}
			};
		}

		thread.start();
	}

	public String runTask2(String name) throws Exception {
		this.name = name;
		if(exec == null) {
			exec = Executors.newCachedThreadPool();
		}
		Future<String> result = exec.submit(new Callable<String>() {
			public String call() {
				return "result call ...";
			}
		});
		
		return result.get();
	}
}

public class ThreadMethodFuture {
	public static void main(String args[]) {
		new ThreadMethod2("thread").runTask(5);

		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();

		Future<String> future = exec.submit(new TaskWithResult());
		while (true) {
			if (future.isDone()) {
				System.out.println("Task is done!");
				break;
			} else {
				System.out.println("Task is calling!");
				Thread.yield();
			}
		}
		
		try {
			System.out.println("result = " + new ThreadMethod2("thread").runTask2("hello"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
