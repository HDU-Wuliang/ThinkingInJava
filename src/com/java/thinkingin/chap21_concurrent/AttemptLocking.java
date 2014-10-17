package com.java.thinkingin.chap21_concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用tryLock尝试获取锁，以及tryLock等待时间获取锁
 * 
 * @author LiangGe
 */
public class AttemptLocking {
	private ReentrantLock lock = new ReentrantLock();

	public void untime() {
		boolean captured = lock.tryLock();
		// 不管tryLock成功与否，都往下执行,不阻塞等待
		try {
			System.out.println("captured : " + captured);
		} finally {
			if (captured) {
				lock.unlock();
			}
		}
	}

	public void time() {
		boolean captured = false;
		try {
			// 尝试5秒等待获取锁
			captured = lock.tryLock(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println("tryLock(5, TimeUnit.SECONDS) captured : "
					+ captured);
		} finally {
			if (captured) {
				lock.unlock();
			}
		}
	}

	public static void main(String args[]) {
		final AttemptLocking attemp = new AttemptLocking();
		
		attemp.untime();
		attemp.time();

		new Thread() {
			public void run() {
				// 此时存在两个线程互斥访问，就产生竞争关系
				attemp.lock.lock();
			}
		}.start();

		Thread.yield();

		attemp.untime();
		attemp.time();
	}
}
