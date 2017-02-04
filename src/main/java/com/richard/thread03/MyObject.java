package com.richard.thread03;
/**
 * 对象锁的同步和异步问题
 * @author Richard
 * 同步：synchronized
      	同步的概念就是共享，我们要牢记住"共享"两个字，如果不是共享的资源，就没必要进行同步。
	异步：aschronized
      	异步的概念就是独立的，相互之间不受任何制约。就好像我们学习http的时候，在页面发起的ajax请求，我们还可以继续浏览或操作页面的内容，二者之间没有任何关系。
	同步的目的就是为了线程安全，其实对于线程安全来说，需要满足两个特性：
    	原子性（同步）
    	可见性
 */
public class MyObject {

	public synchronized void method1(){
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/** 非synchronized */
	public  void method2(){
		System.out.println(Thread.currentThread().getName());
	}
	
	
	
	/**
	 * 总结：
    	A线程先持有Object对象的Lock锁，B线程如果在这个时候调用对象中的同步（synchronized）方法则需等待，也就是同步
    	A线程先持有Object对象的Lock锁，B线程可以以异步的方式调用对象中的非synchronized修饰的方法
	 * @param args
	 */
	public static void main(String[] args) {
		
		final MyObject mo = new MyObject();
		
		Thread t1 =  new Thread(new Runnable() {
			public void run() {
				mo.method1();
			}
		},"t1");
	
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				mo.method2();
			}
		},"t2");
		
		t1.start();
		t2.start();
	}
}
