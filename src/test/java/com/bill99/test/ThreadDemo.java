package com.bill99.test;


class Mythread extends Thread{

//	AtomicInteger ticket = new AtomicInteger(5);
	 volatile int ticket =5;
	
//	public void run(){
//			for (int i = 0; i < 10; i++) {
//				int a= ticket.get();
//				if(a > 0){
//					System.out.println("ticket = "+a+"  "+Thread.currentThread().getName());
//				}
//				ticket.decrementAndGet();
//		}
//		
//	}
	
	public void run(){
		for (int i = 0; i < 10; i++) {
			if(ticket > 0){
				System.out.println("ticket = "+ticket--+"  "+Thread.currentThread().getName());
			}
	}
	
}
	
	
}
 public class ThreadDemo{
	 public static void main(String[] args) {
//		thread();
		 thread2();
	}

	public static void thread2() {
		Mythread t = new Mythread();
		 new Thread(t).start();
		 new Thread(t).start();
		 new Thread(t).start();
	}

	public static void thread() {
		new Mythread().start();
		new Mythread().start();
		new Mythread().start();
		new Mythread().start();
		Thread thread = new Thread(new Mythread(),"thread  invoke");
		thread.start();
	}
 }
