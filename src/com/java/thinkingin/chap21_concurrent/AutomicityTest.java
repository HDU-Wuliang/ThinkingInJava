package com.java.thinkingin.chap21_concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 程序找到奇数值停止
 * @author LiangGe
 *
 */
public class AutomicityTest implements Runnable {
	private int evenValue = 0;
	/**
	 * 如果不加synchronized 则getEvenValue时 自增可能处于不稳定的中间状态
	 */
	public synchronized int getEvenValue() {
		return evenValue;
	}

	public synchronized void evenIncrement() {
		// 增加操作在jvm执行指令则分为读取，自增，写入，整个流程不是原子性操作
		evenValue++;
		evenValue++;
	}

	public void run() {
		while (true) {
			evenIncrement();
		}
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		AutomicityTest automic = new AutomicityTest();

		for (int i = 0; i < 3; i++) {
			exec.execute(automic);
		}
		
		while(true) {
			int val = automic.getEvenValue();
			if(val % 2 != 0) {
				System.out.println("val = " + val);
				System.exit(0);
			}
		}
	}

}
