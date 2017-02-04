package com.richard;

class MyThread3 extends Thread {
	volatile boolean stop = false;
/**
 * 一定要记住，m1.interrupt();语句只有当线程发生阻塞时才有效。
 * 它的作用就是抛出一个InterruptedException类的异常对象，
 * 使try…catch语句捕获异常，并对其进行处理。
 * 请读者仔细研究这个程序，以便能够看出其中的巧妙之处。
 */
	public void run() {
		while (!stop) {
			System.out.println(getName() + " is running");
			try {
				sleep(1000);
			} catch ( Exception e) {
				System.out.println("week up from blcok...");
				stop = true; // 在异常处理代码中修改共享变量的状态
			}
		}
		System.out.println(getName() + " is exiting...");
	}
}

class InterruptThreadDemo3 {
	public static void main(String[] args) throws InterruptedException {
		MyThread3 m1 = new MyThread3();
		System.out.println("Starting thread...");
		m1.start();
		Thread.sleep(3000);
		System.out.println("Interrupt thread...:" + m1.getName());
		m1.stop = true; // 设置共享变量为true
		m1.interrupt(); // 阻塞时退出阻塞状态
		Thread.sleep(3000); // 主线程休眠3秒以便观察线程m1的中断情况
		System.out.println("Stopping application...");
	}
}