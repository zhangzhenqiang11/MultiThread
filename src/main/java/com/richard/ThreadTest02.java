package com.richard;

public class ThreadTest02  {

	public static void main(String[] args) {
		for(int i=0 ; i<13; i++){
			Thread  t2 = new Thread (new ThreadTest2(),"from main "+i);
			t2.start();
			
		}
	}

}
class ThreadTest2  implements Runnable{
	public void run() {
		System.out.println(Thread.currentThread().getName());
		
	}
}