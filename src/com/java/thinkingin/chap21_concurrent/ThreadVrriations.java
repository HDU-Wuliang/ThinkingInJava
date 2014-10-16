package com.java.thinkingin.chap21_concurrent;

import java.util.concurrent.TimeUnit;

class InnerThread1 {
	private int countDown = 5;
	private Inner inner;

	private class Inner extends Thread {
		public Inner(String name) {
			super(name);
			start();
		}

		public void run() {
			try {
				while (true) {
					System.out.println(this);
					if (--countDown == 0) {
						return;
					}
					sleep(100);
				}
			} catch (InterruptedException e) {
				System.out.println("Thread interrupt");
			}
		}

		public String toString() {
			return getName() + ":" + countDown;
		}
	}

	public InnerThread1(String name) {
		inner = new Inner(name);
	}
}

class InnerThread2 {
	private int countDown = 5;
	private Thread thread;

	public InnerThread2(String name) {
		thread = new Thread(name) {
			public void run() {
				try {
					while (true) {
						System.out.println(this);
						if (--countDown == 0) {
							return;
						}
						sleep(100);
					}
				} catch (InterruptedException e) {
					System.out.println("interrupted!");
				}
			}

			public String toString() {
				return Thread.currentThread().getName() + ":" + countDown;
			}
		};

		thread.start();
	}
}

class InnerThread3 {
	private Inner inner;
	private int countDown = 5;
	private class Inner implements Runnable {
		private Thread thread;

		public Inner(String name) {
			thread = new Thread(this, name);
			thread.start();
		}

		public void run() {
			try {
				while(true) {
					System.out.println(this);
					if(--countDown == 0) {
						return;
					}
					TimeUnit.MILLISECONDS.sleep(100);
				}	
			} catch (InterruptedException e) {
				System.out.println("interrupted!");
			}
		}
		
		public String toString() {
			return Thread.currentThread().getName() + ":" + countDown;
		}
	}

	public InnerThread3(String name) {
		inner = new Inner(name);
	}
}

class ThreadMethod {
	private int countDown = 5;
	private String name;
	private Thread thread;
	public ThreadMethod(String name) {
		this.name = name;
	}
	
	public void runTask() {
		if(thread == null) {
			thread = new Thread(name) {
				public void run() {
					try {
						while(true) {
							System.out.println(this);
							if(--countDown == 0) {
								return;
							}
							TimeUnit.MILLISECONDS.sleep(100);
						}	
					} catch (InterruptedException e) {
						System.out.println("interrupted!");
					}
				}
				
				public String toString() {
					return Thread.currentThread().getName() + ":" + countDown;
				}
			};
		}
		
		thread.start();
	}
}

public class ThreadVrriations {
	public static void main(String args[]) {
		// InnerThread1 thread1 = new InnerThread1("inner1");

		// InnerThread2 thread2 = new InnerThread2("inner2");
		
		// InnerThread3 thread3 = new InnerThread3("inner3");
		
		new ThreadMethod("threadMethod").runTask();
	}
}
