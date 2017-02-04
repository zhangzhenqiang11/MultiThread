package com.richard;

class MyThread extends Thread {
	public void run() {
		while (true) // 无限循环，并使线程每隔1秒输出一次字符串
		{
			System.out.println(getName() + " is running");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

class InterruptThreadDemo {
	public static void main(String[] args) throws InterruptedException {
		MyThread m = new MyThread(); // 创建线程对象m
		System.out.println("Starting thread...");
		m.start(); // 启动线程m
		Thread.sleep(2000); // 主线程休眠2秒，使线程m一直得到执行
		System.out.println("Interrupt thread...");
		m.interrupt(); // 调用interrupt()方法中断线程m
		Thread.sleep(2000); // 主线程休眠2秒，观察中断后的结果
		System.out.println("Stopping application..."); // 主线程结束
	}
}