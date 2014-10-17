package com.java.thinkingin.chap21_concurrent;

/**
 * 序列数生成
 * @author LiangGe
 *
 */
public class SerialNumberGenerator {
	private static volatile int serialNumber = 0;

	public static synchronized int nextSerialNumber() {
		return serialNumber++;  // 共享资源，非线程安全
	}
}
