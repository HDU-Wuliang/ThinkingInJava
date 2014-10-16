package com.java.thinkingin.chap21_concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.*;

public class SleepingTask extends LiftOff {

	public void run() {
		try {
			while(countDown -- > 0) {
				System.out.println(status());
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Interrupted");
		}
	}
	
	public static void main(String []args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++) {
			executorService.execute(new SleepingTask());
		}
		executorService.shutdown();
	}
}
