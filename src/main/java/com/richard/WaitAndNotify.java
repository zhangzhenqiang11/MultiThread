package com.richard;

public class WaitAndNotify {

	public static void main(String[] args) {
		
	}
}

class MyTest extends Thread {

	public void run(){
		System.out.println("thread start "+Thread.currentThread().getName());
		
	}
	
}
