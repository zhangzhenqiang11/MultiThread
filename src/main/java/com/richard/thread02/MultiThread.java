package com.richard.thread02;

public class MultiThread {

	/* static */
	private  static int num = 0;
	
	/* static */
	/**
	 * 总结：关键字synchronized取得的锁都是对象锁，而不是把一段代码（或方法）当做锁，所以，示例代码中哪个线程先执行
	 * 	   synchronized关键字的方法，哪个线程就持有该方法所属对象的锁(LOCK)，两个对象，线程获得的就是两个不同的锁，他们互不影响。
		         有一种情况是相同的锁，即在静态方法上加上synchronized关键字，表示锁定.class类，类一级别的锁（独占锁）。
	 */
	public synchronized static void printNum(String tag){
		
		try {
			if(tag.equals("a")){
				num =100;
				System.out.println("tag a , set num over");
				Thread.sleep(1000);
			}else{
				num = 200;
				System.out.println("tag b , set num over");
				Thread.sleep(1000);
			}
			
			System.out.println("tag = "+tag+" ,num = "+num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 注意观察run方法的输出顺序
	 * 多个线程多个锁：多个线程，每个线程都可以拿到自己制定的锁，分别获得锁之后执行synchronized方法体的内容。
	 */
	public static void main(String[] args) {
		
		final MultiThread m1 = new MultiThread();
		final MultiThread m2 = new MultiThread();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				m1.printNum("a");
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				m2.printNum("b");
			}
		});
		
		t1.start();
		t2.start();
	}
}
