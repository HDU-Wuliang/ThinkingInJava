package com.java.thinkingin.chap21_concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author LiangGe
 * 自定义线程工厂，创建线程全部使用后台线程
 */
class DaemonThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		// TODO Auto-generated method stub
		Thread thread= new Thread(r);
		// 设置为后台线程
		thread.setDaemon(true);
		return thread;
	}
}

public class DeamonFromFactory implements Runnable{
	
	public void run() {
		while(true) {
			try {
				TimeUnit.MILLISECONDS.sleep(100);
				if(Thread.currentThread().isDaemon()) {
					System.out.println(Thread.currentThread() + " " + this + " is Daemon thread");
				} else {
					System.out.println(Thread.currentThread() + " " + this + " is not Daemon thread");
				}
				
			} catch(InterruptedException e) {
				System.out.println("sleep() interrut!");
			}
		}
	}
	
	public static void main(String []args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
		for(int i=0; i<5; i++) {
			exec.execute(new DeamonFromFactory());
		}
		
		System.out.println("All thread started!");
		if(Thread.currentThread().isDaemon()) { 
			System.out.println("Main thread is daemon thread!");
		} else {
			System.out.println("Main thread is not daemon thread!");
		}
		
		TimeUnit.MILLISECONDS.sleep(500);
		System.out.println("cpu num = " + Runtime.getRuntime().availableProcessors());
	}
}
