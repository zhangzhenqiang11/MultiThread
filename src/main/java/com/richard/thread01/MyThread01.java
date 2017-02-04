package com.richard.thread01;

public class MyThread01 extends Thread {


	private int count = 5;
	
	//synchronized加锁
	public synchronized void run(){
//	public  void run(){
		count --;
		System.out.println(Thread.currentThread().getName()+"  count = "+count);
	}
	
	/**
	 * 锁竞争：会导致CPU使用率飙升，可能导致应用程序非常慢，甚至更严的结果就是宕机，故应尽量避免锁竞争的问题。
	 * 如何避免锁竞争？
	 * 
	 * 分析：当多个线程访问MyThread01的run方法时，以排队的方式进行处理(这里的排队是按照CPU分配的先后顺序而定的)，
	 * 		一个线程想要执行synchronized修饰的方法里的代码时：
	 * 		1.尝试获得锁
	 * 		2.如果拿到锁，执行synchronized代码体内容；拿不到锁，这个线程就会尝试不断的获得这把锁，直到拿到为止，
	 * 		  而且是多个线程同时去竞争这把锁。也就是会有所竞争的问题。
	 * 
	 * 线程安全概念：当多个线程访问某一个类（对象或方法）时，这个类始终都能表现出正确的行为，那么这个类（对象或方法）就是
	 * 			线程安全的。
	 * 
	 * synchronized：可以在任意对象以及方法上加锁，而加锁的这段代码称为"互斥区"或"临界区"
	 */
	public static void main(String[] args) {
		MyThread01 thread = new MyThread01();
		Thread t1 = new Thread(thread,"t1");
		Thread t2 = new Thread(thread,"t2");
		Thread t3 = new Thread(thread,"t3");
		Thread t4 = new Thread(thread,"t4");
		Thread t5 = new Thread(thread,"t5");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

	}

}
