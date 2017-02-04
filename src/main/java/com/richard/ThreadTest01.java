package com.richard;

public class ThreadTest01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadTest t1 = ThreadTest.getSingleton();
		t1.start();
		ThreadTest t2 = ThreadTest.getSingleton();
		t2.start();
//		thread.start();
//		ThreadTest thread2 = new ThreadTest();
//		thread2.start();
//		for (int i = 0; i < 10; i++) {
//			try {
//				Thread.sleep(1000);
//				System.out.println(  "main : "+i);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}
}

class ThreadTest extends Thread{
	
	static ThreadTest threadTest = null;
	public static ThreadTest getSingleton(){
		if(threadTest == null){
			threadTest = new ThreadTest(); 
		}
		return threadTest;
	}
	
	@Override
	public void run() {
//		for (int i = 0; i < 10; i++) {
			try {
//				System.out.println(this.currentThread().getName()+" : "+i);
				testFor();
			} catch ( Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		}
	}
	public synchronized void testFor(){
		for (int i = 0; i < 10; i++) {
				System.out.println(this.currentThread().getName()+" synchronized: "+i);
			 
		}
	}
	
}
