package com.richard;

class MyThread2 extends Thread {
	boolean stop = false; // 引入一个布尔型的共享变量stop

	public void run() {
		while (!stop) // 通过判断stop变量的值来确定是否继续执行线程体
		{
			System.out.println(getName() + " is running");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Thread is exiting...");
	}
}

class InterruptThreadDemo2 {
	public static void main(String[] args) throws InterruptedException {
		MyThread2 m = new MyThread2();
		System.out.println("Starting thread...");
		m.start();
		Thread.sleep(3000);
		System.out.println("Interrupt thread...");
		m.stop = true; // 修改共享变量
		Thread.sleep(3000); // 主线程休眠以观察线程中断后的情况
		System.out.println("Stopping application...");
	}
}